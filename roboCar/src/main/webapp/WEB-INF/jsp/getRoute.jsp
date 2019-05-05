<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/5/4
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
    <title>Hello, World</title>
    <style type="text/css">
        html{height:100%}
        body{height:100%;margin:0px;padding:0px}
        #container{height:100%}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=3.0&ak=BPfKT4SLByq5KucQHje4SU7zeD4M81py">
        //v3.0版本的引用方式：src="http://api.map.baidu.com/api?v=3.0&ak=您的密钥"
    </script>

</head>

<body>
<div id="container"></div>
<script type="text/javascript">
    var rData;//接收后台数据

    var map = new BMap.Map("container");// 创建地图实例

    var point = new BMap.Point(115.835486, 28.657072);// 创建点坐标

    map.centerAndZoom(point, 17);// 初始化地图，设置中心点坐标和地图级别

    map.enableScrollWheelZoom(true);

    $(document).ready(function () {//页面加载时触发，向后台请求数据
        $.ajax({
            async: true,
            type: "get",
            url: "/car/getTheRoute",
            data: "",
            datatype: "json",
            success: function (res) {
                alert("发送成功！" + res);
                rData = res;//获取路线的所有点
                getRoute();
            },
            error: function () {
                alert("发送失败。。。");
            }
        });
    });

    function getRoute(){//显示路线
        var points = new Array();
        $.each(rData, function (i, obj) {
            // console.log(obj.pLongitude + "," + obj.pLatitude);
            var marker = new BMap.Marker(new BMap.Point(obj.pLongitude,obj.pLatitude)); // 创建点
            map.addOverlay(marker);    //增加点
            points[i] = new BMap.Point(obj.pLongitude, obj.pLatitude);
        });
        map.setViewport(points);//让所有点在视野范围内

        var polyline = new BMap.Polyline(points, {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});   //创建折线
        map.addOverlay(polyline);   //增加折线

    }


</script>

<input class="btn btn-primary" type="button" onclick="getRoute()" value="提交"/>
</body>
</html>
