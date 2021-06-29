package com.chernoivan;

import java.util.ArrayList;

public class View {
    public static final String INPUT_INTEGER_DATA = "Input your number";
    public static final String INPUT_INTEGER_DATA_ERROR = "Wrong data. Please input number";
    public static final String INPUT_DATA_OUT_OF_RANGE = "Wrong number. Please input number in range [0-100]";
    public static final String INPUT_NUMBER_TO_LOW = "Please write higher number";
    public static final String INPUT_NUMBER_TO_HIGH = "Please write lower number";
    public static final String INPUT_NUMBER_IS_RIGHT = "Right number! Congratulations!!!";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printAllNumbers(ArrayList number) {
        System.out.println(number);
    }
}
