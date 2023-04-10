package by.bsuir.studytracker.service;

import by.bsuir.studytracker.domain.Course;
import by.bsuir.studytracker.domain.Enrollment;
import by.bsuir.studytracker.exception.DaoException;
import by.bsuir.studytracker.exception.ServiceException;

import java.util.List;

public interface EnrollmentService {
    void addEnrollment(Enrollment enrollment) throws ServiceException;
    void deleteEnrollment(int id) throws ServiceException;
    List<Enrollment> findAllEnrollments() throws ServiceException;
    Enrollment findEnrollmentById(int id) throws ServiceException;

}
