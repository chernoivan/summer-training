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

        model.setFirstWord(inputFirstStringValueWithScanner(scanner));
        model.setSecondWord(inputSecondStringValueWithScanner(scanner));

        view.printMessageAndWord(View.OUR_STRING, model.getSentence());
    }

    public String inputFirstStringValueWithScanner(Scanner scanner) {
        view.printMessage(View.INPUT_STRING_DATA);
        while ( ! scanner.hasNext("Hello")) {
            view.printMessage(View.INPUT_STRING_DATA_HELLO + View.INPUT_STRING_DATA);
            scanner.next();
        }
        return scanner.next();
    }

    public String inputSecondStringValueWithScanner(Scanner scanner) {
        view.printMessage(View.INPUT_STRING_DATA);
        while ( ! scanner.hasNext("world")) {
            view.printMessage(View.INPUT_STRING_DATA_WORLD + View.INPUT_STRING_DATA);
            scanner.next();
        }
        return scanner.next();
    }
}
