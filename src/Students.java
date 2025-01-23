package src;
import java.util.ArrayList;
import java.util.HashMap;

public class Students {
    private HashMap<String, ArrayList<Integer>> studentGrades = new HashMap<String, ArrayList<Integer>>();

    public void addStudent(String name, ArrayList<Integer> grades) throws StudentAlreadyExistsException{
        if(studentGrades.get(name) != null){
            throw new StudentAlreadyExistsException("The student you are trying to add already exists :(");
        } else {
            studentGrades.put(name, grades);
        }
    }

    public void addGrade(String name, Integer newGrade){
        ArrayList<Integer> currentGrade = studentGrades.get(name);
        currentGrade.add(newGrade);
        studentGrades.put(name, currentGrade);
    }
    public void displayStudent(String name) throws StudentNotFoundException{
        ArrayList<Integer> grades = studentGrades.get(name);

        if (grades == null){
            throw new StudentNotFoundException("The student is not register in the system :(");
        } else {
            System.out.println("Student name: " + name);
            System.out.println("Grades :" + grades.toString());
            System.out.println("Average grade: " + calculateAverage(grades));
        }
    }

    public void displayHighPerformanceStudents(double value){
        System.out.println("The students with an average grade greater than " + value + " are: ");
        studentGrades.forEach((name, grades) -> {
            double studentAverage = calculateAverage(grades);
            if (studentAverage > value){
                System.out.println("- " + name);
            }
        });
    }

    private double calculateAverage(ArrayList<Integer> grades){
        Integer gradeCount = 0;

        for (Integer n:grades){
            gradeCount += n;
        }

        return (double) gradeCount /grades.size();
    }
}
