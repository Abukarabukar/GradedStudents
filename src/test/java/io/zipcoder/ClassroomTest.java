package io.zipcoder;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.*;

public class ClassroomTest {



    Classroom classroom;
    Student student1, student2, student3;

    @Before
    public void setUp() {

        // Starting a classroom and some students.
        classroom = new Classroom(3);
        student1 = new Student("John", "Doe", new Double[]{88.0, 92.5, 75.0});
        student2 = new Student("Jane", "Doe", new Double[]{95.5, 83.0, 91.0});
        student3 = new Student("Jim", "Beam", new Double[]{70.0, 80.5, 90.0});
    }

    @Test
    public void testAddStudent() {
        classroom.addStudent(student1);
        classroom.addStudent(student2);


        int actual = 0;
        for (Student student : classroom.getStudents()) {
            if (student != null) {
                actual++;
            }
        }

        assertEquals(2, actual);
    }

    @Test
    public void testGetAverageExamScore() {
        classroom.addStudent(student1);
        classroom.addStudent(student2);
        double expectedAverage = (88.0 + 92.5 + 75.0 + 95.5 + 83.0 + 91.0) / 6;
        assertEquals(expectedAverage, classroom.getAverageExamScore(), 0.01);
    }

    @Test
    public void testRemoveStudent() {
        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.removeStudent("John", "Doe");
        assertNull(classroom.getStudents()[0]);
    }

    @Test
    public void testGetStudentsByScore() {
        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        Student[] sortedStudents = classroom.getStudentsByScore();
        assertEquals(student2, sortedStudents[0]);
        assertEquals(student1, sortedStudents[1]);
        assertEquals(student3, sortedStudents[2]);
    }


}