<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<title>添加点</title>
<!--引用百度地图API-->
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=BPfKT4SLByq5KucQHje4SU7zeD4M81py"></script>

</head>

<body>
	<!--百度地图容器-->

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
							<div class="col-md-12 column">
								<table class="table table-striped" id="pointlist">
									<thead>
										<tr>
											<th>经度</th>
											<th>纬度</th>
											<th>名字</th>
											<th>删除</th>
										</tr>
									</thead>
									<tbody id="pointbody" style="height: 170px;">
										<tr>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
										</tr>

									</tbody>
								</table>
								<ul class="pagination" id="pagefoot">

									<!--分页-->
								</ul>
							</div>
						</div>
						<br>
						<div class="row clearfix">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-head">点的基本信息</h3>
								</div>
								<form id="form">
									<div class="panel-body">
										<span>经度:</span><input type="text" id="lng">
									</div>
									<div class="panel-body">
										<span>纬度:</span> <input type="text" id="lat">
									</div>
									<div class="panel-body">
										<span>名字:</span><input type="text" id="name">
									</div>
									<div class="panel-footer">
										<input type="button" value="添加" onclick="addPoint()">
										<input type="reset" value="重置" id="reset"> <input
											type="button" value="提交" id="submit">
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
<script src="/js/mappoint.js"></script>
</html>