package org.example.repository;

import org.example.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> getAll() {
        return new ArrayList<>(products);
    }

    public void clear() {
        products.clear();
    }
}
