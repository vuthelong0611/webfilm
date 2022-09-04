<%-- 
    Document   : all
    Created on : Jun 22, 2022, 3:04:10 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <div class="phimle-content">
                    <p>Mới cập nhật</p>
                    <c:forEach items="${requestScope.f1}" var = "i" >
                        ${i.name}
                        <a href="video"><img src="${i.img }" ></a>
                        </c:forEach>
                </div>
    </body>
</html>
