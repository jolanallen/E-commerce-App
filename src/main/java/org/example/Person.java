package org.example;

import lombok.Getter;

@Getter
abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Méthode abstraite que chaque sous-classe doit implémenter
    public abstract void printStudentInfo();
}
