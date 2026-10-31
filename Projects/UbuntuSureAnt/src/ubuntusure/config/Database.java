package ubuntusure.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Central JDBC connection factory. Configure with environment variables or edit defaults. */
public final class Database {
    private Database() {}
    private static String env(String key, String fallback) { String value = System.getenv(key); return value == null || value.isBlank() ? fallback : value; }
    public static Connection getConnection() throws SQLException {
        String url = env("UBUNTUSURE_DB_URL", "jdbc:mysql://localhost:3306/ubuntusure?useSSL=false&serverTimezone=UTC");
        String user = env("UBUNTUSURE_DB_USER", "root");
        String password = env("UBUNTUSURE_DB_PASSWORD", "");
        return DriverManager.getConnection(url, user, password);
    }
}
