package fr.EcommerceApp.order;

import fr.EcommerceApp.Warehouse.products.Product;

import java.util.ArrayList;
import fr.EcommerceApp.user.User;



public class Order {
    private int orderCounter = 1;
    private int orderID;
    private User user;
    private ArrayList<Product> items;
    private String status;

    public Order(User user, ArrayList<Product> items) {
        this.orderID = orderCounter++;
        this.user = user;
        this.items = new ArrayList<>(items);
        this.status = "Processing";
    }

    public void placeOrder() {
        System.out.println("Order " + orderID + " placed successfully.");
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("Order status updated to: " + newStatus);
    }
}
