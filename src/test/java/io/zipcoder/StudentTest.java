package io.zipcoder;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
    private Student student;



    @Before
    public void setUp() {

        Double[] examScores = {75.0, 88.0, 92.0};
        student = new Student("John", "Doe", examScores);
    }

    @Test
    public void testGetNumberOfExamsTaken() {

        assertEquals(3, student.getNumberOfExamsTaken());
    }

    @Test
    public void testAddExamScore() {

        student.addExamScore(95.0);
        assertEquals(4, student.getNumberOfExamsTaken());
    }

    @Test
    public void testSetExamScore() {

        student.setExamScore(1, 100.0);
        String examScoresString = student.getExamScores();
        assertTrue(examScoresString.contains("100.0"));
    }

    @Test
    public void testGetAverageExamScore() {

        assertEquals(85.0, student.getAverageExamScore(), 0.01);
    }

    @Test
    public void testToString() {

        String studentString = student.toString();
        assertTrue(studentString.contains("John Doe"));
        assertTrue(studentString.contains("75.0"));
        assertTrue(studentString.contains("88.0"));
        assertTrue(studentString.contains("92.0"));
    }
}

