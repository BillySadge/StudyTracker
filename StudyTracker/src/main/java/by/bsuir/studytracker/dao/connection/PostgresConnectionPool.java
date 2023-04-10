package by.bsuir.studytracker.dao.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgresConnectionPool {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/" + System.getenv("DB_NAME");
    private static final String DB_USERNAME = System.getenv("DB_USER");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");
    private final List<Connection> pool;


    public PostgresConnectionPool(int initialPoolSize) throws SQLException {
        this.pool = new ArrayList<>(initialPoolSize);

        for (int i = 0; i < initialPoolSize; i++) {
            pool.add(createConnection());
        }
    }

    public synchronized Connection getConnection() throws SQLException {
        if (pool.isEmpty()) {
            pool.add(createConnection());
        }
        return pool.remove(0);
    }

    public synchronized void releaseConnection(Connection connection) {
        pool.add(connection);
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    public void closeAllConnections() throws SQLException {
        for (Connection connection : pool) {
            connection.close();
        }
        pool.clear();
    }




}



