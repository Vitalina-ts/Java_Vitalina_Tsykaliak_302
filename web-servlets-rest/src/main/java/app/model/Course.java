package app.model;

public class Course {
    private String id;
    private String title;
    private String departmentId;

    public Course() {}
    public Course(String id, String title, String departmentId) {
        this.id = id; this.title = title; this.departmentId = departmentId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDepartmentId() { return departmentId; }
    public void setDepartmentId(String departmentId) { this.departmentId = departmentId; }
}
