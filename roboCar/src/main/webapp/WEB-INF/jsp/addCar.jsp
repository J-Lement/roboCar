<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/4/25
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    System.out.println("path路径：" + path + " basepath路径：" + basePath);
%>
<html>
<head>
    <title>新增小车</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增小车</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="" name="userForm">
        小车名称：<input type="text" name="cName" value=""><br><br><br>
        小车经度：<input type="text" name="cLongitude" value=""><br><br><br>
        小车纬度：<input type="text" name="cLatitude" value=""><br><br><br>
        小车速度：<input type="text" name="cSpeed" value=""><br><br><br>
        <input type="button" value="添加" onclick="addCar()">
    </form>

    <script type="text/javascript">
        function addCar() {
            var form = document.forms[0];
            form.action = "<%--<%=basePath %>--%>/car/addCar";
            form.method = "post";
            form.submit();
        }
    </script>
</div>
