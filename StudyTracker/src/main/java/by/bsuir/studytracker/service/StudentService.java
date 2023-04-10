package by.bsuir.studytracker.service;

import by.bsuir.studytracker.domain.Student;
import by.bsuir.studytracker.exception.ServiceException;

import java.util.List;

public interface StudentService {
    void addStudent(Student student) throws ServiceException;
    void updateStudent(Student student) throws ServiceException;
    void deleteStudent(int id) throws ServiceException;
    List<Student> findAllStudents() throws ServiceException;
    Student findStudentById(int id) throws ServiceException;
}
