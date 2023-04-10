package by.bsuir.studytracker.service;

import by.bsuir.studytracker.domain.Instructor;
import by.bsuir.studytracker.domain.Student;
import by.bsuir.studytracker.exception.ServiceException;

import java.util.List;

public interface InstructorService {
    void addInstructor(Instructor instructor) throws ServiceException;
    void updateInstructor(Instructor instructor) throws ServiceException;
    void deleteInstructor(int id) throws ServiceException;
    List<Instructor> findAddInstructors() throws ServiceException;
    Instructor findInstructorById(int id) throws ServiceException;
}
