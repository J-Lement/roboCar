package com.controller;

import com.pojo.Car;
import com.pojo.Video;
import com.service.CarService;
import com.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private CarService carService;

    @RequestMapping("/queryCarInfo/{cId}")
    public String queryCarVideo(Model model, @PathVariable("cId") int cId){
        Video video = videoService.queryCarVideo(cId);
        Car car = carService.query(cId);
        model.addAttribute("video", video);
        model.addAttribute("car",car);
        return "carInfo";
    }

    @RequestMapping("/queryAllVideo")
    public String queryAllVideo(Model model){
        List<Video> list = videoService.queryAllVideo();
        model.addAttribute("videoList",list);
        return "queryAllVideo";
    }

    @RequestMapping("/operation")
    @ResponseBody
    public String operation(int order, int cId, Model model){
        System.out.println("这里是controller,参数order：" + order + " ,cId:" + cId);
        videoService.operation(order, cId);
        model.addAttribute("cId", cId);

        return "success";
//        return "redirect:/video/queryCarInfo/{cId}";
    }

}
