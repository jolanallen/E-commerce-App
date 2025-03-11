package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api") // URL de base pour l'API
public class API {
    /*private School ynov = new School("Ynov");
    private Course poo = new Course("Poo", 1, 14);
    private Course linux = new Course("Linux", 2, 14);
    private GraduateStudent john = new GraduateStudent("John", 0, 18, "computer science");
    private UndergraduateStudent jack = new UndergraduateStudent("Jack", 1, 19, "human genome");
    private GraduateStudent janne = new GraduateStudent("Janne", 2, 18, "network");
*/
    private ArrayList<User> allUser = new ArrayList<>();


    public API() {






        /*ynov.addCourses(poo);
        ynov.addCourses(linux);

        allStudents.add(john);
        allStudents.add(jack);
        allStudents.add(janne);

        poo.enrollStudent(john);
        poo.enrollStudent(janne);
        linux.enrollStudent(jack);
        linux.enrollStudent(janne);

        john.addGrade(13.0f);
        john.addGrade(17.5f);
        john.addGrade(15.5f);

        jack.addGrade(16.5f);
        jack.addGrade(19.5f);
        jack.addGrade(18.0f);

        janne.addGrade(12.5f);
        janne.addGrade(14.0f);
        janne.addGrade(13.5f);*/
    }

    @GetMapping("/api")
    public String getApi() {
        return "api";
    }

    // School (GET)
    @GetMapping
    public ResponseEntity<School> getSchool() {
        return ResponseEntity.ok(ynov);
    }

    // All courses
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {
        return ResponseEntity.ok(ynov.getCourses());
    }

    // All students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(allStudents);
    }

    // Student single
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getUniqueStudent(@PathVariable int id) {
        Student student = ynov.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    // Students from single course
    @GetMapping("courses/{id}")
    public ResponseEntity<List<Student>> getStudentsFromCourses(@PathVariable int id) {
        Course course = ynov.getCourseByCode(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course.getStudents());
    }


    // Add new undergraduatestudent (POST)
    @PostMapping("/students")
    public ResponseEntity<String> addUnderGraduateStudent(@RequestBody UndergraduateStudent student) {
        student.setStudentId(allStudents.size() + 1);
          allStudents.add(student);
          return ResponseEntity.ok("Étudiant ajouté : " + student.getName());
    }

    // Add new graduate student (POST)
    @PostMapping("/students/graduates")
    public ResponseEntity<String> addGraduateStudent(@RequestBody GraduateStudent student) {
        student.setStudentId(allStudents.size() + 1);
        allStudents.add(student);
        return ResponseEntity.ok("Étudiant ajouté : " + student.getName());
    }

    // Add student to another course (POST)
    @PostMapping("/enrollments")
    public ResponseEntity<String> addStudenttoCourse(@RequestBody Student student, @RequestParam int courseCode) {
        Course course = ynov.getCourseByCode(courseCode);
        if (course != null) {
            course.enrollStudent(student);
            return ResponseEntity.ok("Étudiant ajouté : " + student.getName());
        }
        return ResponseEntity.badRequest().body("Cours non trouvé");
    }

    // Add new course to school (POST)
    @PostMapping("/courses")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        course.setCourseCode(ynov.getCourses().size() + 1);
        ynov.addCourses(course);
        return ResponseEntity.ok("Cours ajouté : " + course.getCourseName());
    }

    // Add grade to student (POST)
    @PostMapping("students/{id}/grades")
    public ResponseEntity<String> addGrade(@RequestParam Float grade,@PathVariable int studentId) {
        Student student = ynov.getStudentById(studentId);
        if (student != null) {
            student.addGrade(grade);
            return ResponseEntity.ok("Note ajoutée : " + grade);
        }
        return ResponseEntity.badRequest().body("Étudiant non trouvé");
    }
}
