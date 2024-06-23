package module.login.demo;

import java.sql.Connection;
import java.sql.DriverManager;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostgresConnection {
    private String jdbcUrl;
    private String userName;
    private String password;

    public PostgresConnection(String jdbcUrl, String userName, String password) {
        this.jdbcUrl = jdbcUrl;
        this.userName = userName;
        this.password = password;
    }

    public Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(this.jdbcUrl, this.userName, this.password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}