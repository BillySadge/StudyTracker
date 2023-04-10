package by.bsuir.studytracker.view;

import by.bsuir.studytracker.application.utils.Encryptor;
import by.bsuir.studytracker.dao.StudentDao;
import by.bsuir.studytracker.dao.connection.PostgresConnectionPool;
import by.bsuir.studytracker.dao.impl.StudentDaoImpl;
import by.bsuir.studytracker.domain.Student;
import by.bsuir.studytracker.exception.ServiceException;
import by.bsuir.studytracker.service.StudentService;
import by.bsuir.studytracker.service.impl.StudentServiceImpl;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;


public class StudentView {
    private StudentDao StudentDao;

    {
        try {
            StudentDao = new StudentDaoImpl(new PostgresConnectionPool(50));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private StudentService studentService;
    private Scanner scanner;

    public StudentView() {
        this.scanner = new Scanner(System.in);
        this.studentService = new StudentServiceImpl(StudentDao);
    }
    private Encryptor encryptor = new Encryptor();

    public StudentView(Connection connection) {
        this.studentService = new StudentServiceImpl(StudentDao);
        this.scanner = new Scanner(System.in);
    }
    public void deleteStudent(){
        System.out.println("Which user id u want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        try {
            studentService.deleteStudent(id);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
    public void addStudent() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter card id number: ");
        String idNumber = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String hashedPassword = null;
        try {
            hashedPassword = encryptor.encryptString(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        Student student = new Student(firstName,lastName,email,phoneNumber,idNumber,hashedPassword);

        try {
            studentService.addStudent(student);
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }


    public void updateStudent() {
        System.out.print("Enter the student ID: ");
        int studentId = scanner.nextInt();
        Student student = null;
        try {
            student = studentService.findStudentById(studentId);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }


        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Current student details:");
        findStudentById(studentId);

        System.out.print("Enter updated first name (leave blank to keep current): ");
        String firstName = scanner.nextLine();
        if (!firstName.isEmpty()) {
            student.setFirstName(firstName);
        }

        System.out.print("Enter updated last name (leave blank to keep current): ");
        String lastName = scanner.nextLine();
        if (!lastName.isEmpty()) {
            student.setLastName(lastName);
        }

        System.out.print("Enter updated email (leave blank to keep current): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            student.setEmailAddress(email);
        }

        System.out.print("Enter updated phone number (leave blank to keep current): ");
        String phoneNumber = scanner.nextLine();
        if (!phoneNumber.isEmpty()) {
            student.setPhoneNumber(phoneNumber);
        }

        System.out.print("Enter updated card id number (leave blank to keep current): ");
        String idNumber = scanner.nextLine();
        if (!idNumber.isEmpty()) {
            student.setCardIdNumber(idNumber);
        }


        try {
            studentService.updateStudent(student);
            System.out.println("Student updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }
    public void findAllStudents() throws ServiceException {
         List<Student> students = studentService.findAllStudents();

        studentConsoleTable();
        for (Student student : students) {
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    student.getStudentId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getEmailAddress(),
                    student.getPhoneNumber(),
                    student.getCardIdNumber()
            );
        }
    }


    public void findStudentById() {
        System.out.println("What user by his id u want to found");
        int id = Integer.parseInt(scanner.nextLine());

        try {
            Student student = studentService.findStudentById(id);
            studentConsoleTable();
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    student.getStudentId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getEmailAddress(),
                    student.getPhoneNumber(),
                    student.getCardIdNumber()
            );
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }

    public void findStudentById(int id) {
        try {
            Student student = studentService.findStudentById(id);
            studentConsoleTable();
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    student.getStudentId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getEmailAddress(),
                    student.getPhoneNumber(),
                    student.getCardIdNumber()
            );
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }


    private void studentConsoleTable(){
        String[] headers = { "ID", "First Name", "Last Name", "Email", "Phone Number", "Card Id"};
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

    public String[] loginStudent(){
        System.out.println("Enter your student Id Number");
        String id = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();

        return new String[]{id, password};
    }
}
