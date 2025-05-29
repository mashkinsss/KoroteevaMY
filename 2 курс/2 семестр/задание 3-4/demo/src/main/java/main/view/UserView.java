package main.view;

import main.model.Voting;
import main.model.Candidate;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\nМеню пользователя:");
        System.out.println("1. Проголосовать");
        System.out.println("2. Просмотреть кандидатов");
        System.out.println("3. История голосований");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void displayRegistrationForm() {
        System.out.println("\n=== Регистрация пользователя ===");
    }

    public void displayError(String message) {
        System.out.println("Ошибка: " + message);
    }

    public void displaySuccess(String message) {
        System.out.println("Успех: " + message);
    }

    public void displayInfo(String message) {
        System.out.println("Информация: " + message);
    }

    public void displayVotings(List<Voting> votings) {
        System.out.println("\nАктивные голосования:");
        votings.forEach(v -> System.out.println(v.getId() + " | " + v.getTitle()));
    }

    public void displayCandidates(List<Candidate> candidates) {
        System.out.println("\nСписок кандидатов:");
        candidates.forEach(c -> System.out.println(c.getId() + " | " + c.getName()));
    }

    public void displayVotingHistory(List<Voting> history) {
        System.out.println("\nИстория голосований:");
        history.forEach(v -> System.out.println(v.getTitle() + " | " + v.getEndDate()));
    }

    public void promptForRegistration() {
        System.out.println("\n=== Регистрация ===");
    }

    public void showError(String message) {
        System.out.println("[Ошибка] " + message);
    }

    public void showSuccess(String message) {
        System.out.println("[Успех] " + message);
    }

    public void showVotings(List<Voting> votings) {
        votings.forEach(v -> System.out.println(v.getId() + " | " + v.getTitle()));
    }

    public void showCandidates(List<Candidate> candidates) {
        candidates.forEach(c -> System.out.println(c.getId() + " | " + c.getName()));
    }

}