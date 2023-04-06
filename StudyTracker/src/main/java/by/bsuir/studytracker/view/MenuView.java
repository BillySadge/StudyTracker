package by.bsuir.studytracker.view;

import by.bsuir.studytracker.service.impl.StudentServiceImpl;

import java.sql.Connection;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner;
    public MenuView(Connection connection) {
        this.scanner = new Scanner(System.in);
    }
    public String[] loginForm(){
        System.out.println("===================================");
        System.out.println("|           LOGIN FORM            |");
        System.out.println("===================================");
        System.out.println("|                                 |");
        System.out.println("|   Enter username:               |");
        String username = scanner.nextLine();
        System.out.println("|                                 |");
        System.out.println("|   Enter password:               |");
        String password = scanner.nextLine();
        System.out.println("|                                 |");
        System.out.println("===================================");
        String[] result = {username, password};
        return result;
    }

    public void displayAdminMenu(){
        System.out.println("╔════════════════════════════╗\n" +
                "║                            ║\n" +
                "║      Choose an option:     ║\n" +
                "║                            ║\n" +
                "║   1. Add student           ║\n" +
                "║   2. Display all students  ║\n" +
                "║   3. Delete user           ║\n" +
                "║   4. Display Student by id ║\n" +
                "║   5. Login                 ║\n" +
                "║   6. Exit                  ║\n" +
                "║                            ║\n" +
                "╚════════════════════════════╝");

    }
}
