package main.controller;

import main.model.ExpressionEvaluator;
import main.view.ConsoleView;
import main.model.SyntaxException;

public class CalculatorController {
    private final ExpressionEvaluator model;
    private final ConsoleView view;

    public CalculatorController(ExpressionEvaluator model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void process() {
        while (true) {
            String input = view.getInput();
            if (input.isEmpty()) break;
            try {
                double result = model.evaluate(input);
                view.displayResult(result);
            } catch (SyntaxException | ArithmeticException e) {
                view.displayError(e.getMessage());
            }
        }
    }
}