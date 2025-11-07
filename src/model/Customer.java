package model;

public class Customer {
    private String name;
    private int age;
    private String city;

    public Customer(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return String.format("Customer{name='%s', age=%d, city='%s'}", name, age, city);
    }
}
