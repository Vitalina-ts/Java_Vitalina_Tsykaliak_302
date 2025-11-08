package org.example;

import org.example.model.Product;
import org.example.service.DataSerializer;
import org.example.service.DataSerializationException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataSerializerTest {

    @Test
    void testJsonSerialization() throws Exception {
        DataSerializer serializer = new DataSerializer();
        List<Product> products = List.of(new Product("A", 10, "X"));
        String path = "test.json";

        serializer.serializeToJson(products, path);
        List<Product> restored = serializer.deserializeFromJson(path);

        assertEquals(products.get(0).getName(), restored.get(0).getName());
        new File(path).delete();
    }

    @Test
    void testYamlSerialization() throws Exception {
        DataSerializer serializer = new DataSerializer();
        List<Product> products = List.of(new Product("B", 20, "Y"));
        String path = "test.yaml";

        serializer.serializeToYaml(products, path);
        List<Product> restored = serializer.deserializeFromYaml(path);

        assertEquals(products.get(0).getCategory(), restored.get(0).getCategory());
        new File(path).delete();
    }

    @Test
    void testExceptionHandling() {
        DataSerializer serializer = new DataSerializer();
        assertThrows(DataSerializationException.class, () -> serializer.deserializeFromJson("nofile.json"));
    }
}
