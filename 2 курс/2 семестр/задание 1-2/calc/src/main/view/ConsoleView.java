package main.view;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public String getInput() {
        System.out.print("Enter equation: ");
        return scanner.nextLine().replaceAll("\\s+", "");
    }

    public void displayResult(double result) {
        System.out.println("Result: " + result);
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }
}