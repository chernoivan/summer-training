package com.chernoivan;

public class Main {

    public static void main(String[] args) {
        Student student = new Student("Alex", 18, "myGroup");
        student = student.setName("Alexander");
        System.out.println("name: " + student.getName()
                + "\nage: " + student.getAge()
                + "\ngroup: " + student.getGroup());
    }
}
