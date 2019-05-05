package com.service.impl;

import com.dao.MapDao;
import com.pojo.Edge;
import com.pojo.Point;
import com.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapServiceImpl implements MapService {
    @Autowired
    private MapDao mapDao;

    @Override
    public int InsertPoint(Point point) {
        return mapDao.InsertPoint(point);
    }

    @Override
    public int InsertLine(Edge edge) {
        System.out.println("进入service...");
        return mapDao.InsertLine(edge);
    }
}
