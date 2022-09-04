<%-- 
    Document   : profile
    Created on : Jun 17, 2022, 8:46:09 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="update" method="get">
            ID: <input type="text" name="id" value="${sessionScope.user.getId()}" readonly><br>
            UserName: <input type="text" name="user" value="${sessionScope.user.getName()}"><br>
            Pass: <input type="password" name="pass" value="${sessionScope.user.getPass()}"><br>
            Nick Name: <input type="text" name="nickname" value="${sessionScope.user.getNickname()}"><br>
            <input type="submit" value="Save">

        </form>
            <a href="favfilm?id=${sessionScope.user.getId()}">favfilm</a>
    </body>
</html>
