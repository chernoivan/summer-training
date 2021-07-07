package com.chernoivan.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.chernoivan.view.TextConstant.INPUT_STRING_DATA;
import static com.chernoivan.view.TextConstant.WRONG_INPUT_DATA;

public class View {

    static String MESSAGE_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle = ResourceBundle.getBundle(
            //MESSAGE_BUNDLE_NAME, new Locale("en"));
            MESSAGE_BUNDLE_NAME, new Locale("ua", "UA"));

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String concatenationString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for(String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    public void printStringInput (String message) {
        printMessage(concatenationString(
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message)));
    }

    public void printWrongStringInput(String message) {
        printMessage(concatenationString(
                bundle.getString(WRONG_INPUT_DATA),
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message)));
    }
}
