package model;

public class Group implements Comparable<Group> {
    private String groupName;
    private int year;
    private int studentCount;

    public Group(String groupName, int year, int studentCount) {
        this.groupName = groupName;
        this.year = year;
        this.studentCount = studentCount;
    }

    public String getGroupName() { return groupName; }
    public int getYear() { return year; }
    public int getStudentCount() { return studentCount; }

    @Override
    public int compareTo(Group other) {
        return this.groupName.compareToIgnoreCase(other.groupName);
    }

    @Override
    public String toString() {
        return String.format("Group{name='%s', year=%d, count=%d}", groupName, year, studentCount);
    }
}
