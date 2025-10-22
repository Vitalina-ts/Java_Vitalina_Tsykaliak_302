import entities.*;
import repository.*;

public class Main {
    public static void main(String[] args) {
        GenericRepository<Person> personRepo = new GenericRepository<>(Person::getId);

        Person p1 = new Person("1", "Vitalina", Role.ADMIN);
        Person p2 = new Person("2", "Oleh", Role.USER);
        Person p3 = new Person("1", "Duplicate", Role.MANAGER);

        personRepo.add(p1);
        personRepo.add(p2);
        personRepo.add(p3);

        System.out.println("🔹 All persons:");
        personRepo.getAll().forEach(System.out::println);

        System.out.println("\n🔹 Find by ID = '2':");
        System.out.println(personRepo.findByIdentity("2"));

        GenericRepository<Product> productRepo = new GenericRepository<>(Product::getCode);

        Product prod1 = new Product("A1", "Laptop", 35000);
        Product prod2 = new Product("B2", "Phone", 18000);

        productRepo.add(prod1);
        productRepo.add(prod2);

        System.out.println("\n🔹 All products:");
        productRepo.getAll().forEach(System.out::println);

        System.out.println("\n🔹 Find by code = 'A1':");
        System.out.println(productRepo.findByIdentity("A1"));
    }
}
