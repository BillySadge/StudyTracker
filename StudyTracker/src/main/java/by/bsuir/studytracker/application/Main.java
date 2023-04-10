package by.bsuir.studytracker.application;

import by.bsuir.studytracker.application.utils.Login;
import by.bsuir.studytracker.controller.AdminController;
import by.bsuir.studytracker.controller.MainController;
import by.bsuir.studytracker.controller.StudentController;
import by.bsuir.studytracker.dao.connection.PostgresConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
            StudentController studentController = new StudentController();
            MainController mainController = new MainController();
            Scanner scanner = new Scanner(System.in);
            final PostgresConnectionPool connectionPool = new PostgresConnectionPool(10);
            int userType = -1;
            int userId = -1;
            Connection connection = connectionPool.getConnection();
            Login login = new Login(connection);
            boolean exit = false;
            boolean loginForm = false;
            while (!loginForm){
                String[] data = mainController.login();
                int[] loginData = login.login(data[0],data[1]);
                userId = loginData[0];
                userType = loginData[1];
                switch (userType){
                    case 0,1,2:
                        loginForm = true;
                        break;
                    case -1:
                        break;
                }
            }

            switch (userType){
                case 0 -> {
                        mainController.displayAdminMenu();
                        AdminController.adminStudentFunctionality(scanner,mainController,login,studentController);
                }
                case 1 -> {
                    mainController.displayStudentMenu();
                    AdminController.studentFunctionality(scanner,mainController,login,studentController,userId);
                    System.out.println("Student");
                }
                case 2 -> {
                    mainController.displayInstructorMenu();
                    AdminController.instructorFunctionality(scanner,mainController,login,studentController);
                    System.out.println("instructor");
                }

                default -> {
                        break;
                }
            }

            System.out.println("Exiting...");
        }




}