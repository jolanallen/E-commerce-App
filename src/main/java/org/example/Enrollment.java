package org.example;
import lombok.Getter;

@Getter
public class Enrollment {
    private Student student;
    private Course course;

    // Registers a student for a course by assigning the student and course
    public void register(UndergraduateStudent student,Course course){
        this.student = student;
        this.course = course;
    }

}
