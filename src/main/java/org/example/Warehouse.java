package org.example;

import java.util.ArrayList;
import lombok.Getter;

public class Warehouse {
    @Getter
    public ArrayList<Product> warehouselist;

    public Warehouse (){
        this.warehouselist = new ArrayList<>();
    }

    public void addProduct(Product product){
        warehouselist.add(product);
    }

    public Product getProductById(int productId) {
        for (Product product : warehouselist) {
            if (product.getProductID() == productId) {  // Correction ici
                return product;
            }
        }
        return null;
    }

}
