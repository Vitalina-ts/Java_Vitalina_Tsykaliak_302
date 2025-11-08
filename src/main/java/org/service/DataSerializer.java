package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.model.Product;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class DataSerializer {
    private static final Logger logger = Logger.getLogger(DataSerializer.class.getName());

    public void serializeToJson(List<Product> products, String path) throws DataSerializationException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), products);
            logger.info("Дані успішно збережено у JSON: " + path);
        } catch (IOException e) {
            logger.severe("Помилка запису у JSON: " + e.getMessage());
            throw new DataSerializationException("Помилка серіалізації JSON", e);
        }
    }

    public void serializeToYaml(List<Product> products, String path) throws DataSerializationException {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), products);
            logger.info("Дані успішно збережено у YAML: " + path);
        } catch (IOException e) {
            logger.severe("Помилка запису у YAML: " + e.getMessage());
            throw new DataSerializationException("Помилка серіалізації YAML", e);
        }
    }

    public List<Product> deserializeFromJson(String path) throws DataSerializationException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return List.of(mapper.readValue(new File(path), Product[].class));
        } catch (JsonProcessingException e) {
            throw new DataSerializationException("JSON обробка не вдалася", e);
        } catch (IOException e) {
            throw new DataSerializationException("Помилка читання JSON", e);
        }
    }

    public List<Product> deserializeFromYaml(String path) throws DataSerializationException {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            return List.of(mapper.readValue(new File(path), Product[].class));
        } catch (IOException e) {
            throw new DataSerializationException("Помилка читання YAML", e);
        }
    }
}
