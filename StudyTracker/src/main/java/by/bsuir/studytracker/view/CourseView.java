package by.bsuir.studytracker.view;

import by.bsuir.studytracker.dao.CourseDao;
import by.bsuir.studytracker.dao.InstructorDao;
import by.bsuir.studytracker.dao.connection.PostgresConnectionPool;
import by.bsuir.studytracker.dao.impl.CourseDaoImpl;
import by.bsuir.studytracker.dao.impl.InstructorDaoImpl;
import by.bsuir.studytracker.domain.Course;
import by.bsuir.studytracker.domain.Instructor;
import by.bsuir.studytracker.exception.ServiceException;
import by.bsuir.studytracker.service.CourseService;
import by.bsuir.studytracker.service.StudentService;
import by.bsuir.studytracker.service.impl.CourseServiceImpl;
import by.bsuir.studytracker.service.impl.StudentServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CourseView {

    private CourseDao courseDao;
    {
        try {
            courseDao = new CourseDaoImpl(new PostgresConnectionPool(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private CourseService courseService;
    private Scanner scanner;

    public CourseView() {
        this.scanner = new Scanner(System.in);
        this.courseService = new CourseServiceImpl(courseDao);
    }


    public void addCourse() {
        System.out.print("Enter Course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter Course description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();

        Course course = new Course(courseName,description,courseCode);

        try {
            courseService.addCourse(course);
            System.out.println("course added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding instr: " + e.getMessage());
        }
    }

    public void deleteCourse(){
        System.out.println("Which course id u want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        try {
            courseService.deleteCourse(id);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateCourse() {
        System.out.print("Enter the course ID: ");
        int courseId = scanner.nextInt();
        Course course = null;
        try {
            course = courseService.findCourseById(courseId);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

        if (course == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Current student details:");
        findCourseById(courseId);

        System.out.print("Enter updated course name (leave blank to keep current): ");
        String courseName = scanner.nextLine();
        if (!courseName.isEmpty()) {
            course.setCourseName(courseName);
        }

        System.out.print("Enter course description (leave blank to keep current): ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            course.setCourseDescription(description);
        }

        System.out.print("Enter course_code (leave blank to keep current): ");
        String courseCode = scanner.nextLine();
        if (!courseCode.isEmpty()) {
            course.setCourseCode(courseCode);
        }

        try {
            courseService.updateCourse(course);
            System.out.println("Student updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating instr: " + e.getMessage());
        }
    }

    public void findAllCourses() throws ServiceException {
        List<Course> courses = courseService.findAllCourses();

        studentConsoleTable();
        for (Course course : courses) {
            System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n",
                    course.getCourseId(),
                    course.getCourseName(),
                    course.getCourseDescription(),
                    course.getCourseCode()
            );
        }
    }
    public void findMyCourses(int id) throws ServiceException {
        List<Course> courses = courseService.findMyCourses(id);

        studentConsoleTable();
        for (Course course : courses) {
            System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n",
                    course.getCourseId(),
                    course.getCourseName(),
                    course.getCourseDescription(),
                    course.getCourseCode()
            );
        }
    }

    public void findCourseById() {
        System.out.println("What user by his id u want to found");
        int id = Integer.parseInt(scanner.nextLine());

        try {
            Course course = courseService.findCourseById(id);
            studentConsoleTable();
            System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n",
                    course.getCourseId(),
                    course.getCourseName(),
                    course.getCourseDescription(),
                    course.getCourseCode()
            );
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }

    public void findCourseById(int id) {
        try {
            Course course = courseService.findCourseById(id);
            studentConsoleTable();
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    course.getCourseId(),
                    course.getCourseName(),
                    course.getCourseDescription(),
                    course.getCourseCode());
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }


    private void studentConsoleTable(){
        String[] headers = { "ID", "Course Name", "Course description", "Course Code"};
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
