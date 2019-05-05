<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/5/3
  Time: 20:23
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
    var rData;//存储后台穿过来的所有点的数据
    var num = 0;//记录array的长度
    var pArray = new Array();//存储已点击的点

    var map = new BMap.Map("container");// 创建地图实例

    var point = new BMap.Point(115.835486, 28.657072);// 创建点坐标

    map.centerAndZoom(point, 17);// 初始化地图，设置中心点坐标和地图级别

    map.enableScrollWheelZoom(true);

    $(document).ready(function () {//页面加载的时候从后台获取点的数据
        $.ajax({
            async: true,
            type: "get",
            url: "/car/getPoints",
            data: "",
            datatype: "json",
            success: function (res) {
                alert("发送成功！" + res);
                rData = res;//接收后台数据
                getPoints();
            },
            error: function () {
                alert("发送失败。。。");
            }
        });
    });

    function getPoints() {//在地图上显示点

        // console.log("data:" + rData);
        var pointArray = new Array();
        $.each(rData, function (i, obj) {//遍历数组，rData是数组，i是当前遍历位置，obj是当前的元素
            // console.log(obj.pLongitude + "," + obj.pLatitude);
            var marker = new BMap.Marker(new BMap.Point(obj.pLongitude,obj.pLatitude)); // 创建点
            map.addOverlay(marker);    //增加点
            pointArray[i] = new BMap.Point(obj.pLongitude, obj.pLatitude);
            marker.addEventListener("click",attribute);
        })

        map.setViewport(pointArray);//让所有点在视野范围内
    }


    function attribute(e){//点击地图上的点触发此事件，获取点的位置
        var p = e.target;
        alert("marker的位置是" + p.getPosition().lng + "," + p.getPosition().lat);

        var pt = new BMap.Point(p.getPosition().lng, p.getPosition().lat);

        // console.log("position之气那: " + pt);
        var point = new Object();
        point.pLongitude = pt.lng;
        point.pLatitude = pt.lat;
        pArray[num ++] = point;//保存点击的点

        // console.log("poisition之后：" + pt);
        var allOverlay = map.getOverlays();//获取地图上所有覆盖物
        for (var i = 1; i < allOverlay.length -1; i++){//第一个和最后一个存的是label，所以去掉首尾，否则会报错
            if((allOverlay[i].getPosition()).equals(pt)){
                // allOverlay[i].setIcon("", new BMap.Size(30,30));
                console.log("图标对象：" + allOverlay[i].getIcon().imageUrl);
            }
        }

        //改变图标
        // var myIcon = new BMap.Icon("http://p4.img.cctvpic.com/nettv/newgame/cdn_pic/mzl.gdkklqbh.png", new BMap.Size(30,30));
        // var marker2 = new BMap.Marker(pt,{icon:myIcon});  // 创建标注
        // map.addOverlay(marker2);              // 将标注添加到地图中
    }

    function getRoute() {//点击按钮触发，向后台发送已点击的点，成功后跳转到路线界面
        $.each(pArray,function (i,item) {
            console.log("遍历保存的点："+ item.pLongitude + "," + item.pLatitude);
        });

        $.ajax({
            async: true,
            type: "post",
            url: "/car/getRoute",
            data: JSON.stringify(pArray),
            contentType: "application/json; charset=utf-8",
            datatype: "json",
            success: function () {
                alert("发送成功！");
                window.location.href="/car/toR";//成功后跳转界面
            },
            error: function () {
                alert("发送失败。。。");
            }
        });
    }


</script>

<input class="btn btn-primary" type="button" onclick="getRoute()" value="提交"/>
</body>
</html>
