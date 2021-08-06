package com.chernoivan;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
	    int[] arr = new int[15];

	    for (int i = 0; i<arr.length; i++) {
	        arr[i] = (int) (Math.random() * 10);
        }

	    for (int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("min = " + Arrays.stream(arr).min().getAsInt());
        System.out.println("avg = " + Arrays.stream(arr).average().getAsDouble());
        System.out.println("zero elements count = " + Arrays.stream(arr).filter(value -> value == 0).count());
        System.out.println("zero elements count = " + Arrays.stream(arr).filter(value -> value > 0).count());
        Arrays.stream(arr).map(number -> number * 3).forEach(System.out::println);
    }
}
