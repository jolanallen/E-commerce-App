package org.example;

import java.util.ArrayList;
import lombok.Getter;
import java.util.*;
import org.springframework.boot.autoconfigure.web.servlet.JerseyApplicationPath;



public class User {
    private String username = "Jean";
    private String email = "jean@gmail.com";
    private String hashPassword = "abracadabra";
    private ArrayList<Object> orderHistory = new ArrayList<>();
    private int id_user;


    public User() {

    }

    public void registers(String username, String email, String password,int id_user){
        this.username = username;
        this.email = email;
        this.hashPassword = hashPassword(password);
        this.id_user = id_user;
    }

    public String hashPassword(String password) {
        return this.hashPassword.hash(password);
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.hashPassword);
    }
    public void authentificates{String email, String password}

}
/*
User Class
Attributes:

username, email, password, orderHistory (list of orders).
Methods:

register(): Registers a new user.
login(): Authenticates the user.
viewOrderHistory(): Retrieves past orders.*/