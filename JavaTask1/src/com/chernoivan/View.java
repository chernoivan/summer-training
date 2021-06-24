package com.chernoivan;

public class View {
    public static final String INPUT_STRING_DATA = "Input word = ";
    public static final String INPUT_STRING_DATA_HELLO = "Input word \"Hello\"! ";
    public static final String INPUT_STRING_DATA_WORLD = "Input word \"world\" ";
    public static final String OUR_STRING = "Sentence = ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessageAndWord(String message, String word) {
        System.out.println(message + word);
    }
}
