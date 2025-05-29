package main.view;

import main.model.Voting;
import java.util.List;
import java.util.Scanner;

public class CandidateView {
    private final Scanner scanner = new Scanner(System.in);
    public void showMenu() {
        System.out.println("\nМеню кандидата:");
        System.out.println("1. Обновить профиль");
        System.out.println("2. Просмотреть предыдущие результаты");
        System.out.println("3. Все участия в голосованиях");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    public void displayPreviousResults(List<Voting> votings) {
        System.out.println("\nИстория результатов:");
        for (Voting v : votings) {
            System.out.println(v.getTitle() + " | Голосов: " + v.getTotalVotes());
        }
    }

    public void displayAllParticipations(List<Voting> participations) {
        System.out.println("\nВсе участия:");
        for (Voting v : participations) {
            System.out.println(v.getTitle() + " | Статус: " + (v.isActive() ? "Активно" : "Завершено"));
        }
    }

    public void showProfileUpdateSuccess() {
        System.out.println("Профиль успешно обновлен!");
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void showError(String message) {
        System.out.println("Ошибка: " + message);
    }
}