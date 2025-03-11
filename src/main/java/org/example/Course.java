package org.example;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Course{
    private String courseName;
    @Setter
    private int courseCode;
    private int creditHours;
    private ArrayList<Student> students = new ArrayList<>();

    // Constructor to initialize a course with a name, course code, and credit hours
    public Course (String courseName, int courseCode, int creditHours){
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
    }

    // Enrolls a student in the course by adding them to the student list
    public void enrollStudent(Student student){
        this.students.add(student);
    }

}