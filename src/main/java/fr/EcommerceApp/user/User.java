package fr.EcommerceApp.user;

import fr.EcommerceApp.order.cart.Cart;
import fr.EcommerceApp.order.Order;
import org.mindrot.jbcrypt.BCrypt;
import java.util.ArrayList;
import lombok.Getter;

@Getter
public class User {
    private String username;
    private String email;
    private String password;
    private ArrayList<Order> orderHistory;
    private int id_user;
    private boolean isRegistered;
    private Cart cart;

    public User() {
        // Required for JSON deserialization by Spring
    }

    // Constructeur
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = hashPassword(password);
        this.isRegistered = true;
        this.orderHistory = new ArrayList<>();
        this.cart = new Cart(this);
    }

    // Méthode d'inscription
    public void registers(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = hashPassword(password);
        this.isRegistered = true;
        this.orderHistory = new ArrayList<>();
        this.cart = new Cart(this);
    }

    // Hachage du mot de passe
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Vérifier un mot de passe
    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }

    // Vérifier un email
    public boolean checkEmail(String email) {
        return this.email.equals(email);
    }

    // Connexion utilisateur
    public boolean login(String email, String password) {
        if (this.email.equals(email) && checkPassword(password)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid credentials.");
            return false;
        }
    }

    // Historique des commandes
    public ArrayList<Order> viewOrderHistory() {
        return orderHistory.isEmpty() ? null : orderHistory;
    }


}
