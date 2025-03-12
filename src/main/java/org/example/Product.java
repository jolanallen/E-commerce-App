package org.example;

import java.util.ArrayList;
import lombok.Getter;
package org.example;

import java.util.*;
import org.springframework.boot.autoconfigure.web.servlet.JerseyApplicationPath;
import org.mindrot.jbcrypt.BCrypt;



public class Product {
    private String productName;
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
        //oublie pas de demander au prof si dans les bonnes pratiques on peut faire ça ou tropo moche
        return stockQuantity >= quantity ? stockQuantity -= quantity : System.out.println("Insufficient stock!");
    }

    public String getProductDetails() {
        return "Product: " + productName + ", Price: " + price + ", Stock: " + stockQuantity;
    }
    public double getPrice() {
        return price;
    }
}
