package repository;

import model.Product;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository extends BaseRepository<Product> {

    public List<Product> findByCategory(String category) {
        System.out.println("[LOG] Searching products by category: " + category);
        return items.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Product> findByPriceRange(double min, double max) {
        System.out.println("[LOG] Searching products by price range: " + min + "-" + max);
        return items.stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .collect(Collectors.toList());
    }

    public double getAveragePrice() {
        return items.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum) / items.size();
    }
}

