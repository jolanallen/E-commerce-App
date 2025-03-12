package org.example;

import java.util.ArrayList;

import lombok.Getter;

@Getter
abstract class Student extends Person {
    protected int studentId;
    protected ArrayList<Float> grades = new ArrayList<>();

    public Student(String name, int studentId, int age) {
        super(name, age);
        this.studentId = studentId;
    }

    //add new grade
    public void addGrade(Float grade) {
        grades.add(grade);
    }

    // abstract average method
    public abstract Float getAverageGrade();

    @Override
    public void printStudentInfo() {
        System.out.println("Nom : " + name);
        System.out.println("ID : " + studentId);
        System.out.println("Âge : " + age);
        System.out.println("Moyenne des notes : " + getAverageGrade());
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

}
