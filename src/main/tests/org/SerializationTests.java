package org.example;

import org.example.model.Product;
import org.example.serialization.DataSerializationException;
import org.example.serialization.DataSerializer;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SerializationTests {

    @Test
    void testJsonSerialization() throws DataSerializationException {
        List<Product> products = Arrays.asList(
                new Product(1, "Test1", 10),
                new Product(2, "Test2", 20)
        );

        File file = new File("test.json");
        DataSerializer.saveToJson(products, file);
        List<Product> loaded = DataSerializer.loadFromJson(file, Product.class);

        assertEquals(products, loaded);
        file.delete();
    }

    @Test
    void testYamlSerialization() throws DataSerializationException {
        List<Product> products = Arrays.asList(
                new Product(1, "TestA", 100),
                new Product(2, "TestB", 200)
        );

        File file = new File("test.yaml");
        DataSerializer.saveToYaml(products, file);
        List<Product> loaded = DataSerializer.loadFromYaml(file, Product.class);

        assertEquals(products, loaded);
        file.delete();
    }
}
