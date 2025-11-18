package domain;

import exception.InvalidDataException;
import validation.Validator;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        StringBuilder errors = new StringBuilder();

        Validator.validateNotEmpty(name, "name", errors);
        Validator.validatePositive(age, "age", errors);

        if (!errors.isEmpty()) {
            throw new InvalidDataException(errors.toString());
        }

        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        StringBuilder errors = new StringBuilder();
        Validator.validateNotEmpty(name, "name", errors);
        if (!errors.isEmpty()) throw new InvalidDataException(errors.toString());
        this.name = name;
    }

    public void setAge(int age) {
        StringBuilder errors = new StringBuilder();
        Validator.validatePositive(age, "age", errors);
        if (!errors.isEmpty()) throw new InvalidDataException(errors.toString());
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
