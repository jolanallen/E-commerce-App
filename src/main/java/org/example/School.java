package org.example;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class School {
    private ArrayList<Course> courses;
    private String name;

    // Constructor: Initializes a school with name
    public School(String name){
        this.courses = new ArrayList<>();
        this.name = name;
    }

    // Adds a course to the list and returns a message about the added course
    public String addCourses(Course course){
        this.courses.add(course);
        return "le cours :" + course + "est ajouté";
    }

    // Retrieves a course based on the course code
    public Course getCourseByCode(int courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode() == courseCode) {
                return course;
            }
        }
        return null;
    }

    // Retrieves a student by their student ID from any course
    public Student getStudentById(int studentId) {
        for (Course course : courses) {
            for (Student student : course.getStudents()) {
                if (student.getStudentId() == studentId) {
                    return student;
                }
            }
        }
        return null;
    }
}
