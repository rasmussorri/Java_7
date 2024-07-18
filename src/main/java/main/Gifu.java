package main.java.main;

import java.util.ArrayList;


public class Gifu {
    private String university;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    // private ArrayList<Enrollment> enrollments = new ArrayList<>();

    public Gifu(String university) {
        this.university = university;
    }

    public void addCourse(String courseName, String courseId, int maxNumberOfStudents) {
        courses.add(new Course(courseName, courseId, maxNumberOfStudents));
    }
    /*
    public int getCourse() {

    }
*/
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void listCourses() {
        int i = 0;
        for (Course c : getCourses()) {
            System.out.println(i + ") " + c.getInformation());
            i++;
        }
    }

    public void addStudent(String studentName, String studentId) {
        students.add(new Student(studentName, studentId));
    }
/*
    public int getStudent() {

    }

    public void listStudents() {

    }

    public void enrollStudent() {

    }

    public ArrayList<Course> getEnrollments(course : Course) {

    }

    public ArrayList<Student> getEnrollments(student : Student) {

    }*/
}
