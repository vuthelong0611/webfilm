<%-- 
    Document   : updateCT
    Created on : Jul 19, 2022, 1:44:56 PM
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
       <form action="updateT1" method="get">
            ID: <input type="text" name="id" value="${requestScope.f.id}" readonly="" ><br>
            Name: <input type="text" name="name" value="${requestScope.f.name}" ><br>
          
            <input type="submit" value="Save">

        </form>
    </body>
</html>
