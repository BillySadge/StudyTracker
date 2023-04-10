package by.bsuir.studytracker.dao;

import by.bsuir.studytracker.domain.Course;
import by.bsuir.studytracker.domain.Enrollment;
import by.bsuir.studytracker.exception.DaoException;

import java.util.List;

public interface EnrollmentDao {
    Enrollment findEnrollmentById(int id) throws DaoException;
    List<Enrollment> findAllEnrollments() throws DaoException;
    void addEnrollment(Enrollment enrollment) throws DaoException;

    void updateEnrollment(Enrollment enrollment) throws DaoException;
    void deleteEnrollment(int enrollmentId) throws DaoException;
}
