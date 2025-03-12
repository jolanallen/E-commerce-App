package org.example;

import java.util.*;
import org.springframework.boot.autoconfigure.web.servlet.JerseyApplicationPath;
import org.mindrot.jbcrypt.BCrypt;
import lombok.Getter;


public class Product {
    private String productName;
    @Getter
    private int productID;
    private double price;
    private int stockQuantity;

    public Product(String productName, int productID, double price, int stockQuantity) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void updateStock(int quantity) {
        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
        } else {
            System.out.println("Insufficient stock!");
        }
    }

    public String getProductDetails() {
        return "Product: " + productName + ", Price: " + price + ", Stock: " + stockQuantity;
    }
    public double getPrice() {
        return price;
    }
}
