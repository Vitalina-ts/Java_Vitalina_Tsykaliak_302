package app;

import app.repository.*;
import app.service.*;

import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {

        PersonRepository repo = new PersonRepository();
        RepositoryLoader loader = new RepositoryLoader();
        DataProcessor processor = new DataProcessor();
        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("=== ПАРАЛЕЛЬНЕ ЗАВАНТАЖЕННЯ ===");

        CompletableFuture<Void> f1 = loader.loadAsync(repo, "data1.txt");
        CompletableFuture<Void> f2 = loader.loadAsync(repo, "data2.txt");

        CompletableFuture.allOf(f1, f2).join();
        System.out.println("Завантажено: " + repo.getAll().size());

        System.out.println("=== ПАРАЛЕЛЬНА ОБРОБКА (Callable) ===");

        Future<List<app.model.Person>> filtered =
                executor.submit(processor.filterTask(repo, 30));

        Future<Long> highSalary =
                executor.submit(processor.countTask(repo, 5000));

        System.out.println("Фільтр 30+: " + filtered.get().size());
        System.out.println("Зарплата >5000: " + highSalary.get());

        System.out.println("=== ПОРІВНЯННЯ parallelStream vs stream ===");

        new ParallelComparator().compare(repo);

        loader.shutdown();
        executor.shutdown();
    }
}
