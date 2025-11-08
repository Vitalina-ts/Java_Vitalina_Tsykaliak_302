package org.example.repository;

import org.example.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public void add(Product p) {
        products.add(p);
    }

    public List<Product> getAll() {
        return products;
    }

    public void clear() {
        products.clear();
    }
}
