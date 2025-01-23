package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Students st = new Students();
        Scanner sc = new Scanner(System.in);
        Boolean go = true;

        // Menu code
        do {
            System.out.println("Welcome to the Student Management System");
            System.out.println("1- Add Student");
            System.out.println("2- Add Grade for a Student");
            System.out.println("3- View Student Details");
            System.out.println("4- View High Performance Students");
            System.out.println("5- Exit");

            int action = sc.nextInt();
            String name;
            String grades;
            Integer grade;
            Double average;

            switch (action){
                case 1: // Code for adding a new student
                    System.out.println("Name of the new student: ");
                    name = sc.next();
                    System.out.println("Grades of the new student (Between commas): ");
                    grades = sc.next();
                    String[] splitGrades = grades.split(",");
                    ArrayList<Integer> listOfGrades = new ArrayList<Integer>();

                    for (String g:splitGrades){
                        listOfGrades.add(Integer.parseInt(g.replace(",", "")));
                    }
                    try {
                        st.addStudent(name, listOfGrades);
                    } catch (StudentAlreadyExistsException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:  // Code for adding a grade to an existing student
                    System.out.println("Name of the student you want to add a grade: ");
                    name = sc.next();
                    System.out.println("New Grade: ");
                    grade = sc.nextInt();

                    try{
                        st.addGrade(name, grade);
                    } catch (StudentNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3: // Code use to see details of a student
                    System.out.println("Name of the student you want to see details: ");
                    name = sc.next();

                    try{
                        st.displayStudent(name);
                    } catch (StudentNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4: // Code use to see high performance students
                    System.out.println("Enter an average to check: ");
                    average = sc.nextDouble();
                    st.displayHighPerformanceStudents(average);
                    break;
                case 5: // Code for exit
                    System.out.println("Goodbye!!");
                    go = false;
                    break;
            }

        } while (go);

    }
}
