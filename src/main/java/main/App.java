package main;

import java.util.Scanner;

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
