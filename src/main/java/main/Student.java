package main.java.main;

public class Student implements PrintInfo{
    private String studentName;
    private String studentId;

    public Student(String studentName, String studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }

    @Override
    public String getInformation() {
        return studentId + " " + studentName;
    }
}
