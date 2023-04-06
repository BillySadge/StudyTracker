package by.bsuir.studytracker.dao;

import by.bsuir.studytracker.domain.Student;
import by.bsuir.studytracker.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    public Student findStudentById(int id) throws DaoException;
    public List<Student> findAllStudents() throws DaoException;
    public void addStudent(Student student) throws DaoException;
    public void deleteStudent(int studentId) throws DaoException;
//    public void update(Student student);

}
