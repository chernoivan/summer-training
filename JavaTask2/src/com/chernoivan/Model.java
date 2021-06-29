package com.chernoivan;

import java.util.ArrayList;

public class Model {

    private View view = new View();

    public ArrayList<Integer> numbers = new ArrayList();

    public Integer rightNumber = (int) (Math.random() * 100);

    public void numberSearcher(Integer number) {
        if (number > 100 || number < 0) {
            view.printMessage(View.INPUT_DATA_OUT_OF_RANGE);
        } else if (number > rightNumber) {
            view.printMessage(View.INPUT_NUMBER_TO_HIGH);
            setNumberToArray(number);
        } else if (number < rightNumber) {
            view.printMessage(View.INPUT_NUMBER_TO_LOW);
            setNumberToArray(number);
        } else {
            view.printMessage(View.INPUT_NUMBER_IS_RIGHT);
            setNumberToArray(number);
            view.printAllNumbers(getAllAttempts());
        }
        getAllAttempts();
    }

    public Integer getRightNumber() {
        return rightNumber;
    }

    public ArrayList getAllAttempts() {
        return numbers;
    }

    public void setNumberToArray(Integer number) {
        numbers.add(number);
    }

}
