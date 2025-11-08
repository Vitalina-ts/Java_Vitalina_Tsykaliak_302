package org.example;

import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.example.service.DataSerializer;
import org.example.service.DataSerializationException;
import org.example.util.ConfigUtil;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            ConfigUtil config = new ConfigUtil("config.properties");
            String jsonPath = config.getProperty("json.path");
            String yamlPath = config.getProperty("yaml.path");
            int count = Integer.parseInt(config.getProperty("data.count"));

        
            ProductRepository repo = new ProductRepository();
            for (int i = 1; i <= count; i++) {
                repo.add(new Product("Product" + i, i * 100, "Category" + i));
            }

            DataSerializer serializer = new DataSerializer();
            serializer.serializeToJson(repo.getAll(), jsonPath);
            serializer.serializeToYaml(repo.getAll(), yamlPath);

          
            List<Product> fromJson = serializer.deserializeFromJson(jsonPath);
            List<Product> fromYaml = serializer.deserializeFromYaml(yamlPath);

            logger.info("З JSON: " + fromJson);
            logger.info("З YAML: " + fromYaml);

        } catch (IOException e) {
            logger.severe("Помилка читання properties: " + e.getMessage());
        } catch (DataSerializationException e) {
            logger.severe("Помилка серіалізації/десеріалізації: " + e.getMessage());
        }
    }
}
