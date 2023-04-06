package by.bsuir.studytracker.application;

import by.bsuir.studytracker.dao.connection.DatabaseConnection;
import by.bsuir.studytracker.exception.DaoException;
import org.mindrot.jbcrypt.BCrypt;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    private final Connection connection;
    private Encryptor encryptor = new Encryptor();

    public Login(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public void login(String idNumber,String password){

        String LOGIN_SQL = "SELECT account_id FROM account WHERE username = ? AND password_hash = ?";
//        String LOGIN_SQL = "SELECT student_id FROM students WHERE id_number = ? AND password_hash = ?";
        try (PreparedStatement statement = connection.prepareStatement(LOGIN_SQL)) {
            statement.setString(1,idNumber);
            statement.setString(2, encryptor.encryptString(password));
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                System.out.println("Successful login");
            } else {
                System.out.println("User not found, login failed");
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
