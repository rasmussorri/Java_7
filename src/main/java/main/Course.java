package main.java.main;

public class Course implements PrintInfo{
    private int maxNumberOfStudents;
    private String courseName;
    private String courseId;

    public Course(String courseName, String courseId, int maxNumberOfStudents) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    @Override
    public String getInformation() {
        return courseId + " " + courseName;
    }
}
