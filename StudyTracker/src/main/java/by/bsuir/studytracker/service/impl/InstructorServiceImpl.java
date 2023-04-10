package by.bsuir.studytracker.service.impl;

import by.bsuir.studytracker.dao.InstructorDao;
import by.bsuir.studytracker.dao.StudentDao;
import by.bsuir.studytracker.domain.Instructor;
import by.bsuir.studytracker.exception.DaoException;
import by.bsuir.studytracker.exception.ServiceException;
import by.bsuir.studytracker.service.InstructorService;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {

    private final InstructorDao instructorDao;

    public InstructorServiceImpl(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }
    @Override
    public void addInstructor(Instructor instructor) throws ServiceException {
        try {
            instructorDao.addInstructor(instructor);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateInstructor(Instructor instructor) throws ServiceException {
        try {
            instructorDao.updateInstructor(instructor);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteInstructor(int id) throws ServiceException {
        try {
            instructorDao.deleteInstructor(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Instructor> findAddInstructors() throws ServiceException {

        try {
            return instructorDao.findAllInstructors();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Instructor findInstructorById(int id) throws ServiceException {
        try {
            return instructorDao.findInstructorById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
