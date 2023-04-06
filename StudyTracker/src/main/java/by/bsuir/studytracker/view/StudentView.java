package by.bsuir.studytracker.view;

import by.bsuir.studytracker.application.Encryptor;
import by.bsuir.studytracker.application.Login;
import by.bsuir.studytracker.domain.Student;
import by.bsuir.studytracker.exception.ServiceException;
import by.bsuir.studytracker.service.StudentService;
import by.bsuir.studytracker.service.impl.StudentServiceImpl;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;


public class StudentView {
    private StudentService studentService;
    private Scanner scanner;

    private Encryptor encryptor = new Encryptor();

    public StudentView(Connection connection) {
        this.studentService = new StudentServiceImpl(connection);
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
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter id number: ");
        String idNumber = scanner.nextLine();
        System.out.print("Enter complete address: ");
        String completeAddress = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
//        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        String hashedPassword = null;
        try {
            hashedPassword = encryptor.encryptString(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Enter account Status: ");
        int accountStatus = Integer.parseInt(scanner.nextLine());

        Student student = new Student(lastName,firstName,idNumber,completeAddress,phoneNumber,email,hashedPassword,accountStatus);

        try {
            studentService.addStudent(student);
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public void findAllStudents() throws ServiceException {
         List<Student> students = studentService.findAllStudents();

        studentConsoleTable();
        for (Student student : students) {
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    student.getStudentId(),
                    student.getLastName(),
                    student.getFirstName(),
                    student.getIdNumber(),
                    student.getCompleteAddress(),
                    student.getPhoneNumber(),
                    student.getEmailAddress(),
                    student.getAccount_status()
            );
        }
    }


    public void findStudentById() {
        System.out.println("What user by his id u want to found");
        int id = Integer.parseInt(scanner.nextLine());

        try {
            Student student = studentService.findStudentById(id);
            studentConsoleTable();
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    student.getStudentId(),
                    student.getLastName(),
                    student.getFirstName(),
                    student.getIdNumber(),
                    student.getCompleteAddress(),
                    student.getPhoneNumber(),
                    student.getEmailAddress(),
                    student.getAccount_status()
            );
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }


    private void studentConsoleTable(){
        String[] headers = { "ID", "Last Name", "First Name", "ID Number", "Address", "Phone Number", "Email", "Account Status" };
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

        String[] result = {id, password};
        return result;
    }
}
