package org.example;

import java.util.ArrayList;
import lombok.Getter;

@Getter
class UndergraduateStudent extends Student {

    private String speciality;

    public UndergraduateStudent(String name, int studentId, int age, String speciality) {
        super(name, studentId, age);
        this.speciality = speciality;
    }

    @Override
    public Float getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0f;
        }
        Float sum = 0.0f;
        for (Float grade : grades) {
            sum += grade;
        }
        return (Float) sum / grades.size();
    }

    @Override
    public void printStudentInfo() {
        super.printStudentInfo();
        System.out.println("Spécialité : " + speciality);
    }
}