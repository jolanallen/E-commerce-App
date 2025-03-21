package fr.EcommerceApp.user.Admin;

import fr.EcommerceApp.user.User;

public class AdminUser extends User {
    public AdminUser(String username, String email, String password) {
        super(username, email, password);
    }

    public void manageProducts() {
        System.out.println("Admin managing products.");
    }
}