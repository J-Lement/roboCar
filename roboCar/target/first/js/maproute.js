var flag = 1;
var id = 0;
var allpoint = [];

var startpoint = {};
var endpoint = {};
var map;
initMap();


// 创建和初始化地图函数：
function initMap() {
	createMap();// 创建地图
	setMapEvent();// 设置地图事件
	addMapControl();// 向地图添加控件
	addMapOverlay();// 向地图添加覆盖物
	addListener();// 添加事件监听器
	// createRoute();//规划路线图
}
function createMap() {
	map = new BMap.Map("map");
	map.centerAndZoom("南昌航空大学", 16);
}
function setMapEvent() {
	map.disableScrollWheelZoom();// 启用滚轮放大缩小
	map.enableKeyboard();// 启用键盘操作
	map.enableDragging();// 启用地图拖拽，默认启用。
	// map.disableScrollWheelZoom();//禁止滚轮方法缩小
	map.disableKeyboard();// 禁用键盘操作
	map.setMinZoom(16);// 设置地图最小级别

	map.disableDoubleClickZoom();// 启用双击放大缩小
}
function addClickHandler(target, window) {
	/*
	 * target.addEventListener("click", function() {
	 * target.openInfoWindow(window); });
	 */
}
function addMapOverlay() {

}
// 添加事件
function addListener() {
	/* map.addEventListener("click", showInfo); */
}

// 向地图添加控件
function addMapControl() {
	var scaleControl = new BMap.ScaleControl({
		anchor : BMAP_ANCHOR_BOTTOM_LEFT
	});// 比例尺控件 anchor:位置
	scaleControl.setUnit(BMAP_UNIT_METRIC);// 设置成公制单位
	map.addControl(scaleControl);

	var navControl = new BMap.NavigationControl({
		anchor : BMAP_ANCHOR_TOP_LEFT,
		type : 0
	});// 平移 缩放操作控件
	map.addControl(navControl);

	/*
	 * var mapTypeControl = new BMap.MapTypeControl({type:0});
	 * map.addControl(mapTypeControl);//提供地图、卫星、三维三种方式的地图
	 */

	/*
	 * var geolocationControl = new BMap.GeolocationControl();
	 * map.addControl(geolocationControl);//获取当前位置的控件
	 */

	/*
	 * var overviewControl = new
	 * BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:true});//缩略图控件
	 * map.addControl(overviewControl);
	 */

	var panoramaControl = new BMap.PanoramaControl();// 负责切换至全景地图的控件
	map.addControl(panoramaControl);

}

function createRoute() {
	$.post("point", null, function(data) {
		var transit = new BMap.DrivingRoute(map, {
			renderOptions : {
				map : map,
				panel : "result",
			// enableDragging : true,//起终点可进行拖拽
			},
		});
		var parray = new Array();
		for (var i = 0; i < data.length - 2; i++) {
			parray[i] = new BMap.Point(data[i + 2].longitude,
					data[i + 2].latitude);
		}

		transit.search(new BMap.Point(data[0].longitude, data[0].latitude),// 第一个起点，第二个终点，后面跟着的是途经点
		new BMap.Point(data[1].longitude, data[1].latitude), {
			waypoints : parray
		});
	}, "json")
}

function showInfo(e) {
	alert("lng:" + e.point.lng + ", lat:" + e.point.lat);
}

function loadPoint() {
	$.post("/map/showPoint", null, function(data) {
		for (var i = 0; i < data.length; i++) {
			var p = {};
			p.lng = data[i].lng;
			p.lat = data[i].lat;
			p.name = data[i].name;
			p.id = data[i].id;
			allpoint.push(p);
		}

	}, "json");// 用allpoint接受json

}
function showPoint(num) {
	flag = num;
	var pointArray = new Array();
	for (var i = 0; i < allpoint.length; i++) {
		var marker = new BMap.Marker(new BMap.Point(allpoint[i].lng,
				allpoint[i].lat), {
			title : allpoint[i].name
		}); // 创建点
		map.addOverlay(marker); // 增加点
		pointArray[i] = new BMap.Point(allpoint[i].lng, allpoint[i].lat);
		marker.setLabel(7);
		marker.addEventListener("click", attribute);
	}
}
function attribute(e) {
	var p = e.target;
	for (var i = 0; i < allpoint.length; i++) {
		if (p.getPosition().lat == allpoint[i].lat
				&& p.getPosition().lng == allpoint[i].lng) {
			if (flag == 1) {
				$("#startPoint").val(allpoint[i].id);
				startpoint = allpoint[i];
			} else {
				$("#endPoint").val(allpoint[i].id);
				endpoint = allpoint[i];
			}
		}

	}
	delAllPoint();
}

// 删除地图上的点
function delMapPoint(lng, lat) {
	var allOverlay = map.getOverlays();
	for (var i = 0; i < allOverlay.length; i++) {
		if (allOverlay[i].toString() == "[object Marker]") {
			if (allOverlay[i].getPosition().lng == lng
					&& allOverlay[i].getPosition().lat == lat) {
				map.removeOverlay(allOverlay[i]);
			}
		}
	}
}

// 删除所有点
function delAllPoint() {
	for (var i = 0; i < allpoint.length; i++) {
		delMapPoint(allpoint[i].lng, allpoint[i].lat);
	}
}

function showLine() {
	map.clearOverlays();
	var polyline = new BMap.Polyline([
			new BMap.Point(startpoint.lng, startpoint.lat),
			new BMap.Point(endpoint.lng, endpoint.lat) ], {
		strokeColor : "blue",
		strokeWeight : 2,
		strokeOpacity : 0.5
	}); // 创建折线
	map.addOverlay(polyline); // 增加折线
}


function lineSubmit() {
	if (startpoint.id==null||endpoint.id==null) {
		alert("添加失败")
		return ;
	}
	var pointA = new BMap.Point(startpoint.lng,startpoint.lat); 
	var pointB = new BMap.Point(endpoint.lng,endpoint.lat);
	var value = map.getDistance(pointA,pointB);
	alert(value+"m")
	$.ajax({
		type : "post",
		url : "/map/lineSubmit",
		data :{
			startpoint:startpoint.id,
			endpoint:endpoint.id,
			value:value,
			f:$("#direction").val()//单双向
		},
		success : function() {
			alert("添加路线成功");
			top.location='/';
		},
		error : function() {
			alert("添加路线失败")
		}

	})

}



loadPoint();
