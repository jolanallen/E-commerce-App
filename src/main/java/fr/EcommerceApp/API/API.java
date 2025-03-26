package fr.EcommerceApp.API;

import fr.EcommerceApp.Warehouse.Warehouse;
import fr.EcommerceApp.Warehouse.products.Product;
import fr.EcommerceApp.order.Order;
import fr.EcommerceApp.user.ManageUser;
import fr.EcommerceApp.user.RegularUser;
import fr.EcommerceApp.user.User;
import fr.EcommerceApp.user.AdminUser;
import fr.EcommerceApp.user.UserType;


import fr.EcommerceApp.order.cart.Cart;
import fr.EcommerceApp.order.cart.CartRequest;
import fr.EcommerceApp.order.payment.CreditCard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
@RequestMapping("/api") // URL de base pour l'API
public class API {

    public Warehouse warehouse = new Warehouse();
    public ManageUser allUsers = new ManageUser();


    public API() {
        User user1 = new RegularUser("john_doe", "john@example.com", "password123",allUsers.listOfUsers.size()+1);
        allUsers.addUser(user1);
        user1.login("john@example.com", "password123");

        Product product1 = new Product("Laptop", 101, 1200.99, 10);
        Product product2 = new Product("Phone", 102, 699.49, 5);

        warehouse.addProduct(product1);
        warehouse.addProduct(product2);

        Cart cart = new Cart(user1);
        cart.addProduct(product1);
        cart.addProduct(product2);

        double total = cart.calculateTotal();
        CreditCard payment = new CreditCard();
        payment.processPayment(total);
    }

    @GetMapping("/")
    public String getApi() {
        return "Bienvenue dans notre API de E-commerce-App !";
    }



    // List all products.
    @GetMapping("/products")
    public ResponseEntity<ArrayList<Product>> getProducts() {
        return ResponseEntity.ok(warehouse.warehouselist);
    }

    // List all users.
    @GetMapping("/users")
    public ResponseEntity<ArrayList<User>> getUsers() {
        return ResponseEntity.ok(allUsers.listOfUsers);
    }

    // Retrieve product details
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getUniqueProduct(@PathVariable int id) {
        Product product = warehouse.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }


    // register user (POST)
    @PostMapping("/register")
    public ResponseEntity<String> newRegister(@RequestBody User user) {
        // Vérifier si l'email est déjà utilisé
        for (User u : allUsers.listOfUsers) {
            if (u.getEmail().equals(user.getEmail())) {
                return ResponseEntity.badRequest().body("Erreur : Cet email est déjà utilisé !");
            }
        }

        User newUser;
        if (user.getUserType() == UserType.ADMIN) {
            newUser = new AdminUser(user.getUsername(), user.getEmail(), user.getPassword(), allUsers.listOfUsers.size()+1);
        } else {
            newUser = new RegularUser(user.getUsername(), user.getEmail(), user.getPassword(),allUsers.listOfUsers.size()+1);
        }

        allUsers.addUser(newUser);
        return ResponseEntity.ok("Utilisateur ajouté avec succès : " + newUser.getUsername());
    }

    // authenticate (POST)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();

        for (User u : allUsers.listOfUsers) {
            if (u.checkEmail(email) && u.checkPassword(password)) {
                return ResponseEntity.ok("Connexion réussie pour : " + u.getUsername() + " (" + u.getUserType() + ")");
            }
        }
        return ResponseEntity.badRequest().body("Échec de la connexion : Identifiants invalides.");
    }


    // Add a new product (POST)
    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        warehouse.addProduct(product);
        return ResponseEntity.ok("Produit ajouté dans l'entrepôt.");
    }
    // Add a product to the user’s cart (POST)
    @PostMapping("/cart/add")
    public ResponseEntity<String> addProductToCart(@RequestBody CartRequest request) {
        User user = allUsers.getUserByEmail(request.email);
        if (user == null) return ResponseEntity.badRequest().body("Utilisateur non trouvé.");

        Product product = warehouse.getProductById(request.productId);
        if (product == null) return ResponseEntity.badRequest().body("Produit non trouvé.");

        user.getCart().addProduct(product);
        return ResponseEntity.ok("Produit ajouté au panier.");
    }
    // Remove a product from the cart (POST)
    @PostMapping("/cart/remove")
    public ResponseEntity<String> removeProductFromCart(@RequestBody CartRequest request) {
        User user = allUsers.getUserByEmail(request.email);
        if (user == null) {
            return ResponseEntity.badRequest().body("Utilisateur non trouvé.");
        }

        Product product = warehouse.getProductById(request.productId);
        if (product == null) {
            return ResponseEntity.badRequest().body("Produit non trouvé.");
        }

        Cart cart = user.getCart();
        if (!cart.getItems().contains(product)) {
            return ResponseEntity.badRequest().body("Le produit n'est pas dans le panier.");
        }

        cart.removeProduct(product);
        return ResponseEntity.ok("Produit retiré du panier.");
    }



    // Confirm an order (POST)
    @PostMapping("/orders/place")
    public ResponseEntity<String> confirmOrder(@RequestBody User user) {
        Cart cart = user.getCart();
        if (cart == null || cart.getItems().isEmpty()) {
            return ResponseEntity.badRequest().body("Votre panier est vide.");
        }

        double total = cart.calculateTotal();
        CreditCard payment = new CreditCard();


        Order order = new Order(user, cart.getItems());
        user.getOrderHistory().add(order);
        cart.clearCart(); // Vider le panier après la commande

        return ResponseEntity.ok("Commande confirmée. Total payé : " + total);
    }
}
