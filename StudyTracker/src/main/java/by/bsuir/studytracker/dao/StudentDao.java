package by.bsuir.studytracker.dao;

import by.bsuir.studytracker.domain.Student;
import by.bsuir.studytracker.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    Student findStudentById(int id) throws DaoException;
    List<Student> findAllStudents() throws DaoException;
    void addStudent(Student student) throws DaoException;

    void updateStudent(Student student) throws DaoException;
    void deleteStudent(int studentId) throws DaoException;

}
