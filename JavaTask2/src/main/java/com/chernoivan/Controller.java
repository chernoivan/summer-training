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

        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);

        model.setRightNumber();

        while (model.numberSearcher(inputIntegerValueWithScanner(scanner))) ;

        view.printMessage(View.INPUT_NUMBER_IS_RIGHT);
        view.printMessage(String.valueOf(model.getAllAttempts()));
    }

    public Integer inputIntegerValueWithScanner(Scanner scanner) {
        int res = 0;
        view.printMessage(getInputIntMessage());
        while (true) {
            while (!scanner.hasNextInt()) {
                view.printMessage(View.INPUT_INTEGER_DATA_ERROR + getInputIntMessage());
                scanner.next();
            }
            if ((res = scanner.nextInt()) <= model.getMinBarrier() ||
                    res >= model.getMaxBarrier()) {
                view.printMessage(View.INPUT_DATA_OUT_OF_RANGE + getInputIntMessage());
                continue;
            }
            break;
        }
        return res;
    }

    private String getInputIntMessage() {
        return view.concatenationString(
                View.INPUT_INTEGER_DATA, View.OPENS_SQUARE_BRACKET,
                String.valueOf(model.getMinBarrier()), View.SPACE_SING,
                String.valueOf(model.getMaxBarrier()),
                View.CLOSING_SQUARE_BRACKET, View.SPACE_SING,
                View.EQUAL_SING, View.SPACE_SING);
    }
}
