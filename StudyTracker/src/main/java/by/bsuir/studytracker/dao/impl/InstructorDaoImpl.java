package by.bsuir.studytracker.dao.impl;

import by.bsuir.studytracker.dao.InstructorDao;
import by.bsuir.studytracker.dao.connection.PostgresConnectionPool;
import by.bsuir.studytracker.domain.Instructor;
import by.bsuir.studytracker.domain.Student;
import by.bsuir.studytracker.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorDaoImpl implements InstructorDao {
    private final PostgresConnectionPool connectionPool;
    public InstructorDaoImpl(PostgresConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    private static final String SELECT_ALL_INSTRUCTORS_SQL="SELECT * FROM instructor";
    private static final String SELECT_INSTRUCTOR_BY_ID_SQL="SELECT * FROM instructor WHERE instructor_id = ?";
    private static final String ADD_INSTRUCTOR_SQL="INSERT INTO instructor(first_name, last_name, email,phone_number,password_hash) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_INSTRUCTOR_SQL="UPDATE instructor SET first_name = ?, last_name = ?, email = ?, phone_number = ? WHERE instructor_id = ?";
    private static final String DELETE_INSTRUCTOR_SQL="DELETE FROM instructor WHERE instructor_id = ?";


    @Override
    public Instructor findInstructorById(int id) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_INSTRUCTOR_BY_ID_SQL)) {
            statement.setInt(1,id);

            try(ResultSet rs = statement.executeQuery()){
                Instructor instructor = new Instructor();
                while(rs.next()){
                    instructor = mapRow(rs);
                }
                return instructor;
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding student by id in database", e);
        }
    }

    @Override
    public List<Instructor> findAllInstructors() throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_INSTRUCTORS_SQL)) {
            try(ResultSet rs = statement.executeQuery()){
                List<Instructor> instructors = new ArrayList<>();
                while(rs.next()){
                    Instructor instructor = mapRow(rs);
                    instructors.add(instructor);

                }
                return instructors;
            }
        } catch (SQLException e) {
            throw new DaoException("Error while adding instructor to database", e);
        }
    }

    @Override
    public void addInstructor(Instructor instructor) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_INSTRUCTOR_SQL)) {
            setInstructorInfo(instructor, statement);
            statement.setString(5, instructor.getPassword_hash());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error while adding student to database", e);
        }
    }

    @Override
    public void updateInstructor(Instructor instructor) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_INSTRUCTOR_SQL)) {
            setInstructorInfo(instructor, statement);
            statement.setInt(5, instructor.getInstructorId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error while adding student to database", e);
        }
    }

    private void setInstructorInfo(Instructor instructor, PreparedStatement statement) throws SQLException {
        statement.setString(1, instructor.getFirstName());
        statement.setString(2, instructor.getLastName());
        statement.setString(3, instructor.getEmail());
        statement.setString(4, instructor.getPhoneNumber());
    }

    @Override
    public void deleteInstructor(int id) throws DaoException {
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_INSTRUCTOR_SQL)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new DaoException("Error while deleting student from database", e);
        }
    }

    private Instructor mapRow(ResultSet rs) throws SQLException{
        return new Instructor(
                rs.getInt("instructor_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("phone_number"),
                rs.getString("password_hash"));
    }

}
