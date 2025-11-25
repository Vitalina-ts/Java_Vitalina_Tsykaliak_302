package app.service;

import app.model.Person;
import app.repository.PersonRepository;

import java.util.List;
import java.util.concurrent.Callable;

public class DataProcessor {

    public Callable<List<Person>> filterTask(PersonRepository repo, int minAge) {
        return () -> repo.filterByAge(minAge);
    }

    public Callable<Long> countTask(PersonRepository repo, double salaryThreshold) {
        return () -> repo.countHighSalary(salaryThreshold);
    }
}
