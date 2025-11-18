import domain.Person;
import exception.InvalidDataException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void validPersonCreated() {
        Person p = new Person("Anna", 30);
        assertEquals("Anna", p.getName());
        assertEquals(30, p.getAge());
    }

    @Test
    void invalidPersonThrowsException() {
        InvalidDataException ex = assertThrows(
                InvalidDataException.class,
                () -> new Person("", -1)
        );
        assertTrue(ex.getMessage().contains("name"));
        assertTrue(ex.getMessage().contains("age"));
    }

    @Test
    void setterValidationWorks() {
        Person p = new Person("Max", 22);
        assertThrows(InvalidDataException.class, () -> p.setAge(0));
        assertThrows(InvalidDataException.class, () -> p.setName(""));
    }
}
