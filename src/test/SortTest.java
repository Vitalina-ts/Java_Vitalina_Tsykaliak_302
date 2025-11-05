import model.Student;
import model.Group;
import repository.StudentRepository;
import repository.GroupRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortTest {

    @Test
    public void testStudentSortByName() {
        StudentRepository repo = new StudentRepository();
        repo.add(new Student("Богдан", 20, 80));
        repo.add(new Student("Андрій", 22, 90));
        repo.sortByIdentity("asc");

        assertEquals("Андрій", repo.getAll().get(0).getName());
    }

    @Test
    public void testStudentSortByGrade() {
        StudentRepository repo = new StudentRepository();
        repo.add(new Student("Іван", 21, 70));
        repo.add(new Student("Марія", 21, 95));
        repo.sortByGrade();

        assertEquals(70, repo.getAll().get(0).getAverageGrade());
    }

    @Test
    public void testGroupSortByYear() {
        GroupRepository repo = new GroupRepository();
        repo.add(new Group("ІТ-23", 2023, 28));
        repo.add(new Group("ПМ-21", 2021, 30));
        repo.sortByYear(true);

        assertEquals(2021, repo.getAll().get(0).getYear());
    }
}
