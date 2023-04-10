package by.bsuir.studytracker.dao;

import by.bsuir.studytracker.domain.Course;
import by.bsuir.studytracker.domain.Instructor;
import by.bsuir.studytracker.exception.DaoException;

import java.util.List;

public interface CourseDao {

    Course findCourseById(int id) throws DaoException;
    List<Course> findAllCourses() throws DaoException;
    void addCourse(Course course) throws DaoException;

    List<Course> findMyCourses(int studentId) throws DaoException;

    void updateCourse(Course course) throws DaoException;
    void deleteCourse(int courseId) throws DaoException;
}
