package main.java.main;

import java.util.ArrayList;

public class Gifu {
    private String university;
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Enrollment> enrollments = new ArrayList<>();

    public Gifu(String university) {
        this.university = university;
    }

    public void addCourse(String courseName, String courseId, int maxNumberOfStudents) {
        courses.add(new Course(courseName, courseId, maxNumberOfStudents));
    }
    /*
    public int getCourse() {

    }

    public ArrayList getCourses() {

    }

    public void listCourses() {

    }

    public void addStudent() {

    }

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
