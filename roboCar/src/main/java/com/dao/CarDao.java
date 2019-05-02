package com.dao;

import com.pojo.Car;

import java.util.List;

public interface CarDao {
    int addCar(Car car);

    int deleteCar(Car car);

    int updateCar(Car car);

    Car query(int id);

    List<Car> queryAll();

}
