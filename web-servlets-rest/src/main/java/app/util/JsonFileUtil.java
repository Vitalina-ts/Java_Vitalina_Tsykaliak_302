package app.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class JsonFileUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> List<T> read(Path path, TypeReference<List<T>> type) throws IOException {
        if (!Files.exists(path)) return List.of();
        try (InputStream in = Files.newInputStream(path)) {
            return mapper.readValue(in, type);
        }
    }

    public static synchronized <T> void write(Path path, List<T> data) throws IOException {
        Files.createDirectories(path.getParent());
        Path tmp = Path.of(path + ".tmp");

        try (OutputStream out = Files.newOutputStream(tmp)) {
            mapper.writerWithDefaultPrettyPrinter().writeValue(out, data);
        }

        Files.move(tmp, path, StandardCopyOption.REPLACE_EXISTING);
    }
}
