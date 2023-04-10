package by.bsuir.studytracker.service.impl;

import by.bsuir.studytracker.dao.CourseDao;
import by.bsuir.studytracker.dao.EnrollmentDao;
import by.bsuir.studytracker.domain.Course;
import by.bsuir.studytracker.domain.Enrollment;
import by.bsuir.studytracker.exception.DaoException;
import by.bsuir.studytracker.exception.ServiceException;
import by.bsuir.studytracker.service.EnrollmentService;

import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentDao enrollmentDao;

    public EnrollmentServiceImpl(EnrollmentDao enrollmentDao) {
        this.enrollmentDao = enrollmentDao;
    }


    @Override
    public void addEnrollment(Enrollment enrollment) throws ServiceException {
        try {
            enrollmentDao.addEnrollment(enrollment);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteEnrollment(int id) throws ServiceException {
        try {
            enrollmentDao.deleteEnrollment(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Enrollment> findAllEnrollments() throws ServiceException {
        try {
            return enrollmentDao.findAllEnrollments();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Enrollment findEnrollmentById(int id) throws ServiceException {
        try {
            return enrollmentDao.findEnrollmentById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }    }
    }

