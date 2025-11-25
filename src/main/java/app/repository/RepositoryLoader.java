package app.repository;

import app.model.Person;
import app.util.FileUtils;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class RepositoryLoader {

    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public CompletableFuture<Void> loadAsync(PersonRepository repo, String path) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return FileUtils.readLines(path);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, executor).thenAccept(lines -> {
            lines.forEach(line -> {
                try {
                    String[] p = line.split(",");
                    repo.add(new Person(p[0], Integer.parseInt(p[1]), Double.parseDouble(p[2])));
                } catch (Exception ex) {
                    System.err.println("Помилка парсингу: " + line);
                }
            });
        });
    }

    public void loadParallelStream(PersonRepository repo, String path) throws Exception {
        FileUtils.readLines(path)
                .parallelStream()
                .forEach(line -> {
                    try {
                        String[] p = line.split(",");
                        repo.add(new Person(p[0], Integer.parseInt(p[1]), Double.parseDouble(p[2])));
                    } catch (Exception ex) {
                        System.err.println("Помилка парсингу: " + line);
                    }
                });
    }

    public void shutdown() {
        executor.shutdown();
    }
}
