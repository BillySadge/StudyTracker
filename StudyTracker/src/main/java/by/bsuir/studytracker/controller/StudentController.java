package by.bsuir.studytracker.controller;

import by.bsuir.studytracker.dao.StudentDao;
import by.bsuir.studytracker.domain.Student;
import by.bsuir.studytracker.exception.ServiceException;
import by.bsuir.studytracker.view.StudentView;

import java.sql.Connection;
import java.util.List;

public class StudentController {

    private StudentView studentView;

    public StudentController(Connection connection) {
        this.studentView = new StudentView(connection);
    }

    public String[] loginStudent(){
        return studentView.loginStudent();
    }

    public void addStudent() {
        studentView.addStudent();
    }
    public void deleteStudent(){
        studentView.deleteStudent();
    }

    public void findAllStudents(){
        try {
            studentView.findAllStudents();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    public void findStudentById(){
        studentView.findStudentById();
    }


}
