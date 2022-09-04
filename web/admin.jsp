
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            img{
                size:10px;
            }
        </style>
    </head>
    <body>
        <div class="logo-container">
            <a href="homeSev"><img class="logo" style="height: 10px;width: 10px" src="img/icon.png" alt="alt"/></a>
        </div>
        <a href="add.jsp"> aadd</a>
        <div>
            <center>
                <table border="1px">
                    <tr>
                        <td>name</td>
                        <td>img</td>
                        <td>video</td>
                        <td>type</td>
                        <td>country</td>
                    </tr>
                    <c:forEach items="${requestScope.f1}" var = "i">
                        <tr>
                            <td>${i.name}</td>
                            <td>${i.img}</td>
                            <td>${i.video}</td>


                            <td><a href="delete?name=${i.id}">delete</a> </td>
                            <td><a href="update1?id=${i.id}">update</a> </td>
                        </tr>
                    </c:forEach>
                </table>
            </center>
            <center><p>country</p>
                 <a href="addC.jsp"> aadd</a>
                <table border="1px">
                    <tr>
                        <td>id</td>
                        <td>name</td>
                        <td>update</td>
                    </tr>
                    <c:forEach items="${requestScope.ct}" var = "i">
                        <tr>
                            <td>${i.id}</td>
                            <td>${i.name}</td>




                            <td><a href="updateCT?id=${i.id}">update</a> </td>
                        </tr>
                    </c:forEach>
                </table>
            </center>
            <center><p>
                    Type
                </p>
                 <a href="addT.jsp"> aadd</a>
                <table border="1px">
                    <tr>
                        <td>id</td>
                        <td>name</td>
                        <td>update</td>

                    </tr>
                    <c:forEach items="${requestScope.t}" var = "i">
                        <tr>
                            <td>${i.id}</td>
                            <td>${i.name}</td>
                            <td><a href="updateT?id=${i.id}">update</a> </td>
                        </tr>
                    </c:forEach>
                </table>
            </center>

        </div>

        <div id="piechart"></div>

        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

        <script type="text/javascript">
            // Load google charts
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            // Draw the chart and set the chart values
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Task', 'Hours per Day'],
            <c:forEach items="${requestScope.f1}" var = "i"  >
                    ['${i.name}', ${i.view}],
            </c:forEach>
                    ['Eat', 100000]

                ]);

                // Optional; add a title and set the width and height of the chart
                var options = {'title': 'view', 'width': 550, 'height': 400};

                // Display the chart inside the <div> element with id="piechart"
                var chart = new google.visualization.PieChart(document.getElementById('piechart'));
                chart.draw(data, options);
            }
        </script>

    </body>
</html>
