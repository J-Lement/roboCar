package com.service;

import com.pojo.Car;

import java.util.List;

public interface CarService {
    int addCar(Car car);

    int deleteCar(Car car);

    int updateCar(Car car);

    Car query(Integer id);

    List<Car> queryAll();

    int operation(int carId, int order);
}
