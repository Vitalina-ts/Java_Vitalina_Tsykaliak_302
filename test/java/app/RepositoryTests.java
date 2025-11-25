package app;

import app.repository.*;
import app.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTests {

    @Test
    void testParallelLoad() {
        PersonRepository repo = new PersonRepository();
        RepositoryLoader loader = new RepositoryLoader();

        loader.loadAsync(repo, "testdata.txt").join();

        assertTrue(repo.getAll().size() > 0);
    }

    @Test
    void testFiltering() {
        PersonRepository repo = new PersonRepository();
        repo.add(new Person("A", 20, 3000));
        repo.add(new Person("B", 40, 6000));

        List<Person> f = repo.filterByAge(30);

        assertEquals(1, f.size());
    }

    @Test
    void testCounting() {
        PersonRepository repo = new PersonRepository();
        repo.add(new Person("A", 20, 2000));
        repo.add(new Person("B", 40, 6000));

        assertEquals(1, repo.countHighSalary(3000));
    }
}
