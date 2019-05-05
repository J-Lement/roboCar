<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/5/1
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/car.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        function operateCar(order) {
            <%--window.location.href = "/car/operation?order="+ order +"&cId=${car.cId}";--%>
            $.ajax({
                async: true,
                type: "get",
                url: "/car/operation",
                data: {
                    "order":order,
                    "cId":${car.cId}
                },
                datatype: "json",
                success: function (data) {
                    alert("发送成功！" + data);
                },
                error: function () {
                  alert("发送失败。。。");
                }
            });
        }

        function operateCamera(order){
            <%--window.location.href = "/video/operation?order=" + order + "&cId=${car.cId}";--%>
            $.ajax({
                async: true,
                type: "get",
                url: "/video/operation",
                data: {
                    "order":order,
                    "cId":${car.cId}
                },
                datatype: "json",
                success: function (data) {
                    alert("发送成功！" + data);
                },
                error: function () {
                    alert("发送失败。。。");
                }
            });
        }
    </script>
</head>
<body>
<div class="container" style="width:100%">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#">首页</a>
                </li>
                <li>
                    <a href="/car/setRoute">设置路线</a>
                </li>
                <li >
                    <a href="/video/queryAllVideo">视频监控</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-6 column">
            <video src="${video.vRoute}" controls="controls"  autoplay='autoplay' style="max-width: 100%;"></video>
        </div>
        <div class="col-md-6 column">
            <div class="operation">
                <table>
                    <tr>
                        <th>小车</th>
                    </tr>
                    <tr>
                        <td>
                            <input class="btn btn-primary" type="button" onclick="operateCar(1)" value="前进"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="btn btn-primary" type="button" onclick="operateCar(2)" value="后退"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="btn btn-primary" type="button" onclick="operateCar(3)" value="左转"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="btn btn-primary" type="button" onclick="operateCar(4)" value="右转"/>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="operation">
                <table>
                    <tr>
                        <th>摄像头</th>
                    </tr>
                    <tr>
                        <td>
                            <input class="btn btn-primary" type="button" onclick="operateCamera(1)" value="向上"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="btn btn-primary" type="button" onclick="operateCamera(2)" value="向下"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="btn btn-primary" type="button" onclick="operateCamera(3)" value="向左"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="btn btn-primary" type="button" onclick="operateCamera(4)" value="向右"/>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3>经度${car.cLongitude}</h3>
            <h3>纬度${car.cLatitude}</h3>
            <h3>速度${car.cSpeed}</h3>
        </div>
    </div>
</div>
</body>
</html>
