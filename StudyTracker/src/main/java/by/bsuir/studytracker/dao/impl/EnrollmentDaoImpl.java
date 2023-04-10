package by.bsuir.studytracker.dao.impl;

import by.bsuir.studytracker.dao.EnrollmentDao;
import by.bsuir.studytracker.dao.connection.PostgresConnectionPool;
import by.bsuir.studytracker.domain.Course;
import by.bsuir.studytracker.domain.Enrollment;
import by.bsuir.studytracker.exception.DaoException;

import java.sql.*;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDaoImpl implements EnrollmentDao {

    private final PostgresConnectionPool connectionPool;
    public EnrollmentDaoImpl(PostgresConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    private static final String SELECT_ALL_ENROLLMENTS="SELECT * FROM enrollment";
    private static final String SELECT_ENROLLMENT_BY_ID="SELECT * FROM enrollment WHERE enrollment_id = ?";
    private static final String ADD_ENROLLMENT_SQL="INSERT INTO enrollment(student_id, course_id, enrollment_date,enrollment_status) VALUES (?, ?, ?,?)";
    private static final String UPDATE_ENROLLMENT_SQL="UPDATE enrollment SET student_id = ?, course_id = ?, enrollment_date = ?, enrollment_status WHERE enrollment_id = ?";
    private static final String DELETE_ENROLLMENT_SQL="DELETE FROM enrollment WHERE enrollment_id = ?";
    @Override
    public Enrollment findEnrollmentById(int id) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ENROLLMENT_BY_ID)) {
            statement.setInt(1,id);

            try(ResultSet rs = statement.executeQuery()){
                Enrollment enrollment = new Enrollment();
                while(rs.next()){
                    enrollment = mapRow(rs);
                }
                return enrollment;
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding student by id in database", e);
        }
    }

    @Override
    public List<Enrollment> findAllEnrollments() throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ENROLLMENTS)) {
            try(ResultSet rs = statement.executeQuery()){
                List<Enrollment> enrollments = new ArrayList<>();
                while(rs.next()){
                    Enrollment enrollment = mapRow(rs);
                    enrollments.add(enrollment);

                }
                return enrollments;
            }
        } catch (SQLException e) {
            throw new DaoException("Error while adding courses to database", e);
        }
    }

    @Override
    public void addEnrollment(Enrollment enrollment) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_ENROLLMENT_SQL)) {
            setEnrollmentInfo(enrollment, statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error while creating enrollment to database", e);
        }
    }

    @Override
    public void updateEnrollment(Enrollment enrollment) throws DaoException {

    }

    @Override
    public void deleteEnrollment(int enrollmentId) throws DaoException {
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_ENROLLMENT_SQL)){
            statement.setInt(1, enrollmentId);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new DaoException("Error while deleting student from database", e);
        }
    }

    private Enrollment mapRow(ResultSet rs) throws SQLException{
        return new Enrollment(
                rs.getInt("enrollment_id"),
                rs.getInt("student_id"),
                rs.getInt("course_id"),
                rs.getTimestamp("enrollment_date").toInstant(),
                rs.getString("enrollment_status"));
    }

    private void setEnrollmentInfo(Enrollment enrollment, PreparedStatement statement) throws SQLException {
        statement.setInt(1, enrollment.getStudentId());
        statement.setInt(2, enrollment.getCourseId());
        statement.setTimestamp(3, new Timestamp(enrollment.getEnrollmentDate().toEpochMilli()));
        statement.setString(4, enrollment.getEnrollmentStatus());
    }
}
