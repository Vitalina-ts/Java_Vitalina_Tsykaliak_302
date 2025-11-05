package repository;

import model.Student;
import java.util.Collections;

public class StudentRepository extends GenericRepository<Student> {

    public void sortByAge(boolean ascending) {
        logger.info("Сортування студентів за віком (" + (ascending ? "зростання" : "спадання") + ")");
        if (ascending)
            Collections.sort(items, Student.BY_AGE);
        else
            Collections.sort(items, Student.BY_AGE.reversed());
    }

    public void sortByGrade() {
        logger.info("Сортування студентів за середнім балом (зростання)");
        items.sort(Student.BY_GRADE);
    }
}
