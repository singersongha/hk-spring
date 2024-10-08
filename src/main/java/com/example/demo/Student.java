package com.example.demo;

public class Student {
    public String name;
    public int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {
        this.name = "이세연";
        this.age = 23;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
