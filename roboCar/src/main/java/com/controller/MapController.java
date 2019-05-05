package com.controller;

import com.pojo.Edge;
import com.pojo.Point;
import com.service.CarService;
import com.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/map")
public class MapController {
	@Autowired
	private MapService mapService;

	@Autowired
	private CarService carService;

	@RequestMapping("/mappoint")
	public String map() {
		return "mappoint";
	}
	
	@PostMapping("/pointSubmit")
	@ResponseBody
	public String pointSubmit(@RequestBody List<Point> list) {
		for(int i = 0; i < list.size(); i ++){
			System.out.println(list.get(i).getpLongitude()+","+list.get(i).getpLatitude());
			mapService.InsertPoint(list.get(i));
		}
		
		return "success";
	}
	
	@RequestMapping("/maproute")
	public String mapRoute() {
		return "maproute";
	}
	
	
	@RequestMapping("/showPoint")
	@ResponseBody
	public List<Point> showPoint() {
		System.out.println("进入maproute了。准备返回所有点。。。");
		List<Point> list;
		list = carService.queryAllPoints();

		return list;
	}
	
	
	@RequestMapping("/lineSubmit")
	@ResponseBody
	public String lineSubmit(int startpoint, int endpoint, double value, int f) {
		System.out.println("已经入路线添加。。。");
		Edge edge = new Edge();
		edge.setpFirstid(startpoint);
		edge.setpSecondid(endpoint);
		edge.seteValue(value/*.setScale(2, BigDecimal.ROUND_HALF_UP)*/);
		System.out.println(value);
		System.out.println(edge);

		int i = mapService.InsertLine(edge);
		System.out.println("数据库返回值：" + i);
		if (f==2) {
			edge.setpFirstid(endpoint);
			edge.setpSecondid(startpoint);
			mapService.InsertLine(edge);
		}
		return "success";
	}
}
