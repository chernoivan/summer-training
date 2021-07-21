package com.chernoivan;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ElementsCounter counter = new ElementsCounter();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(-1);

        System.out.println("Count all with frequency");

        counter.Counter(list);
    }
}
