package main;

import main.config.DatabaseConfig;
import main.controller.*;
import main.model.Candidate;
import main.model.User;
import main.service.*;
import main.utils.AuditLogger;
import main.utils.ValidationUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    private static final AuthService authService = new AuthService();
    private static final VotingService votingService = new VotingService();
    private static final CandidateService candidateService = new CandidateService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        initializeDatabase();
        AuditLogger.log("Application started");
        
        while (true) {
            System.out.println("\nСистема электронного голосования");
            System.out.println("1. Вход");
            System.out.println("2. Регистрация");
            System.out.println("3. Выход");
            System.out.print("Выберите действие: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    AuditLogger.log("Application stopped");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
    private static void initializeDatabase() {
        try (Connection conn = DatabaseConfig.getConnection();
            Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(new String(
                App.class.getResourceAsStream("/init.sql").readAllBytes()));
        } catch (Exception e) {
            System.err.println("Ошибка инициализации БД: " + e.getMessage());
        }
    }

    private static void login() throws SQLException {
        System.out.print("Логин: ");
        String login = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();

        User user = authService.authenticate(login, password);
        if (user == null) {
            System.out.println("Ошибка аутентификации!");
            return;
        }

        AuditLogger.log("User logged in: " + user.getLogin());
        showRoleBasedMenu(user);
    }

    private static void register() {
        System.out.println("\n=== Регистрация нового пользователя ===");
        
        // Ввод данных
        System.out.print("Введите ФИО: ");
        String fullName = scanner.nextLine();
        
        System.out.print("Введите дату рождения (дд.мм.гггг): ");
        String birthDateStr = scanner.nextLine();
        
        System.out.print("Введите СНИЛС (формат: XXX-XXX-XXX XX): ");
        String snils = scanner.nextLine();
        
        System.out.print("Придумайте логин: ");
        String login = scanner.nextLine();
        
        System.out.print("Придумайте пароль: ");
        String password = scanner.nextLine();

        // Валидация данных
        if (!ValidationUtils.isValidBirthDate(birthDateStr)) {
            System.out.println("Ошибка: Некорректная дата рождения");
            return;
        }
        
        if (!ValidationUtils.isValidSNILS(snils)) {
            System.out.println("Ошибка: Некорректный формат СНИЛС");
            return;
        }
        
        if (authService.authenticate(login, password) != null) {
            System.out.println("Ошибка: Пользователь с таким логином уже существует");
            return;
        }

        try {
            // Создание пользователя
            LocalDate birthDate = LocalDate.parse(birthDateStr, 
                DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                
            User newUser = new User(login, password, User.Role.USER);
            newUser.setFullName(fullName);
            newUser.setSnils(snils);
            newUser.setBirthDate(birthDate);

            // Сохранение пользователя
            authService.registerUser(newUser);
            System.out.println("Регистрация прошла успешно! Теперь вы можете войти в систему.");

        } catch (Exception e) {
            System.out.println("Ошибка регистрации: " + e.getMessage());
        }
    }

    private static void showRoleBasedMenu(User user) throws SQLException {
        switch (user.getRole()) {
            case ADMIN:
                new AdminController(authService, votingService, candidateService).start();
                break;
            case CEC:
                new CECController(votingService).start();
                break;
            case CANDIDATE:
                Candidate candidate = candidateService.getCandidateByUser(user);
                if (candidate != null) {
                    new CandidateController(candidateService).start(candidate);
                }
                break;
            case USER:
                new UserController(votingService, candidateService).start(user);
                break;
            default:
                throw new IllegalStateException("Неизвестная роль");
        }
    }
}