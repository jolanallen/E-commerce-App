package org.example;

public class Main {

    public static void main(String[] args) {

        System.out.println("Serveur lancé sur http://localhost:3000");
        User user1 = new RegularUser("john_doe", "john@example.com", "password123");
        user1.register();
        user1.login("john@example.com", "password123");

        Product product1 = new Product("Laptop", 101, 1200.99, 10);
        Product product2 = new Product("Phone", 102, 699.49, 5);

        Cart cart = new Cart(user1);
        cart.addProduct(product1);
        cart.addProduct(product2);

        double total = cart.calculateTotal();
        PaymentMethod payment = new CreditCard();
        payment.processPayment(total);

        List<Product> purchasedItems = new ArrayList<>(cart.items);
        Order order1 = new Order(user1, purchasedItems);
        order1.placeOrder();
        order1.updateStatus("Shipped");
    }
}