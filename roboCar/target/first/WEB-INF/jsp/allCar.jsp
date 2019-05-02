<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/4/25
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>car列表</title>
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
                    <small>小车列表 —— 显示所有小车</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${path}/car/toAddCar">新增</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>小车编号</th>
                    <th>小车名称</th>
                    <th>经度</th>
                    <th>纬度</th>
                    <th>速度</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="car" items="${requestScope.get('list')}" varStatus="status">
                    <tr>
                        <td>${car.cId}</td>
                        <td>${car.cName}</td>
                        <td>${car.cLongitude}</td>
                        <td>${car.cLatitude}</td>
                        <td>${car.cSpeed}</td>
                        <td>
                            <a href="${path}/car/toUpdateCar?id=${car.cId}">更改</a> |
                            <a href="<%=appPath%>/car/delete/${car.cId}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

