package by.bsuir.studytracker.view;

import by.bsuir.studytracker.application.utils.Encryptor;
import by.bsuir.studytracker.dao.InstructorDao;
import by.bsuir.studytracker.dao.connection.PostgresConnectionPool;
import by.bsuir.studytracker.dao.impl.InstructorDaoImpl;
import by.bsuir.studytracker.domain.Instructor;
import by.bsuir.studytracker.exception.ServiceException;
import by.bsuir.studytracker.service.InstructorService;
import by.bsuir.studytracker.service.impl.InstructorServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class InstructorView {


    private InstructorDao instructorDao;
    {
        try {
            instructorDao = new InstructorDaoImpl(new PostgresConnectionPool(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private InstructorService instructorService;
    private Scanner scanner;

    public InstructorView(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
        this.scanner = new Scanner(System.in);
        this.instructorService = new InstructorServiceImpl(instructorDao);
    }
    private Encryptor encryptor = new Encryptor();

    public InstructorView(Connection connection) {
        this.instructorService = new InstructorServiceImpl(instructorDao);
        this.scanner = new Scanner(System.in);
    }

    public InstructorView() {
        this.scanner = new Scanner(System.in);
        this.instructorService = new InstructorServiceImpl(instructorDao);

    }

    public void deleteInstructor(){
        System.out.println("Which instr id u want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        try {
            instructorService.deleteInstructor(id);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
    public void addInstructor() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String hashedPassword = null;
        try {
            hashedPassword = encryptor.encryptString(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        Instructor instructor = new Instructor(firstName,lastName,email,phoneNumber,hashedPassword);

        try {
            instructorService.addInstructor(instructor);
            System.out.println("Intrs added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding instr: " + e.getMessage());
        }
    }


    public void updateInstructor() {
        System.out.print("Enter the intrc ID: ");
        int instrId = scanner.nextInt();
        Instructor instructor = null;
        try {
            instructor = instructorService.findInstructorById(instrId);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }


        if (instructor == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Current student details:");
        findInstructorById(instrId);

        System.out.print("Enter updated first name (leave blank to keep current): ");
        String firstName = scanner.nextLine();
        if (!firstName.isEmpty()) {
            instructor.setFirstName(firstName);
        }

        System.out.print("Enter updated last name (leave blank to keep current): ");
        String lastName = scanner.nextLine();
        if (!lastName.isEmpty()) {
            instructor.setLastName(lastName);
        }

        System.out.print("Enter updated email (leave blank to keep current): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            instructor.setEmail(email);
        }

        System.out.print("Enter updated phone number (leave blank to keep current): ");
        String phoneNumber = scanner.nextLine();
        if (!phoneNumber.isEmpty()) {
            instructor.setPhoneNumber(phoneNumber);
        }


        try {
            instructorService.updateInstructor(instructor);
            System.out.println("Student updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating instr: " + e.getMessage());
        }
    }
    public void findAllInstructors() throws ServiceException {
        List<Instructor> instructors = instructorService.findAddInstructors();

        studentConsoleTable();
        for (Instructor instructor : instructors) {
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    instructor.getInstructorId(),
                    instructor.getFirstName(),
                    instructor.getLastName(),
                    instructor.getEmail(),
                    instructor.getPhoneNumber()
            );
        }
    }


    public void findInstructorById() {
        System.out.println("What user by his id u want to found");
        int id = Integer.parseInt(scanner.nextLine());

        try {
            Instructor instructor = instructorService.findInstructorById(id);
            studentConsoleTable();
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    instructor.getInstructorId(),
                    instructor.getFirstName(),
                    instructor.getLastName(),
                    instructor.getEmail(),
                    instructor.getPhoneNumber()
                    );
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }

    public void findInstructorById(int id) {
        try {
            Instructor instructor = instructorService.findInstructorById(id);
            studentConsoleTable();
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    instructor.getInstructorId(),
                    instructor.getFirstName(),
                    instructor.getLastName(),
                    instructor.getEmail(),
                    instructor.getPhoneNumber());
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }


    private void studentConsoleTable(){
        String[] headers = { "ID", "First Name", "Last Name", "Email", "Phone Number"};
        System.out.print("|");
        for (String header : headers) {
            System.out.printf(" %-20s |", header);
        }
        System.out.println();
        System.out.print("|");
        for (int i = 0; i < headers.length; i++) {
            System.out.print(StringUtils.repeat("-", 22) + "|");
        }
        System.out.println();
    }


}
