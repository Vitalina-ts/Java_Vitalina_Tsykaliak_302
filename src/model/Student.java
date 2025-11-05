package model;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private double averageGrade;

    public Student(String name, int age, double averageGrade) {
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getAverageGrade() { return averageGrade; }

    @Override
    public int compareTo(Student other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', age=%d, avg=%.1f}", name, age, averageGrade);
    }

    // Альтернативні компаратори:
    public static final java.util.Comparator<Student> BY_AGE =
            (s1, s2) -> Integer.compare(s1.getAge(), s2.getAge());

    public static final java.util.Comparator<Student> BY_GRADE =
            java.util.Comparator.comparingDouble(Student::getAverageGrade);
}
