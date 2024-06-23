package module.login.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountChecking {
    String account;
    String password;
    String sql = "SELECT * FROM users WHERE account = ? AND password = ?";

    public AccountChecking(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public boolean check(Connection connection) throws Exception {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, this.account);
        statement.setString(2, this.password);
        ResultSet result = statement.executeQuery();
        connection.close();
        
        if (result.next()) {
            return true;
        } else {
            return false;
        }
    }
}
