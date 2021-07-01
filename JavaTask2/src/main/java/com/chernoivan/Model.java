package com.chernoivan;

import java.util.ArrayList;

public class Model {

    private int minBarrier;
    private int maxBarrier;

    public ArrayList<Integer> numbers = new ArrayList();

    public Integer rightNumber;

    public boolean numberSearcher(Integer number) {
        numbers.add(number);
        if (number > rightNumber) {
            maxBarrier = number;
        } else if (number < rightNumber) {
            minBarrier = number;
        } else {
            return false;
        }
        return true;
    }

    public void setRightNumber() {
        rightNumber = (int) Math.ceil(Math.random() *
                (maxBarrier - minBarrier - 1) + minBarrier);
    }

    public void setPrimaryBarrier(int minBarrier, int maxBarrier) {
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public ArrayList getAllAttempts() {
        return numbers;
    }

}
