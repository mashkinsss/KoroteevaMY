package main.view;

import java.util.Scanner;

public class CECView {
    private final Scanner scanner = new Scanner(System.in);

    public void showCECMenu() {
        System.out.println("\nМеню ЦИК:");
        System.out.println("1. Создать голосование");
        System.out.println("2. Добавить кандидата");
        System.out.println("3. Просмотреть результаты");
        System.out.println("4. Экспорт в PDF");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    public String promptForVotingId() {
        System.out.print("\nВведите ID голосования: ");
        return scanner.nextLine();
    }

    public String promptForTitle() {
        System.out.print("Введите название голосования: ");
        return scanner.nextLine();
    }

    public String promptForEndDate() {
        System.out.print("Введите дату окончания (ГГГГ-ММ-ДДЧЧ:ММ): ");
        return scanner.nextLine();
    }

    public String promptForCandidateId() {
        System.out.print("Введите ID кандидата: ");
        return scanner.nextLine();
    }

    public String promptForCandidateName() {
        System.out.print("Введите имя кандидата: ");
        return scanner.nextLine();
    }

    public String promptForCandidateBio() {
        System.out.print("Введите биографию: ");
        return scanner.nextLine();
    }

    public String promptForFilePath(String defaultPath) {
        System.out.printf("Введите путь для сохранения [%s]: ", defaultPath);
        return scanner.nextLine();
    }

    public void showError(String message) {
        System.out.println("✗ Ошибка: " + message);
    }

    public void showSuccess(String message) {
        System.out.println("✓ " + message);
    }

    public int getChoice() {
        return scanner.nextInt();
    }

    public void clearBuffer() {
        scanner.nextLine();
    }
}