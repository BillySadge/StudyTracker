package by.bsuir.studytracker.service.impl;

import by.bsuir.studytracker.dao.StudentDao;
import by.bsuir.studytracker.dao.impl.StudentDaoImpl;
import by.bsuir.studytracker.domain.Student;
import by.bsuir.studytracker.exception.DaoException;
import by.bsuir.studytracker.exception.ServiceException;
import by.bsuir.studytracker.service.StudentService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;
    public StudentServiceImpl(Connection connection) {
        this.studentDao = new StudentDaoImpl(connection);
    }
    @Override
    public void addStudent(Student student) throws ServiceException {
        try {
            studentDao.addStudent(student);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
    @Override
    public List<Student> findAllStudents() throws ServiceException{
        try {
            return studentDao.findAllStudents();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }


    @Override
    public void deleteStudent(int id) throws ServiceException {
        try {
            studentDao.deleteStudent(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }


    @Override
    public Student findStudentById(int id) throws ServiceException {
        try {
            return studentDao.findStudentById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
