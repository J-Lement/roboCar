package com.dao;

import com.pojo.Edge;
import com.pojo.Point;

import java.util.List;

public interface MapDao {
    int InsertPoint(Point point);

    int InsertLine(Edge edge);
}
