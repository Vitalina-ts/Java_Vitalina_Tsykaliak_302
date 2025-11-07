package org.example.model;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product() {} // необхідно для Jackson

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Гетери і сетери
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product p = (Product) o;
        return id == p.id && Double.compare(p.price, price) == 0 && Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
