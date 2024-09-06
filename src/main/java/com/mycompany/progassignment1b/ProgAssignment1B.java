/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progassignment1b;

/**
 *
 * @author Lethabo Molate
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ProgAssignment1B {

    // Nested Student class
    static class Student {
        private final String name;
        private final String email;
        private final int age;
        private final String studentId;
        private final String course;

        // Constructor
        public Student(String name, String email, int age, String studentId, String course) {
            this.name = name;
            this.email = email;
            this.age = age;
            this.studentId = studentId;
            this.course = course;
        }

        // Getters
        public String getName() {
            return name;
        }
        public String getEmail() {
            return email;
        }
        public int getAge() {
            return age;
        }

        public String getStudentId() {
            return studentId;
        }
        public String getCourse() {
            return course;
        }

        // Methods
        public static void saveStudent(ArrayList<Student> students, Student newStudent) {
            students.add(newStudent);
            System.out.println("Student details have been successfully saved.");
        }

        public static void searchStudent(ArrayList<Student> students, String id) {
            for (Student student : students) {
                if (student.getStudentId().equals(id)) {
                    System.out.println("Student found: " + student.getName() + ", Age: " + student.getAge());
                    return;
                }
            }
            System.out.println("Error: Student cannot be located.");
        }

        public static void deleteStudent(ArrayList<Student> students, String id) {
            for (Student student : students) {
                if (student.getStudentId().equals(id)) {
                    students.remove(student);
                    System.out.println("Student has been deleted.");
                    return;
                }
            }
            System.out.println("Error: Student cannot be located.");
        }

        public static void studentReport(ArrayList<Student> students) {
            System.out.println("Student Report:");
            for (Student student : students) {
                System.out.println("ID: " + student.getStudentId() + ", Name: " + student.getName() + ", Age: " + student.getAge());
            }
        }

        public static void exitStudentApplication() {
            System.out.println("Exiting application...");
            System.exit(0);
        }
    }

    // Main class
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Capture a new student");
            System.out.println("2. Search for a student");
            System.out.println("3. Delete a student");
            System.out.println("4. View student report");
            System.out.println("5. Exit");

            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine();

                    int age;
                    while (true) {
                        System.out.print("Enter student age: ");
                        if (scanner.hasNextInt()) {
                            age = scanner.nextInt();
                            if (age >= 16) break;
                        } else {
                            scanner.next(); // clear invalid input
                        }
                        System.out.println("Invalid age. Please enter a valid age (>= 16).");
                    }
                    scanner.nextLine(); // consume newline

                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter student course: ");
                    String course = scanner.nextLine();

                    Student newStudent = new Student(name, email, age, id, course);
                    Student.saveStudent(students, newStudent);
                    break;

                case 2:
                    System.out.print("Enter student ID to search: ");
                    String searchId = scanner.nextLine();
                    Student.searchStudent(students, searchId);
                    break;

                case 3:
                    System.out.print("Enter student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    Student.deleteStudent(students, deleteId);
                    break;

                case 4:
                    Student.studentReport(students);
                    break;

                case 5:
                    Student.exitStudentApplication();
                    break;

                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        } while (option != 5);

        scanner.close();
    }
}

