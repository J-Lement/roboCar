package com.service.impl;

import com.dao.CarDao;
import com.pojo.Car;
import com.pojo.Point;
import com.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private static int num = 0;
    @Autowired
    private CarDao carDao;

    @Override
    public int addCar(Car car) {
        if(car.getcId() == null)
            ;
        return carDao.addCar(car);
    }

    @Override
    public int deleteCar(Car car) {
        return carDao.deleteCar(car);
    }

    @Override
    public int updateCar(Car car) {
        return carDao.updateCar(car);
    }

    @Override
    public Car query(Integer id) {
        return carDao.query(id);
    }

    @Override
    public List<Car> queryAll() {
        return carDao.queryAll();
    }

    @Override
    public List<Point> queryRoute() {
        return carDao.queryRoute();
    }

    @Override
    public int addRoute(Point point) {
        return carDao.addRoute(point);
    }

    @Override
    public int deleteRoute() {
        return carDao.deleteRoute();
    }

    @Override
    public List<Point> queryAllPoints(){
        return carDao.queryAllPoints();
    };

    @Override
    public int operation(int carId, int order){
        int flag = 0;
        flag = carId + order;
        num ++;
        System.out.println("第" + num + "次进入service，carId" + carId + " order:" + order + " flag:" + flag);

        switch (order){
            case 1:
                System.out.println("前进前进前进...");break;
            case 2:
                System.out.println("后退后退...");break;
            case 3:
                System.out.println("准备左转...");break;
            case 4:
                System.out.println("准备右转...");break;
        }
        return flag;
    }
}
