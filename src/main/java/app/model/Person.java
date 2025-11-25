package app.model;

public class Person {
    private final String name;
    private final int age;
    private final double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " (" + age + ", " + salary + ")";
    }
}
