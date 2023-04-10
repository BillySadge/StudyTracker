package by.bsuir.studytracker.service;

import by.bsuir.studytracker.domain.Course;
import by.bsuir.studytracker.domain.Instructor;
import by.bsuir.studytracker.exception.ServiceException;

import java.util.List;

public interface CourseService {
    void addCourse(Course course) throws ServiceException;
    void updateCourse(Course course) throws ServiceException;
    void deleteCourse(int id) throws ServiceException;
    List<Course> findAllCourses() throws ServiceException;
    List<Course> findMyCourses(int id) throws ServiceException;
    Course findCourseById(int id) throws ServiceException;
}
