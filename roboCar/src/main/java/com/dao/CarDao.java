package com.dao;

import com.pojo.Car;
import com.pojo.Point;

import java.util.List;

public interface CarDao {
    int addCar(Car car);

    int deleteCar(Car car);

    int updateCar(Car car);

    Car query(int id);

    List<Car> queryAll();

    List<Point> queryAllPoints();

    List<Point> queryRoute();

    int addRoute(Point point);

    int deleteRoute();
}
