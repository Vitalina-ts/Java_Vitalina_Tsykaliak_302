package entities;

public class Person {
    private String id;
    private String name;
    private Role role;

    public Person(String id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Role getRole() { return role; }

    @Override
    public String toString() {
        return "Person{id='" + id + "', name='" + name + "', role=" + role + "}";
    }
}
