import model.Student;
import model.Group;
import repository.StudentRepository;
import repository.GroupRepository;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepo = new StudentRepository();
        studentRepo.add(new Student("Олена", 20, 88.5));
        studentRepo.add(new Student("Андрій", 19, 91.0));
        studentRepo.add(new Student("Іван", 21, 85.3));

        GroupRepository groupRepo = new GroupRepository();
        groupRepo.add(new Group("ПМ-21", 2021, 25));
        groupRepo.add(new Group("ІТ-22", 2022, 30));
        groupRepo.add(new Group("ФІ-20", 2020, 20));

        System.out.println("=== Студенти за іменем (asc) ===");
        studentRepo.sortByIdentity("asc");
        studentRepo.getAll().forEach(System.out::println);

        System.out.println("\n=== Студенти за віком (desc) ===");
        studentRepo.sortByAge(false);
        studentRepo.getAll().forEach(System.out::println);

        System.out.println("\n=== Студенти за середнім балом ===");
        studentRepo.sortByGrade();
        studentRepo.getAll().forEach(System.out::println);

        System.out.println("\n=== Групи за роком ===");
        groupRepo.sortByYear(true);
        groupRepo.getAll().forEach(System.out::println);

        System.out.println("\n=== Групи за кількістю студентів ===");
        groupRepo.sortByStudentCount();
        groupRepo.getAll().forEach(System.out::println);
    }
}
