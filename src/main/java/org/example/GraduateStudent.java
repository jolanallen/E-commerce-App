package org.example;

import java.util.ArrayList;
import lombok.Getter;

@Getter
class GraduateStudent extends Student {

    private String theThesis;

    public GraduateStudent(String name, int studentId, int age, String theThesis) {
        super(name, studentId, age);
        this.theThesis = theThesis;
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
        System.out.println("Thèse : " + theThesis);
    }
}
