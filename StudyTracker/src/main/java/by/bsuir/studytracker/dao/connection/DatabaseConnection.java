package by.bsuir.studytracker.dao.connection;

import org.postgresql.jdbc2.optional.PoolingDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/" + System.getenv("DB_NAME");
    private static final String DB_USERNAME = System.getenv("DB_USER");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    private static final DataSource dataSource;

    static {
        PoolingDataSource ds = new PoolingDataSource();
        ds.setUrl(DB_URL);
        ds.setUser(DB_USERNAME);
        ds.setPassword(DB_PASSWORD);
        dataSource = ds;
    }


    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


}
