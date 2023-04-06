package by.bsuir.studytracker.application;

import by.bsuir.studytracker.controller.MainController;
import by.bsuir.studytracker.controller.StudentController;
import by.bsuir.studytracker.dao.connection.DatabaseConnection;
import by.bsuir.studytracker.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            StudentController studentController = new StudentController(connection);
            MainController mainController = new MainController(connection);
            Scanner scanner = new Scanner(System.in);
            Login login = new Login(connection);
            boolean exit = false;

            while (!exit) {
                mainController.displayAdminMenu();
                String choice = scanner.nextLine();

                switch (choice) {
                    case "6":
                        String[] data = mainController.login();
                        login.login(data[0], data[1]);
                        break;
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
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        for (int i = 0; i < 100; i++) {
                            System.out.println();
                        }
//                        System.out.print("\033[H\033[2J");
//                        System.out.flush();
//                        try {
//                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//                        } catch (Exception e) {
//                            // handle the exception
//                        }
                        break;
                }
            }

            System.out.println("Exiting...");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }

    }



}