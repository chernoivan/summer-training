package com.chernoivan;

public class View {
    public static final String EQUAL_SING = "=";
    public static final String SPACE_SING = " ";
    public static final String OPENS_SQUARE_BRACKET = "[";
    public static final String CLOSING_SQUARE_BRACKET = "]";

    public static final String INPUT_INTEGER_DATA = "Input your number";
    public static final String INPUT_INTEGER_DATA_ERROR = "Wrong data. ";
    public static final String INPUT_DATA_OUT_OF_RANGE = "Wrong number. ";
    public static final String INPUT_NUMBER_IS_RIGHT = "Right number! Congratulations!!!";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String concatenationString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }
}
