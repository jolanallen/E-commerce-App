package org.example;

import java.util.ArrayList;
import lombok.Getter;
import java.util.*;
import org.springframework.boot.autoconfigure.web.servlet.JerseyApplicationPath;
import org.mindrot.jbcrypt.BCrypt;



public class User {
    private String username = "a";
    private String email;
    private String hashPassword = "a@a";
    private ArrayList<Order> orderHistory = new ArrayList<>();
    private int id_user = 0;
    private boolean isRegistered = false;


    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.hashPassword = hashPassword(password);
    }

    public void registers(String username, String email, String password,int id_user){
        this.username = username;
        this.email = email;
        this.hashPassword = hashPassword(password);
        this.id_user = id_user;
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.hashPassword);
    }
    public boolean checkEmail(String email) {
        return email == this.email;
    }
    public boolean login(String email, String password) {
        if (this.email.equals(email) && this.hashPassword.equals(password)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid credentials.");
            return false;
        }
    }
    public ArrayList<Order> viewOrderHistory(){
        return orderHistory.isEmpty() ? null : orderHistory;
    }
}
