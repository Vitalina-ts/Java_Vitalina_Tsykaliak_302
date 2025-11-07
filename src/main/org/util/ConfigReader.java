package org.example.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties props = new Properties();

    public ConfigReader(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            props.load(fis);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }

    public int getInt(String key) {
        return Integer.parseInt(props.getProperty(key));
    }
}
