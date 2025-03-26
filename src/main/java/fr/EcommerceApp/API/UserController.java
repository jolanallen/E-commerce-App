package fr.EcommerceApp.API;

import fr.EcommerceApp.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final List<User> users = new ArrayList<>(); //temporary

    @PostMapping("/register")
    public User registerUser(@RequestBody User newUser) {
        users.add(newUser);
        System.out.println("New user registered: " + newUser.getUsername());
        return newUser;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }
}
