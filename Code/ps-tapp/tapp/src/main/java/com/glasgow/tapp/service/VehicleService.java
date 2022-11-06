package com.glasgow.tapp.service;

import com.glasgow.tapp.dao.OrderDao;
import com.glasgow.tapp.dao.VehicleDao;
import com.glasgow.tapp.pojo.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;



/**
 * @author Hongbin BAO
 * @Date 2022/10/16 18:04
 */

@Service
public class VehicleService {


    @Autowired
    private VehicleDao vehicleDao;
    @Autowired
    private OrderDao orderDao;
    /**
     * 获取VehicleInfo
     * @return
     */

    public List<Vehicle> getVehicleInfo(){
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList = vehicleDao.getVehicleInfo();
        return vehicleList;
    }


    /**
     * getVehicleInfoByLocation
     * @param location
     * @return
     */
    public List<Vehicle> getVehicleInfoByLocation(String location) {
        //String location ="G28QQ";
        List<Vehicle> vehicleList = new ArrayList<>();

        vehicleList = vehicleDao.getVehicleInfoByLocation(location);
        return vehicleList;
    }

    public String setVehicleStateById(String id,String userId,int time,String location) {
        // change vehicle state
        vehicleDao.setVehicleStateById(id);
        //change vehicle station
        vehicleDao.setVehicleLocationById(location,id);
        //Generate order number
        String orderId = "";
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            orderId += String.valueOf(random.nextInt(10));
        }

        // generate order info
        Map orderMap = new HashMap();

        orderMap.put("orderId",orderId);
        orderMap.put("userId",userId);
        orderMap.put("time",time);
        orderMap.put("vehicleId",id);

        int  vehicleMoney = vehicleDao.getVehicleMoneyById(id);
        int  orderMoney =  time * vehicleMoney;
        orderMap.put("orderMoney",orderMoney);
        orderMap.put("state","0");
        orderMap.put("createTime",new Date());


        orderDao.insertOrderInfo(orderMap);

        return "success";
    }




    public String updateVehicleInfoById(String vehicleId, int vehicleDurable, int vehicleBattery) {

        vehicleDao.updateVehicleInfoById(vehicleId,  vehicleDurable, vehicleBattery);

        return "success";
    }

    public String updateVehicleDurableById(String vehicleId) {


        vehicleDao.updateVehicleDurableById(vehicleId);
        return "success";
    }

    public String updateVehicleBatteryById(String vehicleId) {


        vehicleDao.updateVehicleBatteryById(vehicleId);

        return "success";
    }
}
