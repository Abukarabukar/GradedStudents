package io.zipcoder;

import java.util.ArrayList;
import java.util.List;

public class Student {


    private String firstName;
    private String lastName;
    private List<Double> examScores;


    public Student(String firstName, String lastName, Double[] examScoresArray) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>();
        for (Double score : examScoresArray) {
            this.examScores.add(score);
        }
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Setter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Returns the total number of exams
    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    // Adds an exam
    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    // Modifies the score for an existing exam.
    public void setExamScore(int examNumber, double newScore) {
        if (examNumber >= 1 && examNumber <= examScores.size()) {
            examScores.set(examNumber - 1, newScore);
        }
    }

    // the average of all exam scores.
    public double getAverageExamScore() {
        if (examScores.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Double score : examScores) {
            sum += score;
        }
        return sum / examScores.size();
    }

    // formatted string of the student's exam scores.
    public String getExamScores() {
        StringBuilder scoresBuilder = new StringBuilder("Exam Scores:\n");
        int examNumber = 1;
        for (Double score : examScores) {
            scoresBuilder.append(String.format("    Exam %d -> %.1f\n", examNumber++, score));
        }
        return scoresBuilder.toString();
    }


    @Override
    public String toString() {
        return String.format("Student Name: %s %s\nAverage Score: %.1f\n%s",
                getFirstName(), getLastName(), getAverageExamScore(), getExamScores());
    }
}
