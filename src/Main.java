import model.*;
import repository.*;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        ProductRepository productRepo = new ProductRepository();
        CustomerRepository customerRepo = new CustomerRepository();
        OrderRepository orderRepo = new OrderRepository();

        // Додавання даних
        productRepo.add(new Product("Laptop", 1500, "Electronics"));
        productRepo.add(new Product("Phone", 800, "Electronics"));
        productRepo.add(new Product("Book", 20, "Education"));

        customerRepo.add(new Customer("Vitalina", 22, "Chernivtsi"));
        customerRepo.add(new Customer("Andriy", 30, "Lviv"));

        orderRepo.add(new Order(customerRepo.getAll().get(0), productRepo.getAll().get(0), 1));
        orderRepo.add(new Order(customerRepo.getAll().get(1), productRepo.getAll().get(2), 3));

        // Stream API приклади
        System.out.println("\n=== Products by Category (Electronics) ===");
        productRepo.findByCategory("Electronics").forEach(System.out::println);

        System.out.println("\n=== Customers aged 20-25 ===");
        customerRepo.findByAgeRange(20, 25).forEach(System.out::println);

        System.out.println("\n=== Total Revenue ===");
        System.out.println(orderRepo.getTotalRevenue());

        // Порівняння stream vs parallelStream
        long start1 = System.nanoTime();
        productRepo.getAll().stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        long time1 = System.nanoTime() - start1;

        long start2 = System.nanoTime();
        productRepo.getAll().parallelStream()
                .map(Product::getName)
                .collect(Collectors.toList());
        long time2 = System.nanoTime() - start2;

        System.out.printf("\nStream time: %d ns, ParallelStream time: %d ns\n", time1, time2);
    }
}
