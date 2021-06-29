package com.chernoivan;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);

        Integer inputValue = inputIntegerValueWithScanner(scanner);

        if (!inputValue.equals(model.getRightNumber())) {
            model.numberSearcher(inputValue);
            processUser();
        } else {
            model.numberSearcher(inputValue);
        }
    }

    public Integer inputIntegerValueWithScanner(Scanner scanner) {
        view.printMessage(View.INPUT_INTEGER_DATA);
        while (!scanner.hasNextInt()) {
            view.printMessage(View.INPUT_INTEGER_DATA_ERROR);
            scanner.next();
        }
        return scanner.nextInt();
    }
}
