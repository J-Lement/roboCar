package com.controller;

import com.pojo.Car;
import com.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
/*
小车的增删改查以及操作
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
    public String operation(int num, int cId, Model model){
        System.out.println("contrller:" + num + " cId:" + cId);
        carService.operation(cId, num);
        model.addAttribute("cId", cId);
        return "redirect:/video/queryCarInfo/{cId}";
    }
}
