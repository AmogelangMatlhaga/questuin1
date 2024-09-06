/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progassignment1b;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lethabo Molate
 */
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;

public class ProgAssignment1BTest {

    private ArrayList<ProgAssignment1B.Student> students;

    @BeforeEach
    public void setUp() {
        students = new ArrayList<>();
    }

    @Test
    public void testSaveStudent() {
        ProgAssignment1B.Student student = new ProgAssignment1B.Student("John Doe", "john@example.com", 20, "S001", "Computer Science");
        ProgAssignment1B.Student.saveStudent(students, student);

        assertEquals(1, students.size());
        assertEquals("John Doe", students.get(0).getName());
        assertEquals("john@example.com", students.get(0).getEmail());
        assertEquals(20, students.get(0).getAge());
        assertEquals("S001", students.get(0).getStudentId());
        assertEquals("Computer Science", students.get(0).getCourse());
    }

    @Test
    public void testSearchStudentFound() {
        ProgAssignment1B.Student student = new ProgAssignment1B.Student("Jane Doe", "jane@example.com", 22, "S002", "Mathematics");
        students.add(student);

        // Replace System.out with a stream to capture output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        ProgAssignment1B.Student.searchStudent(students, "S002");

        String expectedOutput = "Student found: Jane Doe, Age: 22\n";
        assertEquals(expectedOutput, outContent.toString().trim());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    public void testSearchStudentNotFound() {
        // Replace System.out with a stream to capture output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        ProgAssignment1B.Student.searchStudent(students, "S003");

        String expectedOutput = "Error: Student cannot be located.";
        assertEquals(expectedOutput, outContent.toString().trim());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    public void testDeleteStudentFound() {
        ProgAssignment1B.Student student = new ProgAssignment1B.Student("Jack Smith", "jack@example.com", 23, "S004", "Physics");
        students.add(student);

        // Replace System.out with a stream to capture output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        ProgAssignment1B.Student.deleteStudent(students, "S004");

        String expectedOutput = "Student has been deleted.";
        assertEquals(expectedOutput, outContent.toString().trim());
        assertEquals(0, students.size());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    public void testDeleteStudentNotFound() {
        // Replace System.out with a stream to capture output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        ProgAssignment1B.Student.deleteStudent(students, "S005");

        String expectedOutput = "Error: Student cannot be located.";
        assertEquals(expectedOutput, outContent.toString().trim());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    public void testStudentReport() {
        ProgAssignment1B.Student student1 = new ProgAssignment1B.Student("John Doe", "john@example.com", 20, "S001", "Computer Science");
        ProgAssignment1B.Student student2 = new ProgAssignment1B.Student("Jane Doe", "jane@example.com", 22, "S002", "Mathematics");
        students.add(student1);
        students.add(student2);

        // Replace System.out with a stream to capture output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        ProgAssignment1B.Student.studentReport(students);

        String expectedOutput = "Student Report:\n" +
                                "ID: S001, Name: John Doe, Age: 20\n" +
                                "ID: S002, Name: Jane Doe, Age: 22";
        assertEquals(expectedOutput, outContent.toString().trim());

        // Reset System.out
        System.setOut(System.out);
    }
}

