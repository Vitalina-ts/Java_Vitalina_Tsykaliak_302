package app.repository;

import app.model.Person;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class PersonRepository {

    private final CopyOnWriteArrayList<Person> people = new CopyOnWriteArrayList<>();

    public void add(Person p) {
        people.add(p);
    }

    public List<Person> getAll() {
        return people;
    }

    public List<Person> filterByAge(int minAge) {
        return people.stream()
                .filter(p -> p.getAge() >= minAge)
                .collect(Collectors.toList());
    }

    public long countHighSalary(double threshold) {
        return people.stream()
                .filter(p -> p.getSalary() > threshold)
                .count();
    }
}
