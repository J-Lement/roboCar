<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          rel="stylesheet">

    <title>添加路线</title>
    <!--引用百度地图API-->
    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=2.0&ak=BPfKT4SLByq5KucQHje4SU7zeD4M81py"></script>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <!--左半边-->
                <div class="col-md-6 column" id="map" style="height: 600px;">
                </div>
                <div class="col-md-1 column"></div>
                <!--右半边-->
                <div class="col-md-5 column" id="result">
                    <div class="row clearfix">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-head">
                                    添加路线
                                </h3>
                            </div>
                            <form id="form">
                                <div class="panel-body">
                                    <span>起始点:</span><input  type="text" id="startPoint" disabled><input type="button"  value="选择" onclick="showPoint(1)">
                                </div>
                                <div class="panel-body">
                                    <span>终点:</span> <input type="text" id="endPoint" disabled><input type="button"  value="选择" onclick="showPoint(2)">
                                </div>
                                <div class="panel-body">
                                    <span>方向:</span>
                                    <select type="text" id="direction">
                                        <option value="1">单向</option>
                                        <option value="2">双向</option>
                                </select>
                                </div>
                                <div class="panel-footer">
                                    <input type="button" value="显示路线" onclick="showLine()">
                                    <input type="button" value="提交" id="submit" onclick="lineSubmit()">
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- <div id="bottons">
    <button onclick="">显示所有点</button>
</div> -->
</body>

<script src="/js/jquery-3.1.1.min.js"></script>
<script src="/js/json2.js"></script>
<script src="/js/maproute.js"></script>
</html>