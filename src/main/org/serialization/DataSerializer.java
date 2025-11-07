package org.example.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

public class DataSerializer {
    private static final Logger logger = LoggerFactory.getLogger(DataSerializer.class);

    public static <T> void saveToJson(List<T> data, File file) throws DataSerializationException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
            logger.info(" Дані збережено у JSON: {}", file.getAbsolutePath());
        } catch (IOException e) {
            logger.error(" Помилка при збереженні у JSON", e);
            throw new DataSerializationException("Помилка серіалізації у JSON", e);
        }
    }

    public static <T> void saveToYaml(List<T> data, File file) throws DataSerializationException {
        try {
            YAMLMapper mapper = new YAMLMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
            logger.info("Дані збережено у YAML: {}", file.getAbsolutePath());
        } catch (IOException e) {
            logger.error(" Помилка при збереженні у YAML", e);
            throw new DataSerializationException("Помилка серіалізації у YAML", e);
        }
    }

    public static <T> List<T> loadFromJson(File file, Class<T> clazz) throws DataSerializationException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<T> list = mapper.readValue(file,
                    mapper.getTypeFactory().constructCollectionType(List.class, clazz));
            logger.info(" Дані зчитано з JSON: {}", file.getAbsolutePath());
            return list;
        } catch (IOException e) {
            logger.error(" Помилка читання JSON", e);
            throw new DataSerializationException("Помилка десеріалізації JSON", e);
        }
    }

    public static <T> List<T> loadFromYaml(File file, Class<T> clazz) throws DataSerializationException {
        try {
            YAMLMapper mapper = new YAMLMapper();
            List<T> list = mapper.readValue(file,
                    mapper.getTypeFactory().constructCollectionType(List.class, clazz));
            logger.info(" Дані зчитано з YAML: {}", file.getAbsolutePath());
            return list;
        } catch (IOException e) {
            logger.error(" Помилка читання YAML", e);
            throw new DataSerializationException("Помилка десеріалізації YAML", e);
        }
    }
}
