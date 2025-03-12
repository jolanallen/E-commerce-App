package org.example;

import java.util.ArrayList;
import lombok.Getter;
import java.util.*;
package org.example;

import org.springframework.boot.autoconfigure.web.servlet.JerseyApplicationPath;
import org.mindrot.jbcrypt.BCrypt;



public class Order {
    private int orderCounter = 1;
    private int orderID;
    private User user;
    private ArrayList<Product> items;
    private String status;

    public Order(User user, List<Product> items) {
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
