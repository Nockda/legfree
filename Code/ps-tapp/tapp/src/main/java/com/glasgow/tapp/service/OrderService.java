package com.glasgow.tapp.service;

import com.glasgow.tapp.dao.OrderDao;
import com.glasgow.tapp.dao.UserDao;
import com.glasgow.tapp.dao.VehicleDao;
import com.glasgow.tapp.pojo.Order;
import com.glasgow.tapp.pojo.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hongbin BAO
 * @Date 2022/10/16 22:05
 */

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private VehicleDao vehicleDao;

    @Autowired
    private VehicleService vehicleService;
    public List<Order> getOrderInfoByUserId(String userId) {

        List<Order> orderList = new ArrayList<>();

        orderList = orderDao.getOrderInfoByUserId(userId);
        return orderList;
    }

    public Order updateOrderStateByOrderId(String orderId) {
        Order orderInfo = new Order();
        orderDao.updateOrderStateByOrderId(orderId);

        orderInfo = orderDao.getOrderInfoByOrderId(orderId);

        int orderMoney = orderInfo.getOrderMoney();
        String userId = orderInfo.getUserId();

        //get money which is in  user table
        int money = userDao.getUserMoneyByUserId(orderInfo.getUserId());
        //up date money
        int remainMoney = money - orderMoney;
        //sql for update UserMoney
        userDao.updateUserMoneyByUserId(remainMoney,userId);


        // get vehicle info by vehicleId
        Vehicle vehicleInfo = new Vehicle();
        vehicleInfo = vehicleDao.getVehicleInfoById(orderInfo.getVehicleId());
        //update vehicle state
        int vehicleDurable = vehicleInfo.getVehicleDurable() - orderInfo.getTime();
        int vehicleBattery = vehicleInfo.getVehicleBattery() - orderInfo.getTime();
        vehicleService.updateVehicleInfoById(orderInfo.getVehicleId(),vehicleDurable,vehicleBattery);


        return orderInfo;

    }
}
