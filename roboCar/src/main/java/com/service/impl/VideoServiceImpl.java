package com.service.impl;

import com.dao.VideoDao;
import com.pojo.Video;
import com.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    private static int num = 0;

    @Autowired
    private VideoDao videoDao;

    @Override
    public List<Video> queryAllVideo() {
        return videoDao.queryAllVideo();
    }

    @Override
    public int operation(int order, int cId) {
        int flag = 0;
        flag = cId + order;
        num ++;
        System.out.println("第" + num + "次进入service，cId" + cId + " order:" + order + " flag:" + flag);

        switch (order){
            case 1:
                System.out.println("向上看...");break;
            case 2:
                System.out.println("向下看...");break;
            case 3:
                System.out.println("准备向左...");break;
            case 4:
                System.out.println("准备向右...");break;
        }
        return flag;
    }

    @Override
    public Video queryCarVideo(int cId) {
        return videoDao.queryCarVideo(cId);
    }


}
