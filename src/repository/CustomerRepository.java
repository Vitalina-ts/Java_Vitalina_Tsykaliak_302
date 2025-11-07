package repository;

import model.Customer;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerRepository extends BaseRepository<Customer> {

    public List<Customer> findByCity(String city) {
        System.out.println("[LOG] Searching customers by city: " + city);
        return items.stream()
                .filter(c -> c.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Customer> findByAgeRange(int min, int max) {
        return items.stream()
                .filter(c -> c.getAge() >= min && c.getAge() <= max)
                .collect(Collectors.toList());
    }
}
