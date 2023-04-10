package by.bsuir.studytracker.dao.impl;

import by.bsuir.studytracker.dao.StudentDao;
import by.bsuir.studytracker.dao.connection.PostgresConnectionPool;
import by.bsuir.studytracker.domain.Student;
import by.bsuir.studytracker.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private final PostgresConnectionPool connectionPool;
    public StudentDaoImpl(PostgresConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    private static final String SELECT_ALL_STUDENTS_SQL="SELECT * FROM student";
    private static final String SELECT_STUDENT_BY_ID_SQL="SELECT * FROM student WHERE student_id = ?";
    private static final String ADD_STUDENT_SQL="INSERT INTO student(first_name, last_name, email,phone_number,card_id_number,password_hash) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_STUDENT_SQL="UPDATE student SET first_name = ?, last_name = ?, email = ?, phone_number = ?," +
            "card_id_number = ? WHERE student_id = ?";
    private static final String DELETE_STUDENT_SQL="DELETE FROM student WHERE student_id = ?";


    @Override
    public Student findStudentById(int id) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_ID_SQL)) {
            statement.setInt(1,id);

            try(ResultSet rs = statement.executeQuery()){
                Student student = new Student();
                while(rs.next()){
                    student = mapRow(rs);
                }
                return student;
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding student by id in database", e);
        }
    }

    @Override
    public List<Student> findAllStudents() throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STUDENTS_SQL)) {
            try(ResultSet rs = statement.executeQuery()){
                List<Student> students = new ArrayList<>();
                while(rs.next()){
                    Student student = mapRow(rs);
                    students.add(student);

                }
                return students;
            }
        } catch (SQLException e) {
            throw new DaoException("Error while adding student to database", e);
        }
    }

    @Override
    public void addStudent(Student student) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_STUDENT_SQL)) {
            setStudentInfo(student, statement);
            statement.setString(6, student.getPasswordHash());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error while adding student to database", e);
        }
    }

    @Override
    public void updateStudent(Student student) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
            setStudentInfo(student, statement);
            statement.setInt(6, student.getStudentId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error while adding student to database", e);
        }
    }

    private void setStudentInfo(Student student, PreparedStatement statement) throws SQLException {
        statement.setString(1, student.getFirstName());
        statement.setString(2, student.getLastName());
        statement.setString(3, student.getEmailAddress());
        statement.setString(4, student.getPhoneNumber());
        statement.setString(5, student.getCardIdNumber());
    }

    @Override
    public void deleteStudent(int studentId) throws DaoException {
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL)){
            statement.setInt(1, studentId);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new DaoException("Error while deleting student from database", e);
        }
    }

    private Student mapRow(ResultSet rs) throws SQLException{
        return new Student(
                rs.getInt("student_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("phone_number"),
                rs.getString("card_id_number"),
                rs.getString("password_hash"));
    }


}