package app.service;

import app.repository.PersonRepository;

import java.util.List;

public class ParallelComparator {

    public void compare(PersonRepository repo) {
        long t1 = System.currentTimeMillis();
        long c1 = repo.countHighSalary(3000);
        long t2 = System.currentTimeMillis();

        System.out.println("parallelStream: " + (t2 - t1) + " ms");

        t1 = System.currentTimeMillis();
        long c2 = repo.getAll()
                .stream()
                .filter(p -> p.getSalary() > 3000)
                .count();
        t2 = System.currentTimeMillis();

        System.out.println("stream: " + (t2 - t1) + " ms");
    }
}

