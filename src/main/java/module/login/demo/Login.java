package module.login.demo;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
// import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// @WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // Extract username and password param from the request of client
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        // Extract database information from the web.xml
        ServletConfig cfg = getServletConfig();
        String jdbcUrl = cfg.getInitParameter("jdbcUrl");
        String dbUserName = cfg.getInitParameter("userName");
        String dbPassword = cfg.getInitParameter("password");

        // Create a Postgres connection
        PostgresConnection postgres = new PostgresConnection(jdbcUrl, dbUserName, dbPassword);
        Connection connection  = postgres.getConnection();

        // Account Checking
        AccountChecking accountChecking = new AccountChecking(username, password);
        boolean result = false;
        try {
            result = accountChecking.check(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result == true) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);

            res.sendRedirect("welcome.jsp");
        }
        else {
            res.sendRedirect("login.jsp");
        }
    }
}
