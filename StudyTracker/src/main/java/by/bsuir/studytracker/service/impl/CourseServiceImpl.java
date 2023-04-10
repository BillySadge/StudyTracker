package by.bsuir.studytracker.service.impl;

import by.bsuir.studytracker.dao.CourseDao;
import by.bsuir.studytracker.domain.Course;
import by.bsuir.studytracker.exception.DaoException;
import by.bsuir.studytracker.exception.ServiceException;
import by.bsuir.studytracker.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private final CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void addCourse(Course course) throws ServiceException {
        try {
            courseDao.addCourse(course);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateCourse(Course course) throws ServiceException {
        try {
            courseDao.updateCourse(course);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteCourse(int id) throws ServiceException {
        try {
            courseDao.deleteCourse(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Course> findAllCourses() throws ServiceException {
        try {
            return courseDao.findAllCourses();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
    @Override
    public List<Course> findMyCourses(int id) throws ServiceException {
        try {
            return courseDao.findMyCourses(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Course findCourseById(int id) throws ServiceException {
        try {
            return courseDao.findCourseById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }    }
}
