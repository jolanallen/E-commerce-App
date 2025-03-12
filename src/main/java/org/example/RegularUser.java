package org.example;

public class RegularUser extends User {
    public RegularUser(String username, String email, String password) {
        super(username, email, password);
    }

    public void browseProducts() {
        System.out.println("Browsing products.");
    }
}