package by.bsuir.studytracker.view;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView(){
        scanner = new Scanner(System.in);

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
                "║   5. Update Student by id  ║\n" +
                "║   6. Display all instr     ║\n" +
                "║   7. Delete instructor     ║\n" +
                "║   8. Display instr by id   ║\n" +
                "║   9. Update Instr   by id  ║\n" +
                "║   10. add Instr            ║\n" +
                "║   0. Exit                  ║\n" +
                "║                            ║\n" +
                "╚════════════════════════════╝");

    }


    public void displayInstructorMenu(){
        System.out.println("\t\t\tChoose option\n" +
                "1.Display All Courses\n" +
                "2.Add course\n" +
                "3.Update course\n" +
                "4.Delete course\n" +
                "5.Find course\n" +
                "0.Exit");
    }


    public void displayStudentMenu(){
        System.out.println("\t\t\tChoose option\n" +
                "1.My Courses\n" +
                "2.All Courses\n" +
                "3.Enroll in Course\n" +
                "0.Exit");
    }
}
