<%-- 
    Document   : home
    Created on : May 31, 2022, 3:16:46 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script type="text/javascript" scr="https://www.gstatic.com/charts/loader.js"></script>


        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,900;1,900&display=swap" rel="stylesheet">
        <style>
            .navbar{
                width: 100%;
                height: 50px;
                background-color: gray;
            }

            body{
                font-family: 'Roboto', sans-serif;
                background-color: #151515;


            }
            .max{
                color: green;
            }
            .min{
                color:blue;
            }
            .sum{
                color: yellow;
            }
            .avg{
                color: purple;
            }
            .navbar-container{
                display: flex;
                align-items: center;
                width: 100%;
            }
            .logo-container{
                flex: 1;
            }
            .menu-container{
                flex: 4;
            }
            .a{
                list-style: none;
                margin-left:  20px;
                padding: 0;
                display: flex;
            }
            .a li{
                position: relative;
            }
            .a li a{
                display: block;
                margin-right:  30px;
            }
            .sub_a{
                position: absolute;
                list-style: none;
                margin: 0;
                padding: 0;
                display: none;
                background-color: gray;
            }
            .a li:hover .sub_a {
                display: block;
            }
            .sub_a a{

            }
            .search-container{
                flex:2;
            }
            .profile-container{
                flex: 3;
            }
            a{
                margin: 5%;
                color: white;
            }
            .logo{
                height: 20%;
                width: 20%;
            }
            .search{
                height: 25px;
                align-items: center;
            }
            .container{

                height: 100vh;
            }
            .featured-content{
                color: white;
                margin: 20px;
            }
            .featured-content{
                display: block;
            }
            .nhieu-content{
                color: white;
                margin: 20px;
            }
        </style>
        <script type="text/javascript">
            function setCheck(obj){
            var fries = [
            <c:forEach items="${requestScope.listT}" var="i">
            document.getElementById('${i}').checked;
            </c:forEach>, document.getElementById('c0').checked; ]

                    if (fries[length - 1].checked == true){
            for (var i = 0; i < fries.length-1; i++) {
            fries[i].checked = false;
            }
            } else{
            for (var i = 0; i < fries.length-1; i++) {
            if (fries[i].checked = true; ){
            fries.[0].checked = false;
            break;
            }
            }
            }}
        </script>
    </head>
    <body>
        <div class="navbar">
            <div class="logo-container">
                <a href="homeSev"><img class="logo" src="img/icon.png" alt="alt"/></a>
            </div>
            <div class="menu-container">
                <ul class="a">
                    <li><a href="/html/">Thểloại</a> 
                        <ul class="sub_a">
                            <c:forEach items="${requestScope.listT}" var = "i" begin = "0" end = "5">

                                <li><a href="hanhdong?type=${i.id}">${i.name}</a> </li>

                            </c:forEach>

                        </ul> </li>
                    <li> <a href="/css/">Quốcgia</a> 
                        <ul class="sub_a">
                            <c:forEach items="${requestScope.listC}" var = "a" begin = "0" end = "5">

                                <li><a href="country1?type=${a.id}">${a.name}</a> </li>

                            </c:forEach>
                        </ul> </li>
                    </li>

                </ul> 
            </div>
            <div class="search-container">
                <form action="search" method="get">
                    <input class="search" type="text" name="search">
                    <input type="submit" value=".">
                </form>
            </div>
            <div class="profile-container">

                <c:set var="cookie" value="${pageContext.request.cookies}"/>

                <c:if test = "${sessionScope.user != null}">
                    Hi! <a href="profile.jsp">${sessionScope.user.getName()}</a>
                    <a href="logout">Đăng xuất</a>
                </c:if>
                <c:if test = "${sessionScope.user.role ==1}">

                    <a href="admin">admin</a>
                </c:if>
                <c:if test = "${sessionScope.user == null}">
                    <a href="Login.jsp">login</a>
                </c:if>
            </div>


        </div>
        <div class="container">
            <div class="content-container">
                <div class="featured-content">
                    <p>moi cap nhat</p> 
                    <p><a href="all">all</a></p>
                    <div class="row">

                        <c:forEach items="${requestScope.f1}" var = "i" begin = "0" end = "5">
                            <div class="d-flex flex-column col-12 col-md-4">
                                <a href="video?id=${i.id}"><img style="height:100%; width: 100%" src="${i.img }" ></a>
                                    ${i.name}
                            </div>        
                        </c:forEach>

                    </div>

                </div>
                <div class="nhieu-content">
                    <p>Xem nhiều nhất</p>
                    <div class="row">

                        <c:forEach items="${requestScope.f}" var = "i" begin = "0" end = "5">
                            <div class="d-flex flex-column col-4">
                                <a href="video?id=${i.id}"><img style="height:100%; width: 100%" src="${i.img }" ></a>
                                    ${i.name}
                            </div>        
                        </c:forEach>

                    </div>

                </div>
                <div class="nhieu-content">
                    <p>phim hanh dong nhieu view</p>
                    <div class="row">

                        <c:forEach items="${requestScope.f2}" var = "i" begin="0" end="5">
                            <div class="d-flex flex-column col-4">
                                <a href="video?id=${i.id}"><img style="height:100%; width: 100%" src="${i.img }" ></a>
                                    ${i.name}
                            </div>        
                        </c:forEach>

                    </div>

                </div>
                <div class="nhieu-content">
                    <p>phim hai huoc nhieu view</p>
                    <div class="row">

                        <c:forEach items="${requestScope.f3}" var = "i" begin="0" end="5">
                            <div class="d-flex flex-column col-4">
                                <a href="video?id=${i.id}"><img style="height:100%; width: 100%" src="${i.img }" ></a>
                                    ${i.name}
                            </div>        
                        </c:forEach>

                    </div>

                </div>
                <div class="nhieu-content">
                   <form id="f1" action="home1">
                        <input type="checkbox" id="c0" name="cidd" value="all" onclick="setCheck(this)">All<br>
                        <c:forEach items="${requestScope.listT}" var="i">
                            <input type="checkbox" id="${i.id}" name="cidd" value="${i.name}" onclick="setCheck(this)">${i.name} <br>
                        </c:forEach>

                    </form>
                </div>
                <div class="nhieu-content">
                    <p>sap xep theo ten</p>
                    <div class="row">

                        <c:forEach items="${requestScope.f4}" var = "i" begin="0" end="5">
                            <div class="d-flex flex-column col-4">
                                <a href="video?id=${i.id}"><img style="height:100%; width: 100%" src="${i.img }" ></a>
                                    ${i.name}
                            </div>        
                        </c:forEach>

                    </div>

                </div>
                       <div class="nhieu-content">
                    <p>sap xep theo ten</p>
                    <div class="row">

                        <c:forEach items="${requestScope.f5}" var = "i" begin="0" end="5">
                            <div class="d-flex flex-column col-4">
                                <a href="video?id=${i.id}"><img style="height:100%; width: 100%" src="${i.img }" ></a>
                                    ${i.name}
                            </div>        
                        </c:forEach>

                    </div>

                </div>
                <div class="thongke-content">
                    <div class="max"> <p>phim co so luot xem lon nhat: ${requestScope.fmax.name}</p>
                        <p>luot xem:${requestScope.fmax.view}</p>
                    </div>
                    <div class="min"><p>phim co so luot xem nho nhat: ${requestScope.fmin.name}</p>
                        <p>luot xem:${requestScope.fmin.view}</p></div>
                    <div class="sum">
                        <p>tong luot xem cac phim:${requestScope.sum}</p>
                    </div>
                    <div class="avg">
                        <p> luot xem trung binh:${requestScope.avg}</p>
                    </div>
                    <div class="count">
                        <p> tong phim:${requestScope.count}</p>
                    </div>

                </div>

            </div>
        </div>



    </body>
</html>
