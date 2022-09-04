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
        <form action="update2" method="get">
            ID: <input type="text" name="id" value="${requestScope.f.id}" readonly="" ><br>
            Name: <input type="text" name="name" value="${requestScope.f.name}" ><br>
            img: <input type="text" name="img" value="${requestScope.f.img}"><br>
            video <input type="text" name="video" value="${requestScope.f.video}"><br>
            view <input type="text" name="view" value="${requestScope.f.view}"><br>
            <input type="submit" value="Save">

        </form>

    </body>
</html>
