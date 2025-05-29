package main.controller;

import main.model.User;
import main.model.Voting;
import main.model.Candidate;
import main.service.VotingService;
import main.service.CandidateService;
import main.utils.ValidationUtils;
import main.view.UserView;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class UserController {
    private final VotingService votingService;
    private final CandidateService candidateService;
    private final UserView view;
    private final Scanner scanner;
    private User currentUser;

    public UserController(VotingService votingService, CandidateService candidateservice) {
        this.votingService = votingService;
        this.candidateService = candidateservice;

        this.view = new UserView();
        this.scanner = new Scanner(System.in);
    }

    public void start(User user) throws SQLException {
        this.currentUser = user;
        boolean running = true;
        while (running) {
            view.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    vote();
                    break;
                case 2:
                    viewCandidates();
                    break;
                case 3:
                    viewVotingHistory();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    view.displayError("Неверный выбор");
            }
        }
    }

    public void registerUser() {
        view.displayRegistrationForm();
        
        String fullName = view.getInput("Введите ФИО: ");
        String birthDate = view.getInput("Введите дату рождения (дд.мм.гггг): ");
        String snils = view.getInput("Введите СНИЛС (формат: XXX-XXX-XXX XX): ");
        String login = view.getInput("Придумайте логин: ");
        String password = view.getInput("Придумайте пароль: ");

        if (!ValidationUtils.isValidBirthDate(birthDate) || !ValidationUtils.isValidSNILS(snils)) {
            view.displayError("Некорректные данные!");
            return;
        }

        User newUser = new User(login, password, User.Role.USER);
        newUser.setFullName(fullName);
        newUser.setSnils(snils);
        newUser.setBirthDate(LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        
        view.displaySuccess("Регистрация успешна!");
    }

    private void vote() throws SQLException {
        List<Voting> activeVotings = votingService.getActiveVotings();
        if (activeVotings.isEmpty()) {
            view.displayInfo("Нет активных голосований");
            return;
        }
        
        view.displayVotings(activeVotings);
        String votingId = view.getInput("Выберите голосование (ID): ");
        Voting voting = votingService.getVotingById(votingId);

        if (voting == null || !voting.isActive()) {
            view.displayError("Голосование не найдено или завершено");
            return;
        }

        List<Candidate> candidates = candidateService.getAllCandidates();
        view.displayCandidates(candidates);
        String candidateId = view.getInput("Выберите кандидата (ID): ");

        Candidate selected = candidates.stream()
            .filter(c -> c.getId().equals(candidateId))
            .findFirst()
            .orElse(null);

        if (selected != null) {
            votingService.addVote(currentUser, voting, selected);
            view.displaySuccess("Ваш голос учтен!");
        } else {
            view.displayError("Неверный выбор кандидата");
        }
    }

    private void viewCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();
        view.displayCandidates(candidates);
    }

    private void viewVotingHistory() {
        List<Voting> history = votingService.getVotingHistory(currentUser.getId());
        view.displayVotingHistory(history);
    }
}