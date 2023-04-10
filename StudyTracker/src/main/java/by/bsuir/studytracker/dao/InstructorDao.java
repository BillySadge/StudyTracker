package by.bsuir.studytracker.dao;

import by.bsuir.studytracker.domain.Instructor;
import by.bsuir.studytracker.domain.Student;
import by.bsuir.studytracker.exception.DaoException;

import java.util.List;

public interface InstructorDao {
    Instructor findInstructorById(int id) throws DaoException;
    List<Instructor> findAllInstructors() throws DaoException;
    void addInstructor(Instructor instructor) throws DaoException;

    void updateInstructor(Instructor instructor) throws DaoException;
    void deleteInstructor(int instructorId) throws DaoException;

}
