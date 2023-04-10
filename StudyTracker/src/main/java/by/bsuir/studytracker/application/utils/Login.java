package by.bsuir.studytracker.application.utils;

import by.bsuir.studytracker.application.utils.Encryptor;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private final String LOGIN_SQL = "SELECT student_id FROM student WHERE card_id_number = ? AND password_hash = ?";
    private final String LOGIN_INSTR_SQL = "SELECT instructor_id FROM instructor WHERE email = ? AND password_hash = ?";

    private final Connection connection;
    private Encryptor encryptor = new Encryptor();

    public Login(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public int[] login(String idNumber,String password){
        if ("admin".equals(idNumber) && "admin".equals(password)) {
            int[] result = {0, 0};
            return result;
        } else if (isNumeric(idNumber)) {
            try (PreparedStatement statement = connection.prepareStatement(LOGIN_SQL)) {
                statement.setString(1,idNumber);
                statement.setString(2, encryptor.encryptString(password));
                ResultSet rs = statement.executeQuery();


                if (rs.next()) {
                    System.out.println("Successful login");
                    int studentId = Integer.parseInt((rs.getString("student_id")));
                    int[] result = {studentId, 1};
//                    System.out.println(studentId);
                    return result;

                } else {
                    System.out.println("User not found, login failed");
                    int[] result = {0, -1};
                    return result;
                }
            } catch (SQLException | NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        } else if (!isNumeric(idNumber)){
            try (PreparedStatement statement = connection.prepareStatement(LOGIN_INSTR_SQL)) {
                statement.setString(1,idNumber);
                statement.setString(2, encryptor.encryptString(password));
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    int instructorId = Integer.parseInt((rs.getString("instructor_id")));

                    int[] result = {instructorId, 2};
                    return result;

                } else {
                    int[] result = {0, -1};
                    return result;
                }
            } catch (SQLException | NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        } else{
            System.out.println("User not found, login failed, try again");
            int[] result = {0, -1};
            return result;
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
