package org.example;

import java.util.ArrayList;
import lombok.Getter;

public class Warehouse {
    @Getter
    private ArrayList<Product> warehouse;

    public Warehouse (){
        this.warehouse = new ArrayList<>();
    }

    public void addProduct(Product product){
        warehouse.add(product);
    }

    public Product getProductById(int productId) {
        for (Product product : warehouse) {
            if (product.getProductID() == productId) {  // Correction ici
                return product;
            }
        }
        return null;
    }
}
