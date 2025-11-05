package repository;

import model.Student;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepository extends GenericRepository<Student> {

    public List<Student> findByName(String namePart) {
        logger.info("Пошук студентів за іменем, що містить: " + namePart);
        return items.stream()
                .filter(s -> s.getName().toLowerCase().contains(namePart.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Student> findByAgeRange(int minAge, int maxAge) {
        logger.info("Пошук студентів за віковим діапазоном: " + minAge + "-" + maxAge);
        return items.stream()
                .filter(s -> s.getAge() >= minAge && s.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    public double getAverageOfGrades() {
        logger.info("Обчислення середнього балу всіх студентів");
        return items.stream()
                .map(Student::getAverageGrade)
                .reduce(0.0, Double::sum) / items.size();
    }
}
