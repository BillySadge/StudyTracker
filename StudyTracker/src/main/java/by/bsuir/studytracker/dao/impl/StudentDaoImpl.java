package by.bsuir.studytracker.dao.impl;

import by.bsuir.studytracker.dao.StudentDao;
import by.bsuir.studytracker.domain.Student;
import by.bsuir.studytracker.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {


    private static final String SELECT_ALL_STUDENTS_SQL="SELECT * FROM student";
//    private static final String SELECT_ALL_STUDENTS_SQL="SELECT student_id, last_name, first_name, id_number, complete_address, phone_number, email_address, password_hash, account_status FROM students";
    private static final String SELECT_STUDENT_BY_ID_SQL="SELECT student_id, last_name, first_name, id_number, complete_address, phone_number, email_address, password_hash, account_status FROM students WHERE student_id = ?";
    private static final String ADD_STUDENT_SQL="INSERT INTO student(first_name, last_name, email,phone_number,card_id_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//    private static final String ADD_STUDENT_SQL="INSERT INTO students(last_name, first_name, id_number,complete_address,phone_number," +
//            "email_address,password_hash,account_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_STUDENT_SQL="UPDATE students SET last_name = ?, first_name = ?, id_number = ?, complete_address = ?," +
            "phone_number = ?, email_address = ?, password_hash = ?, account_status = ? WHERE student_id = ?";
    private static final String DELETE_STUDENT_SQL="DELETE FROM students WHERE student_id = ?";
    private final Connection connection;

    public StudentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Student findStudentById(int id) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_ID_SQL)) {
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
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STUDENTS_SQL)) {
            try(ResultSet rs = statement.executeQuery()){
                List<Student> students = new ArrayList<>();
                while(rs.next()){
                    Student student = mapRow(rs);
                    students.add(student);

                }
                return students;
            }
//            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error while adding student to database", e);
        }
    }

    @Override
    public void addStudent(Student student) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(ADD_STUDENT_SQL)) {
            statement.setString(1, student.getLastName());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getIdNumber());
            statement.setString(4, student.getCompleteAddress());
            statement.setString(5, student.getPhoneNumber());
            statement.setString(6, student.getEmailAddress());
            statement.setString(7, student.getPasswordHash());
            statement.setInt(8, student.getAccount_status());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error while adding student to database", e);
        }
    }

    @Override
    public void deleteStudent(int studentId) throws DaoException {
        try(PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL)){
            statement.setInt(1, studentId);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new DaoException("Error while deleting student from database", e);
        }
    }

    private Student mapRow(ResultSet rs) throws SQLException{
        return new Student(
                rs.getInt("student_id"),
                rs.getString("last_name"),
                rs.getString("first_name"),
                rs.getString("id_number"),
                rs.getString("complete_address"),
                rs.getString("phone_number"),
                rs.getString("email_address"),
                rs.getString("password_hash"),
                rs.getInt("account_status"));
    }


}