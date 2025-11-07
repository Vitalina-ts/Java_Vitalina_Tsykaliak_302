package org.example;

import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.example.serialization.DataSerializationException;
import org.example.serialization.DataSerializer;
import org.example.util.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            ConfigReader config = new ConfigReader("src/main/resources/config.properties");

            String jsonPath = config.get("json.path");
            String yamlPath = config.get("yaml.path");
            int count = config.getInt("testData.count");

            ProductRepository repo = new ProductRepository();

            // Генеруємо тестові об’єкти
            Random random = new Random();
            for (int i = 1; i <= count; i++) {
                repo.add(new Product(i, "Product" + i, 10 + random.nextDouble() * 90));
            }

            // Серіалізація
            DataSerializer.saveToJson(repo.getAll(), new File(jsonPath));
            DataSerializer.saveToYaml(repo.getAll(), new File(yamlPath));

            // Десеріалізація
            List<Product> fromJson = DataSerializer.loadFromJson(new File(jsonPath), Product.class);
            List<Product> fromYaml = DataSerializer.loadFromYaml(new File(yamlPath), Product.class);

            // Перевірка
            System.out.println("\n=== Початкові дані ===");
            repo.getAll().forEach(System.out::println);

            System.out.println("\n=== JSON відновлення ===");
            fromJson.forEach(System.out::println);

            System.out.println("\n=== YAML відновлення ===");
            fromYaml.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Помилка зчитування конфігурації: " + e.getMessage());
        } catch (DataSerializationException e) {
            System.err.println("Помилка серіалізації: " + e.getMessage());
        }
    }
}
