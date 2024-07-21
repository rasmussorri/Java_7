package main.java.main;

import java.util.ArrayList;


public class Gifu {
    private String university;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    public Gifu(String university) {
        this.university = university;
    }

    public void addCourse(String courseName, String courseId, int maxNumberOfStudents) {
        courses.add(new Course(courseName, courseId, maxNumberOfStudents));
    }

    public Course getCourse(int course) {
        return courses.get(course);
    }

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

    public Student getStudent(int student) {
        return students.get(student);
    }

    public void listStudents() {
        int i = 0;
        for (Student s : students) {
            System.out.println(i + ") " + s.getInformation());
            i++;
        }
        
    }

    public void enrollStudent(int studentIndex, int courseIndex) {
        enrollments.add(new Enrollment(students.get(studentIndex), courses.get(courseIndex)));
    }

    public ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }

    public ArrayList<Enrollment> getEnrollments(Course course) {
        ArrayList<Enrollment> courseEnrollments = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getCourse().equals(course)) {
                courseEnrollments.add(e);
            }
        }
        return courseEnrollments;
    }

    public ArrayList<Enrollment> getEnrollments(Student student) {
        ArrayList<Enrollment> studentEnrollments = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudent().equals(student)) {
                studentEnrollments.add(e);
            }
        }
        return studentEnrollments;
    }

    public void listStudentGrades(Student student) {
        ArrayList<Enrollment> studentEnrollments = getEnrollments(student);
        Boolean printStudent = true;
        for (Enrollment e : studentEnrollments) {
            if(printStudent) {
                System.out.println("Opiskelijan " + e.getStudent().getInformation() + " arvosanat:");
                printStudent = false;
            }
            System.out.println(e.getCourse().getInformation() + ", arvosana: " + e.getGrade());
        }
    }

    public void listAllGrades() {
        Course course;
        Boolean printCourse = true;
        for (Enrollment e : enrollments) {
            if(printCourse) {
                System.out.println(e.getCourse().getInformation());
                printCourse = false;
            }
            course = e.e.getCourse();
            if(!(e.getCourse().equals(course))) {
                System.out.println(e.getCourse().getInformation());
            }
            System.out.println(e.getCourse().getInformation() + " " + e.getStudent().getInformation() + ", arvosana: " + e.getGrade());
        }
    }
}
