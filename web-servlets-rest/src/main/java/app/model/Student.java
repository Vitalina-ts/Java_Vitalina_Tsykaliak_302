package app.model;

public class Student {
    private String id;
    private String name;
    private int age;
    private String departmentId;

    public Student() {}
    public Student(String id, String name, int age, String departmentId) {
        this.id = id; this.name = name; this.age = age; this.departmentId = departmentId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getDepartmentId() { return departmentId; }
    public void setDepartmentId(String departmentId) { this.departmentId = departmentId; }
}
