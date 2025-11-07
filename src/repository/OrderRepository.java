package repository;

import model.Order;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository extends BaseRepository<Order> {

    public List<Order> findByCustomerName(String name) {
        return items.stream()
                .filter(o -> o.getCustomer().getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public double getTotalRevenue() {
        return items.stream()
                .map(o -> o.getProduct().getPrice() * o.getQuantity())
                .reduce(0.0, Double::sum);
    }
}
