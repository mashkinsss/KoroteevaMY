package main.view;

import java.util.List;
import java.util.Scanner;
import main.model.User;
import main.model.Candidate;

public class AdminView {
    private final Scanner scanner = new Scanner(System.in);

    public void showAdminMenu() {
        System.out.println("\nАдминистраторское меню:");
        System.out.println("1. Управление пользователями");
        System.out.println("2. Управление ЦИК");
        System.out.println("3. Управление кандидатами");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    public int getChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void displayUsers(List<User> users) {
        System.out.println("\nСписок пользователей:");
        users.forEach(u -> System.out.println(u.getLogin() + " | " + u.getRole()));
    }

    public String promptForLogin() {
        System.out.print("\nВведите логин для удаления: ");
        return scanner.nextLine();
    }

    public void showSuccess(String message) {
        System.out.println("Успех: " + message);
    }

    public void displayCandidates(List<Candidate> candidates) {
        System.out.println("\nСписок кандидатов:");
        candidates.forEach(c -> System.out.println(c.getId() + " | " + c.getName()));
    }
}