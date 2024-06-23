<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<body>
    <%
        response.setHeader("Cache-Control","no-store, no-cache, must-revalidate"); //HTTP 1.1
        response.setHeader("Pragma","no-cache"); //HTTP 1.0
        response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
    %>
    <form action="login" method="post">
        Username: <input type="text" name="username"><br><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Log In">
    </form>
</body>
</html>