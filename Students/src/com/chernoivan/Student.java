package com.chernoivan;

import java.util.Objects;

public final class Student {

    private final String name;
    private final int age;
    private final String group;

    public Student(String name, int age, String group) {
         this.name = name;
         this.age = age;
         this.group = group;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        return new Student(name, this.age, this.group);
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        return new Student(this.name, age, this.group);
    }

    public String getGroup() {
        return group;
    }

    public Student setGroup(String group) {
        return new Student(this.name, this.age, group);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && name.equals(student.name) && group.equals(student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, group);
    }
}
