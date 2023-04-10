package by.bsuir.studytracker.controller;

import by.bsuir.studytracker.exception.ServiceException;
import by.bsuir.studytracker.view.CourseView;
import by.bsuir.studytracker.view.EnrollmentView;
import by.bsuir.studytracker.view.InstructorView;
import by.bsuir.studytracker.view.StudentView;

public class StudentController {

    private StudentView studentView;
    private InstructorView instructorView;
    private CourseView courseView;

    private EnrollmentView enrollmentView;

    public StudentController(){
        studentView = new StudentView();
        instructorView = new InstructorView();
        courseView = new CourseView();
        enrollmentView = new EnrollmentView();
    }

    public void addInstructor() {instructorView.addInstructor();}

    public void addStudent() {
        studentView.addStudent();
    }
    public void deleteStudent(){
        studentView.deleteStudent();
    }
    public void deleteInstructor(){
        instructorView.deleteInstructor();
    }

    public void findAllStudents(){
        try {
            studentView.findAllStudents();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
    public void findAllInstructors(){
        try {
            instructorView.findAllInstructors();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    public void findStudentById(){
        studentView.findStudentById();
    }
    public void findInstructorById(){
        instructorView.findInstructorById();
    }



    public void updateInstructor() {instructorView.updateInstructor();}
    public void updateStudent() {studentView.updateStudent();}


    public void addCourse(){ courseView.addCourse();}
    public void findAllCourses(){
        try {
            courseView.findAllCourses();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
    public void findMyCourses(int id){
        try {
            courseView.findMyCourses(id);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateCourse(){ courseView.updateCourse();}
    public void findCourseById(){ courseView.findCourseById();}
    public void deleteCourse(){ courseView.deleteCourse();}

    public void addEnrollment(int userId){ enrollmentView.addEnrollment(userId);}
    public void findAllEnrollments(){
        try {
            enrollmentView.findAllEnrollments();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteEnrollment(int id){ enrollmentView.deleteEnrollment();}
    public void findEnrollmentById(){ enrollmentView.findEnrollmentById();}
}
