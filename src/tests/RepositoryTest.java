package tests;

import entities.*;
import org.junit.jupiter.api.Test;
import repository.GenericRepository;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {

    @Test
    void testAddAndFindPerson() {
        GenericRepository<Person> repo = new GenericRepository<>(Person::getId);
        Person p = new Person("10", "TestUser", Role.USER);
        repo.add(p);

        assertEquals(p, repo.findByIdentity("10"));
    }

    @Test
    void testDuplicateNotAdded() {
        GenericRepository<Person> repo = new GenericRepository<>(Person::getId);
        Person p1 = new Person("1", "A", Role.USER);
        Person p2 = new Person("1", "B", Role.MANAGER);

        repo.add(p1);
        repo.add(p2);

        assertEquals(1, repo.getAll().size());
    }

    @Test
    void testRemove() {
        GenericRepository<Product> repo = new GenericRepository<>(Product::getCode);
        Product prod = new Product("P1", "TV", 10000);
        repo.add(prod);
        repo.remove(prod);

        assertEquals(0, repo.getAll().size());
    }

    @Test
    void testFindNonExistentIdentity() {
        GenericRepository<Product> repo = new GenericRepository<>(Product::getCode);
        assertNull(repo.findByIdentity("XYZ"));
    }
}
