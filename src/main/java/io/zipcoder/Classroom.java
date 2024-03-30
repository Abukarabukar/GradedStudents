package io.zipcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Classroom {



    //store students
    Student[] students;


    // Constructor
    public Classroom(Student[] students) {
        this.students = students;
    }

    //max numberOfStudent constructor
    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }


        // Default constructor
    public Classroom() {
        // The class has 30 studnets
        this.students = new Student[30];
    }

 //getStudents
    public Student[] getStudents() {
        return students;
    }

    // average exam score
    public double getAverageExamScore() {
        double sum = 0;
        int count = 0;
        for (Student student : students) {
            if (student != null) {
                sum += student.getAverageExamScore();
                count++;
            }
        }
        //if is less or equal 0, return to 0.0. otherwise sum / count;
        return count > 0 ? sum / count : 0.0;
    }

    // new student to the classroom
    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
    }

    // Remove a student
    public void removeStudent(String firstName, String lastName) {
       for (int i = 0; i < students.length; i++){
           Student student = students[i];
           if (students[i] != null && student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
               students[i] = null;// Reorder the array to move nulls to the end
           }
       }
//        for (int i = 0; i < students.length; i++) {
//            Student student = students[i];
//            if (student != null && student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
//                students[i] = null; // Remove the student by setting their slot to null
//                break;
//            }
//        }
//        Arrays.sort(students, Comparator.nullsLast(Comparator.comparing(Student::getFirstName)));
    }

    // students ordered by their average score//
    public Student[] getStudentsByScore() {
//
        Arrays.sort(students, Comparator.nullsLast(Comparator.comparing(Student::getAverageExamScore).reversed()));

        return students;
    }


    private double calculatePercentile(double score) {
        double higherScores = 0;
        double totalScores = 0;
        for (Student student : students) {
            if (student != null) {
                totalScores++;
                if (student.getAverageExamScore() > score) {
                    higherScores++;
                }
            }
        }
        return 100.0 * (1 - (higherScores / totalScores));
    }


    private char assignLetterGrade(double percentile) {
        if (percentile >= 90) return 'A';
        else if (percentile >= 70) return 'B';
        else if (percentile >= 50) return 'C';
        else if (percentile >= 11) return 'D';
        else return 'F';
    }


}
