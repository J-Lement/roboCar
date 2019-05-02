<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/5/1
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/car.css" rel="stylesheet" type="text/css"/>
    <%--<style>--%>
        <%--.test{--%>
             <%--float: left;--%>
             <%--width: 30%;--%>
             <%--box-sizing: border-box;--%>
             <%--padding: 10px;--%>
             <%--min-width: 150px;--%>
         <%--}--%>

        <%--.container{--%>
                <%--width:100%;--%>
        <%--} --%>
    <%--</style>--%>
</head>
<body>
<div class="container" style="width:100%">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#">首页</a>
                </li>
                <li class="disabled">
                    <a href="#">小车定位信息</a>
                </li>
                <li >
                    <a href="/video/queryAllVideo">视频监控</a>
                </li>
            </ul>
        </div>
    </div>
    <c:forEach var="video" items="${videoList}">
        <div class='allCar'>
            <a class="btn" href="/video/queryCarInfo/${video.cId}">小车<h>${video.cId}</h>信息</a>
            <video src="${video.vRoute}" controls="controls"  autoplay='autoplay' style="max-width: 100%;"></video>
            <%--<video src="http://localhost:8080/Users/Lement/Desktop/trailer.mp4" controls="controls"  autoplay='autoplay' style="max-width: 100%;"></video>--%>
        </div>
    </c:forEach>

</div>
</body>
</html>
