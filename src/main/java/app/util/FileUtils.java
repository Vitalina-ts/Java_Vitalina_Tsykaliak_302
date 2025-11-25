package app.util;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileUtils {
    public static List<String> readLines(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }
}
