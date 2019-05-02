<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/4/25
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>修改小车</title>
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
                    基于SSM框架的管理系统：简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改小车</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="" name="userForm">
        <input type="hidden" name="cId" value="${car.cId}"/>
        小车名称：<input type="text" name="cName" value="${car.cName}"/>
        小车经度：<input type="text" name="cLongitude" value="${car.cLongitude}"/>
        小车纬度：<input type="text" name="cLatitude" value="${car.cLatitude }"/>
        小车速度：<input type="text" name="cSpeed" value="${car.cSpeed}"/>
        <input type="button" value="提交" onclick="updateCar()"/>
    </form>
    <script type="text/javascript">
        function updateCar() {
            var form = document.forms[0];
            form.action = "<%=basePath %>car/updateCar";
            form.method = "post";
            form.submit();
        }
    </script>
</div>
