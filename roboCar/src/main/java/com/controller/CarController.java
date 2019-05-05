package com.controller;

import com.pojo.Car;
import com.pojo.Point;
import com.service.CarService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 小车的增删改查以及操控
 */
@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("toAddCar")
    public String toAddCar(){
        return "addCar";
    }

    @RequestMapping("/addCar")
    public String addCar(Car car){
        carService.addCar(car);
//        if(num == -1)
//            System.out.println("信息填写错饿了");
        return "redirect:/car/queryAll";
    }

    @RequestMapping("/query/{carId}")
    public String queryCar(Model model,@PathVariable("carId") int id){
        Car car = carService.query(id);
        model.addAttribute("car",car);
        return "addCar";
    }

    @RequestMapping("/queryAll")
    public String queryAll(Model model){
        List<Car> list = carService.queryAll();
        model.addAttribute("list",list);
        return "allCar";
    }

    @RequestMapping("toUpdateCar")
    public String toUpdateCar(Model model, int id){
        model.addAttribute("car",carService.query(id));
        return "updateCar";
    }

    @RequestMapping("/updateCar")
    public String updateCar(Model model,Car car){
        System.out.println("zhe里华盛顿和付款时间和：" + car.getcName());
        carService.updateCar(car);
        car = carService.query(car.getcId());
        model.addAttribute("car",car);
        return "redirect:/car/queryAll";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        carService.deleteCar(carService.query(id));
        return "redirect:/car/queryAll";
    }

    @RequestMapping("/operation")
    @ResponseBody
    public String operation(int order,int cId, Model model){
        System.out.println("controller:" + order + " cId:" + cId);
        carService.operation(cId, order);
        model.addAttribute("cId", cId);

        return "success";
//        return "redirect:/video/queryCarInfo/{cId}";
    }

    @RequestMapping("/setRoute")
    public String setRoute(){
        return "setRoute";
    }

    @RequestMapping("/getPoints")
    @ResponseBody
    public List<Point> getRoute(Model model){
        System.out.println("已经进入到设置路线了了了了。。。");
        List<Point> pointList;
        pointList = carService.queryAllPoints();

        return pointList;
    }

    @RequestMapping(value = "/getRoute", method = RequestMethod.POST)
    public String getRoute(@RequestBody List<Point> list, Model model){
        carService.deleteRoute();//清空表，保证表中只保存一条路线

        for(int i = 0; i < list.size(); i ++){//转换成List
            System.out.println("lon:" + list.get(i).getpLongitude() + ",lat:" + list.get(i).getpLatitude());
            carService.addRoute(list.get(i));
        }
        return "getRoute";
    }

    @RequestMapping("/toR")
    public String toR(){//setRoute.jsp界面中ajax界面跳转的请求
        return "getRoute";
    }

    @RequestMapping("/getTheRoute")
    @ResponseBody
    public List<Point> getTheRoute(){
        List<Point> pointsList;
        pointsList = carService.queryRoute();

        return pointsList;
    }

}
