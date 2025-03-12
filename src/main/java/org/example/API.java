package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api") // URL de base pour l'API
public class API {

    private ArrayList<User> allUsers = new ArrayList<>();
    private ArrayList<Product> allProducts = new ArrayList<>();


    public API() {
        User user1 = new RegularUser("john_doe", "john@example.com", "password123");
        allUsers.add(user1);
        user1.login("john@example.com", "password123");

        Product product1 = new Product("Laptop", 101, 1200.99, 10);
        Product product2 = new Product("Phone", 102, 699.49, 5);

        allProducts.add(product1);
        allProducts.add(product2);

        Cart cart = new Cart(user1);
        cart.addProduct(product1);
        cart.addProduct(product2);

        double total = cart.calculateTotal();
        PaymentMethod payment = new CreditCard();
        payment.processPayment(total);
    }

    @GetMapping("/api")
    public String getApi() {
        return "api";
    }


    // List all products.
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(allProducts);
    }

    // List all users.
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(allUsers);
    }
/*
    // Retrieve product details
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getUniqueProducts(@PathVariable int id) {
        Student student = ynov.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    // Retrieve order details.
    @GetMapping("/orders/{id}")
    public ResponseEntity<List<>> getStudentsFromCourses(@PathVariable int id) {
        Course course = ynov.getCourseByCode(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course.getStudents());
    }

    //  Retrieve user order history.
    @GetMapping("/users/{id}/orders")
    public ResponseEntity<List<Student>> getStudentsFromCourses(@PathVariable int id) {
        Course course = ynov.getCourseByCode(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course.getStudents());
    }




    //  Register a new user (POST)
    @PostMapping("/users/register")
    public ResponseEntity<String> addUnderGraduateStudent(@RequestBody UndergraduateStudent student) {
        student.setStudentId(allStudents.size() + 1);
        allStudents.add(student);
        return ResponseEntity.ok("Étudiant ajouté : " + student.getName());
    }

    // Authenticate a user (POST)
    @PostMapping("/users/login")
    public ResponseEntity<String> addGraduateStudent(@RequestBody GraduateStudent student) {
        student.setStudentId(allStudents.size() + 1);
        allStudents.add(student);
        return ResponseEntity.ok("Étudiant ajouté : " + student.getName());
    }

    //  Add a new product. (POST)
    @PostMapping("/products")
    public ResponseEntity<String> addStudenttoCourse(@RequestBody Student student, @RequestParam int courseCode) {
        Course course = ynov.getCourseByCode(courseCode);
        if (course != null) {
            course.enrollStudent(student);
            return ResponseEntity.ok("Étudiant ajouté : " + student.getName());
        }
        return ResponseEntity.badRequest().body("Cours non trouvé");
    }

    // Add a product to the user’s cart (POST)
    @PostMapping("/cart/add")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        course.setCourseCode(ynov.getCourses().size() + 1);
        ynov.addCourses(course);
        return ResponseEntity.ok("Cours ajouté : " + course.getCourseName());
    }

    // Remove a product from the cart (POST)
    @PostMapping("/cart/remove")
    public ResponseEntity<String> addGrade(@RequestParam Float grade,@PathVariable int studentId) {
        Student student = ynov.getStudentById(studentId);
        if (student != null) {
            student.addGrade(grade);
            return ResponseEntity.ok("Note ajoutée : " + grade);
        }
        return ResponseEntity.badRequest().body("Étudiant non trouvé");
    }

    // Confirm an order. (POST)
    @PostMapping("/orders/place")
    public ResponseEntity<String> addGrade(@RequestParam Float grade,@PathVariable int studentId) {
        Student student = ynov.getStudentById(studentId);
        if (student != null) {
            student.addGrade(grade);
            return ResponseEntity.ok("Note ajoutée : " + grade);
        }
        return ResponseEntity.badRequest().body("Étudiant non trouvé");*/
    }
