<%-- 
    Document   : Login
    Created on : May 30, 2022, 9:25:07 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

            body{
                background-image: url(https://static3.cbrimages.com/wordpress/wp-content/uploads/2020/07/One-Piece-Luffy-Straw-Hat-Pirates-Wanted-Posters.jpg);
                background-size: 110%;

            }
            .content{
                text-align: center;
                margin-top: 25%;

                color: white;
                border: 2px;
            }
            .a,.b,.d{
                font-family: cursive;
                font-size: 100%;
                border-color: pink;
            }
            .c{
                font-size:25%;
                size: 10px;
                ;
            }
            #user,#pass{
                font-family: cursive;
                font-size: 200%;
            }
            #dk{
                font-family: cursive;
                font-size: 200%;
                color: white;
            }
        </style>
    </head>
    <body>

        <div class="content">
            <c:set var="cookie" value="${pageContext.request.cookies}"/>
            <form action="loginSev" method="get">
                <label id="user"for="user">Username</label><br>
                <input class="a" type="text" name="user" value="${cookie.user.value}"></br>
                <label id="pass" for="pass">Password</label><br>
                <input class="b" type="password" name="pass" value="${cookie.pass.value}"></br>
                Nhớ mật khẩu <input class="c" type="checkbox"
                ${(cookie.crem !=null?'checked':'')} name="check"  value="ON"/><br>
                <input class="d" type="submit" value="Login">
            </form>
                <a id="dk" href="Resister">Đăng ký</a>
                <br>
            <a id="dk" href="doimatkhau.jsp"> doi mat khau</a>
        </div>

    </body>
</html>
