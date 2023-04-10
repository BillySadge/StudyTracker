package by.bsuir.studytracker.view;

import by.bsuir.studytracker.dao.CourseDao;
import by.bsuir.studytracker.dao.EnrollmentDao;
import by.bsuir.studytracker.dao.connection.PostgresConnectionPool;
import by.bsuir.studytracker.dao.impl.CourseDaoImpl;
import by.bsuir.studytracker.dao.impl.EnrollmentDaoImpl;
import by.bsuir.studytracker.domain.Course;
import by.bsuir.studytracker.domain.Enrollment;
import by.bsuir.studytracker.exception.ServiceException;
import by.bsuir.studytracker.service.CourseService;
import by.bsuir.studytracker.service.EnrollmentService;
import by.bsuir.studytracker.service.impl.CourseServiceImpl;
import by.bsuir.studytracker.service.impl.EnrollmentServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

public class EnrollmentView {

    private EnrollmentDao enrollmentDao;
    {
        try {
            enrollmentDao = new EnrollmentDaoImpl(new PostgresConnectionPool(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private EnrollmentService enrollmentService;
    private Scanner scanner;

    public EnrollmentView() {
        this.scanner = new Scanner(System.in);
        this.enrollmentService = new EnrollmentServiceImpl(enrollmentDao);
    }


    public void addEnrollment(int userId) {
        System.out.print("Enter course id: ");
        int courseId = scanner.nextInt();


        Enrollment enrollment = new Enrollment(userId,courseId, Instant.now(),"active");

        try {
            enrollmentService.addEnrollment(enrollment);
            System.out.println("course added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding enroll: " + e.getMessage());
        }
    }

    public void deleteEnrollment(){
        System.out.println("Which enroll id u want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        try {
            enrollmentService.deleteEnrollment(id);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }

    public void findAllEnrollments() throws ServiceException {
        List<Enrollment> enrollments = enrollmentService.findAllEnrollments();

        studentConsoleTable();
        for (Enrollment enrollment : enrollments) {
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    enrollment.getEnrollmentId(),
                    enrollment.getStudentId(),
                    enrollment.getCourseId(),
                    enrollment.getEnrollmentDate(),
                    enrollment.getEnrollmentStatus()
            );
        }
    }


    public void findEnrollmentById() {
        System.out.println("What enrollment by his id u want to found");
        int id = Integer.parseInt(scanner.nextLine());

        try {
            Enrollment enrollment = enrollmentService.findEnrollmentById(id);
            studentConsoleTable();
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    enrollment.getEnrollmentId(),
                    enrollment.getStudentId(),
                    enrollment.getCourseId(),
                    enrollment.getEnrollmentDate(),
                    enrollment.getEnrollmentStatus()
            );
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }

    public void findCourseById(int id) {
        try {
            Enrollment enrollment = enrollmentService.findEnrollmentById(id);
            studentConsoleTable();
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    enrollment.getEnrollmentId(),
                    enrollment.getStudentId(),
                    enrollment.getCourseId(),
                    enrollment.getEnrollmentDate(),
                    enrollment.getEnrollmentStatus()
            );
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }


    private void studentConsoleTable(){
        String[] headers = { "ID", "student ID", "Course ID", "Enrollment_date", "enrollment_status"};
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
