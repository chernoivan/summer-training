package com.chernoivan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ElementsCounter {
    public void Counter(ArrayList<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        set.forEach( s -> System.out.println(s + ": " + Collections.frequency(list, s)));
    }
}
