package main;

import main.controller.CalculatorController;
import main.model.ExpressionEvaluator;
import main.view.ConsoleView;

public class App {
    public static void main(String[] args) {
        ExpressionEvaluator model = new ExpressionEvaluator();
        ConsoleView view = new ConsoleView();
        CalculatorController controller = new CalculatorController(model, view);
        controller.process();
    }
}