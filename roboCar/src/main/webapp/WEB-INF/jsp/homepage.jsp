<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ include file="base.jsp" %> 
 --%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#">首页</a></li>
					<li><a href="#">小车定位信息</a></li>
					<li><a href="/video/queryAllVideo">视频监控</a></li>
					<li class="dropdown pull-right"><a href="#"
						data-toggle="dropdown" class="dropdown-toggle">下拉<strong
							class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a href="#">操作</a></li>
							<li><a href="#">设置栏目</a></li>
							<li><a href="#">更多设置</a></li>
							<li class="divider"></li>
							<li><a href="#">分割线</a></li>
						</ul></li>
				</ul>
				<dl class="dl-horizontal">
					<dt>项目</dt>
					<dd>巡逻车课题组</dd>
					<dt>登录人</dt>
					<dd>xxx</dd>
					<dd>欢迎使用本系统！</dd>
					
				</dl>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<table class="table">
					<thead>
						<tr>
							<th>编号</th>
							<th>小车名</th>
							<th>经度</th>
							<th>纬度</th>
							<th>速度</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${carlist }" var="list">
						<tr class="info">
							<td>${list.cId }</td>
							<td>${list.cName }</td>
							<td>${list.cLongitude }</td>
							<td>${list.cLatitude }</td>
							<td>${list.cSpeed }</td>
							<td>使用中</td>
							<td><input type="button" class="btn btn-primary" value="链接小车"></td>
						</tr>
					</c:forEach>	
						<!-- <tr class="success">
							<td>1</td>
							<td>TB - Monthly</td>
							<td>01/04/2012</td>
							<td>Approved</td>
							<td>Approved</td>
						</tr>
						<tr class="error">
							<td>2</td>
							<td>TB - Monthly</td>
							<td>02/04/2012</td>
							<td>Declined</td>
						</tr>
						<tr class="warning">
							<td>3</td>
							<td>TB - Monthly</td>
							<td>03/04/2012</td>
							<td>Pending</td>
						</tr>
						<tr class="info">
							<td>4</td>
							<td>TB - Monthly</td>
							<td>04/04/2012</td>
							<td>Call in to confirm</td>
						</tr> -->
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>