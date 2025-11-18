import domain.Person;
import exception.InvalidDataException;
import log.Log;
import repository.PersonRepository;

public class Main {
    public static void main(String[] args) {

        PersonRepository repo = new PersonRepository();

        try {
            Log.info("Attempting to create valid Person...");
            Person p1 = new Person("Vitalina", 20);
            repo.add(p1);
            Log.info("Successfully added: " + p1);
        } catch (InvalidDataException e) {
            Log.error(e.getMessage());
        }

        try {
            Log.info("Attempting to create invalid Person...");
            Person p2 = new Person("", -5);
            repo.add(p2);
        } catch (InvalidDataException e) {
            Log.error("Validation errors: " + e.getMessage());
        }

        try {
            Log.info("Attempting to update age to invalid value...");
            Person p3 = new Person("Alex", 25);
            p3.setAge(-10);
        } catch (InvalidDataException e) {
            Log.error("Setter validation error: " + e.getMessage());
        }

        Log.info("All saved persons:");
        repo.getAll().forEach(System.out::println);
    }
}
