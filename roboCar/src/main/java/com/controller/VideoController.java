package com.controller;

import com.pojo.Car;
import com.pojo.Video;
import com.service.CarService;
import com.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public String operation(int order, int cId, Model model){
        videoService.operation(order, cId);
        model.addAttribute("cId", cId);
        return "redirect:/video/queryCarInfo/{cId}";
    }

}
