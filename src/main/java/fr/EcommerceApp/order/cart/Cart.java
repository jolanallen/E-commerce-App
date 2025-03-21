package fr.EcommerceApp.order.cart;

import lombok.Getter;
import java.util.*;

import fr.EcommerceApp.Warehouse.products.Product;
import fr.EcommerceApp.user.User;


public class Cart {
    private User user;
    @Getter
    private ArrayList<Product> items;

    public Cart(User user) {
        this.user = user;
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    public void clearCart() {
        items.clear();
    }
}
