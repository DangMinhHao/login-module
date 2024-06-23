<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<body>
    <%
        response.setHeader("Cache-Control","no-store, no-cache, must-revalidate"); //HTTP 1.1
        response.setHeader("Pragma","no-cache"); //HTTP 1.0
        response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

        if(session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
        }
    %>
    Welcome ${username}
    <form action="logout" method="post">
        <input type="submit" value="Log Out">
    </form>
</body>
</html>