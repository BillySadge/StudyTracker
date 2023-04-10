package by.bsuir.studytracker.dao.impl;

import by.bsuir.studytracker.dao.CourseDao;
import by.bsuir.studytracker.dao.connection.PostgresConnectionPool;
import by.bsuir.studytracker.domain.Course;
import by.bsuir.studytracker.domain.Instructor;
import by.bsuir.studytracker.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    private final PostgresConnectionPool connectionPool;
    public CourseDaoImpl(PostgresConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    private static final String SELECT_ALL_COURSES="SELECT * FROM course";

    private static final String SELECT_MY_COURSES="SELECT c.course_id,c.course_name,c.course_description,course_code\n" +
            "FROM enrollment e\n" +
            "         JOIN course c ON e.course_id = c.course_id\n" +
            "         JOIN student s ON e.student_id = s.student_id\n" +
            "WHERE s.student_id = ?";
    private static final String SELECT_COURSE_BY_ID="SELECT * FROM course WHERE course_id = ?";
    private static final String ADD_COURSE_SQL="INSERT INTO course(course_name, course_description, course_code) VALUES (?, ?, ?)";
    private static final String UPDATE_COURSE_SQL="UPDATE course SET course_name = ?, course_description = ?, course_code = ? WHERE course_id = ?";
    private static final String DELETE_COURSE_SQL="DELETE FROM course WHERE course_id = ?";
    @Override
    public Course findCourseById(int id) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_COURSE_BY_ID)) {
            statement.setInt(1,id);

            try(ResultSet rs = statement.executeQuery()){
                Course course = new Course();
                while(rs.next()){
                    course = mapRow(rs);
                }
                return course;
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding student by id in database", e);
        }
    }

    @Override
    public List<Course> findAllCourses() throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_COURSES)) {
            try(ResultSet rs = statement.executeQuery()){
                List<Course> courses = new ArrayList<>();
                while(rs.next()){
                    Course course = mapRow(rs);
                    courses.add(course);

                }
                return courses;
            }
        } catch (SQLException e) {
            throw new DaoException("Error while adding courses to database", e);
        }
    }
    @Override
    public List<Course> findMyCourses(int studentId) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_MY_COURSES)) {
            statement.setInt(1, studentId);
            try(ResultSet rs = statement.executeQuery()){
                List<Course> courses = new ArrayList<>();
                while(rs.next()){
                    Course course = mapRow(rs);
                    courses.add(course);

                }
                return courses;
            }
        } catch (SQLException e) {
            throw new DaoException("Error while adding courses to database", e);
        }
    }

    @Override
    public void addCourse(Course course) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_COURSE_SQL)) {
            setCourseInfo(course, statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error while adding student to database", e);
        }
    }

    @Override
    public void updateCourse(Course course) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_COURSE_SQL)) {
            setCourseInfo(course, statement);
            statement.setInt(4, course.getCourseId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error while adding student to database", e);
        }
    }

    @Override
    public void deleteCourse(int courseId) throws DaoException {
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_COURSE_SQL)){
            statement.setInt(1, courseId);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new DaoException("Error while deleting student from database", e);
        }
    }

    private Course mapRow(ResultSet rs) throws SQLException{
        return new Course(
                rs.getInt("course_id"),
                rs.getString("course_name"),
                rs.getString("course_description"),
                rs.getString("course_code"));
    }

    private void setCourseInfo(Course course, PreparedStatement statement) throws SQLException {
        statement.setString(1, course.getCourseName());
        statement.setString(2, course.getCourseDescription());
        statement.setString(3, course.getCourseCode());
    }
}
