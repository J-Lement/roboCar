
    //创建和初始化地图函数：
    function initMap() {
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addMapOverlay();//向地图添加覆盖物
        addListener();//添加事件监听器
    }

function createMap() {
    map = new BMap.Map("map");
    map.centerAndZoom("南昌航空大学", 16);
}

function setMapEvent() {
    map.enableScrollWheelZoom();//启用滚轮放大缩小
    map.enableKeyboard();//启用键盘操作
    map.enableDragging();//启用地图拖拽，默认启用。
    map.disableScrollWheelZoom();//禁止滚轮方法缩小
    map.disableDoubleClickZoom();
    map.disableKeyboard();//禁用键盘操作
    map.setMinZoom(16);//设置地图最小级别

    //map.enableDoubleClickZoom();//启用双击放大缩小
}

function addClickHandler(target, window) {

}

function addMapOverlay() {
}

//添加事件
function addListener() {
    map.addEventListener("click", writeInfo);
}

//向地图添加控件
function addMapControl() {
    var scaleControl = new BMap.ScaleControl({
        anchor: BMAP_ANCHOR_BOTTOM_LEFT
    });//比例尺控件 anchor:位置
    scaleControl.setUnit(BMAP_UNIT_METRIC);//设置成公制单位
    map.addControl(scaleControl);

    var navControl = new BMap.NavigationControl({
        anchor: BMAP_ANCHOR_TOP_LEFT,
        type: 0
    });//平移 缩放操作控件
    map.addControl(navControl);

    /*  var mapTypeControl = new BMap.MapTypeControl({type:0});
     map.addControl(mapTypeControl);//提供地图、卫星、三维三种方式的地图
     */

    /* var geolocationControl = new BMap.GeolocationControl();
    map.addControl(geolocationControl);//获取当前位置的控件
     */

    /* var overviewControl = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:true});//缩略图控件
    map.addControl(overviewControl); */

    var panoramaControl = new BMap.PanoramaControl();//负责切换至全景地图的控件
    map.addControl(panoramaControl);

}

function addPoint() {
    var lat = $("#lat").val();//纬度
    var lng = $("#lng").val();//经度
    var name = $("#name").val();//名称
    var json = {};

    json.lat = lat;
    json.lng = lng;
    json.name = name;
    if(!checkInput(lat)||!checkInput(lng)||name=="")
    {
        alert("输入信息错误");
    }else{
        pointjson.push(json);
        updatePageFootNum();
        updatetable();

        showMapPoint(lng,lat);

        resetForm();
    }

}

//清空表单中的信息
function resetForm(){
    $("#lat").val("");
    $("#lng").val("");
    $("#name").val("");
}

// 向表格添加点的信息
function showpointlist() {
    var start = (pagenum - 1) * pagesize;//起始游标
    var end = pagenum * pagesize;//结束游标
    if(pointjson.length < end){
        end = pointjson.length;
    }

    if(pointjson.length == 0){
        var text = $('<tr>' +
            '<td></td>' +
            '<td></td>' +
            '<td></td>' +
            '<td></td>' +
            '</tr>')
        $("#pointbody").append(text);
    }


    for (var i = start; i < end; i++) {
        var text = $('<tr>' +
            '<td>' + pointjson[i].lng + '</td>' +
            '<td>' + pointjson[i].lat + '</td>' +
            '<td>' + pointjson[i].name + '</td>' +
            '<td><button onclick="delPoint('+i+')">删除</button></td>' +
            '</tr>');
        $("#pointbody").append(text);
    }
}

// 删除地图上的点
function delMapPoint(lng,lat){
    var allOverlay = map.getOverlays();
    for(var i = 0;i<allOverlay.length;i++) {
        if(allOverlay[i].toString()=="[object Marker]"){
            if (allOverlay[i].getPosition().lng == lng && allOverlay[i].getPosition().lat == lat) {
                map.removeOverlay(allOverlay[i]);
            }
        }
    }
}

// 删除点
function delPoint(num){

    delMapPoint(pointjson[num].lng,pointjson[num].lat);
    pointjson.splice(num,1);
    updatePageFootNum();
    updatetable();
}


// 通过json添加更新表中的点
function updatetable() {
    $("#pointbody").empty();//清空表中的数据
    showpointlist();

}

// 更新页脚数字
function updatePageFootNum() {
    if (pointjson.length % pagesize == 0) {
        totalpage = pointjson.length / pagesize;
    }
    else {
        totalpage = Math.floor(pointjson.length / pagesize) + 1;
    }

    if(pointjson.length == 0){
        totalpage = 1;
    }


    $(".pagenum").remove();
    for (var i = 1; i <= totalpage; i++) {
        if (i == pagenum)
            text = $('<li class="pagenum active"><a id="page' + i + '">' + i + '</a></li>');
        else
            text = $('<li class="pagenum"><a onclick="skipPage('+i+')">' + i + '</a></li>');
        $("#next").before(text);
    }
}

function skipPage(num){
    pagenum = num;
    updatePageFootNum();
    updatetable();
}

// 添加prev和next
function updatePageFoot() {
    var text = $(' <li id="prev"><a onclick="prevPage()">Prev</a></li>');
    $("#pagefoot").append(text);
    updatePageFootNum();
    text = $('<li id="next"><a onclick="nextPage()">Next</a></li>');
    $("#pagefoot").append(text);
}

function prevPage() {
    if (pagenum > 1) {
        pagenum--;
        updatePageFootNum();
        updatetable();
    }
}

function nextPage() {
    if (pagenum < totalpage ) {
        pagenum++;
        updatePageFootNum();
        updatetable();
    }
    console.log("pagenum:"+pagenum);
    console.log("totalpage:"+totalpage);
}


$(document).ready(function () {
    initMap();
    updatePageFoot();
})

// 显示点击的点的经纬度
function writeInfo(e) {
    var lat = $("#lat").val(e.point.lat);//纬度
    var lng = $("#lng").val(e.point.lng);//经度

    var latNum = e.point.lat;
    var lngNum = e.point.lng;


    showMapPoint(lng,lat);

}

// 根据传过来的经纬度显示点
function showMapPoint(lng,lat){
    var point = new BMap.Point(lng,lat);
    var marker = new BMap.Marker(point);// 创建标注
    map.addOverlay(marker);             // 将标注添加到地图中
}

// 正则校验数据输入
function checkInput(num){
    var reg = /^[0-9]+([.]{1}[0-9]{1,8})?$/;
    if(!reg.test(num)){
        return false;
    }
    return true;
}

$("#submit").click(function () {
     var params = JSON.stringify(pointjson);
    $.ajax({
    	type:"post",
    	url:"/map/pointSubmit",
    	contentType: 'application/json',
    	data:params,
    	success:function(){alert("添加点成功")
    		top.location='/car/homepage';},
    	error:function(){alert("添加路线失败")}
    
    	
    })
})



var map;
var pointjson = [];//点集
var pagesize = 4;//页面数据条数
var totalpage = 1;//页面数
var pagenum = 1;//当前页面

// $.post("/", null, function(data) {//向point要一个point的list
// 	for(var i=0;i<data.length;i++){
// 		var marker = new BMap.Marker(new BMap.Point(data[i].lng, data[i].lat));
// 		map.addOverlay(marker);
// 		marker.addEventListener("click",getAttr);
// 		function getAttr(){
// 			var p = marker.getPosition();       //获取marker的位置
// 			alert("marker的位置是" + p.lng + "," + p.lat);
// 		}
// 	}
// }, "json")

