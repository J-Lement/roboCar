package com.service;

import com.pojo.Edge;
import com.pojo.Point;

public interface MapService {
    int InsertPoint(Point point);

    int InsertLine(Edge edge);
}
