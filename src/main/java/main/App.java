package main;

import java.util.Scanner;
import main.java.main.Gifu;
import main.java.main.Course;
import main.java.main.Enrollment;
import main.java.main.Student;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Tervetuloa Gifu-järjestelmään");
        System.out.println("Mille yliopistolle haluat ottaa järjestelmän käyttöön?");
        String university = sc.nextLine();
        Gifu gifu = new Gifu(university);

        boolean exit = false;

        while(!exit) {
            System.out.println("1) Luo uusi kurssi, 2) Luo uusi opiskelija, 3) Listaa kurssit, 4) Listaa opiskelijat, 5) Lisää opiskelija kurssille, 6) Anna kurssiarvosanat, 7) Listaa kurssilla olevat opiskelijat, 8) Listaa opiskelijan arvosanat, 9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, 0) Lopeta ohjelma");
            
            if(sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch (i) {
                    case 1:
                        System.out.println("Anna kurssin nimi:");
                        String courseName = sc.nextLine();
                        System.out.println("Anna kurssin ID:");
                        String courseId = sc.nextLine();
                        System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                        String stringMaxNumberOfStudents = sc.nextLine();
                        int maxNumberOfStudents = Integer.parseInt(stringMaxNumberOfStudents);
                        gifu.addCourse(courseName, courseId, maxNumberOfStudents);

                        break;
                    
                    case 2:
                        System.out.println("Anna opiskelijan nimi:");
                        String studentName = sc.nextLine();
                        System.out.println("Anna opiskelijan opiskelijanumero:");
                        String studentId = sc.nextLine();
                        gifu.addStudent(studentName, studentId);
        
                        break;

                    case 3:
                        gifu.listCourses();
                        break;

                    case 4:
                        gifu.listStudents();
                        break;

                    case 5:
                        gifu.listCourses();
                        System.out.println("Mille kurssille haluat lisätä opiskelijan? Syötä kurssin numero:");
                        String stringCourseIndex = sc.nextLine();
                        int courseIndex = Integer.parseInt(stringCourseIndex);
                        
                        gifu.listStudents();
                        System.out.println("Minkä opiskelijan haluat lisätä kurssille? Syötä opiskelijan numero:");
                        String stringStudentIndex = sc.nextLine();
                        int studentIndex = Integer.parseInt(stringStudentIndex);
                        gifu.enrollStudent(studentIndex, courseIndex);
                        break;

                    case 6:
                        gifu.listCourses();
                        System.out.println("Minkä kurssin haluat arvostella? Syötä kurssin numero:");
                        int course = Integer.parseInt(sc.nextLine());
                        ArrayList<Enrollment> enrollments = gifu.getEnrollments(gifu.getCourse(course));
                        for (Enrollment enrollment : enrollments) {
                            System.out.println("Opiskelija: " + enrollment.getStudent().getInformation() + ", Anna arvosana:");
                            int grade = Integer.parseInt(sc.nextLine());
                            enrollment.gradeCourse(grade);;
                        }
                        break;

                    case 7:
                        gifu.listCourses();
                        System.out.println("Minkä kurssin opiskelijat haluat listata? Syötä kurssin numero:");
                        int listCourseIndex = Integer.parseInt(sc.nextLine());
                        ArrayList<Enrollment> courseEnrollments = gifu.getEnrollments(gifu.getCourse(listCourseIndex));
                        for (Enrollment e : courseEnrollments) {
                            System.out.println(e.getStudent().getInformation());
                        }
                        break;

                    case 8:
                        gifu.listStudents();
                        System.out.println("Minkä opiskelijan arvosanat haluat listata? Syötä opiskelijan numero:");
                        int studentGradesIndex = Integer.parseInt(sc.nextLine());
                        gifu.listStudentGrades(gifu.getStudent(studentGradesIndex));

                        break;    
                    
                    case 9:
                        gifu.listAllGrades();
                        break;
                        
                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä");
                        exit = true;
                        break;

                    default:
                        System.out.println("Väärä syöte");
                        break;
                }
            }
        }
        sc.close();
    }
}
