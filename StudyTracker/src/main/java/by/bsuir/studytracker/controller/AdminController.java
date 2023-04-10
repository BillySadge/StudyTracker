package by.bsuir.studytracker.controller;

import by.bsuir.studytracker.application.utils.Login;

import java.util.Scanner;

public class AdminController {

    public static void adminStudentFunctionality(Scanner scanner, MainController mainController, Login login, StudentController studentController) {

        boolean exit = false;
        while (!exit) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    studentController.addStudent();
                    break;
                case "2":
                    studentController.findAllStudents();
                    break;
                case "3":
                    studentController.deleteStudent();
                    break;
                case "4":
                    studentController.findStudentById();
                    break;
                case "5":
                    studentController.updateStudent();
                    break;
                case "6":
                    studentController.findAllInstructors();
                    break;
                case "7":
                    studentController.deleteInstructor();
                    break;
                case "8":
                    studentController.findInstructorById();
                    break;
                case "9":
                    studentController.updateInstructor();
                    break;
                case "10":
                    studentController.addInstructor();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    for (int i = 0; i < 100; i++) {
                        System.out.println();
                    }
                    break;
            }
            mainController.displayAdminMenu();
        }
    }

    public static void instructorFunctionality(Scanner scanner, MainController mainController, Login login, StudentController studentController) {

        boolean exit = false;
        while (!exit) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    studentController.findAllCourses();
                    break;
                case "2":
                    studentController.addCourse();
                    break;
                case "3":
                    studentController.updateCourse();
                    break;
                case "4":
                    studentController.deleteCourse();
                    break;
                case "5":
                    studentController.findCourseById();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    for (int i = 0; i < 100; i++) {
                        System.out.println();
                    }
                    break;
            }
            mainController.displayInstructorMenu();
        }
    }

    public static void studentFunctionality(Scanner scanner, MainController mainController, Login login, StudentController studentController, int userId) {
        boolean exit = false;
        while (!exit) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    studentController.findMyCourses(userId);
                    break;
                case "2":
                    studentController.findAllCourses();
                    break;
                case "3":
                    studentController.addEnrollment(userId);
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    for (int i = 0; i < 100; i++) {
                        System.out.println();
                    }
                    break;
            }
            mainController.displayStudentMenu();
        }
    }
}