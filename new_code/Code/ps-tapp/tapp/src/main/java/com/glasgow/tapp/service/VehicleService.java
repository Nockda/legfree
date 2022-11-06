package com.glasgow.tapp.service;

import com.glasgow.tapp.dao.OrderDao;
import com.glasgow.tapp.dao.UserDao;
import com.glasgow.tapp.dao.VehicleDao;
import com.glasgow.tapp.pojo.Order;
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

    public String setVehicleStateById(String id,String userId,int time) {

        vehicleDao.setVehicleStateById(id);


        String orderId = "";
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            orderId += String.valueOf(random.nextInt(10));
        }


        Map orderMap = new HashMap();

        orderMap.put("orderId",orderId);
        orderMap.put("userId",userId);
        orderMap.put("time",time);
        orderMap.put("vehicleId",id);
        int  orderMoney =  time*10;
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


    public  List<Order> getAllOrderInfo() {

        List<Order> orderList = new ArrayList<>();

        orderList = orderDao.getAllOrderInfo();
        return orderList;
    }

    public  List<Order> getAllOrderInfoByDate(String date1, String date2) {

        List<Order> orderList = new ArrayList<>();

        orderList = orderDao.getAllOrderInfoByDate(date1,date2);
        return orderList;
    }

    public  boolean insertErrorInfo(String userId,String vehicleId,String message) {

        boolean res = orderDao.insertErrorInfo(userId,vehicleId,message);
        return res;
    }
    public  boolean updateVehicleInfoSts(String vehicleId,String message) {

        boolean res = orderDao.updateVehicleInfoSts(vehicleId,message);
        return res;
    }
    public  boolean chargeVehicle(String vehicleId) {

        boolean res = orderDao.chargeVehicle(vehicleId);
        return res;
    }
    public  boolean repairVehicle(String vehicleId) {

        boolean res = orderDao.repairVehicle(vehicleId);
        return res;
    }

    public  boolean moveVehicle(String vehicleId, String location) {

        boolean res = orderDao.moveVehicle(vehicleId,location);
        return res;
    }

    public  boolean insertOriginOrderInfo(String order_id, String user_id,String vehicle_id, int fee ,String vehicle_location) {

        boolean res = orderDao.insertOriginOrderInfo(order_id,user_id,vehicle_id,fee,vehicle_location);
        return res;
    }
    public  boolean updateVehicleInfoStsToInUse(String vehicle_id) {

        boolean res = orderDao.updateVehicleInfoStsToInUse(vehicle_id);
        return res;
    }

    public  boolean updateOrderInfoForReturn(String order_id, String to_location,int time,String vehicle_id) {

        boolean res = orderDao.updateOrderInfoForReturn(order_id,to_location,time,vehicle_id);
        return res;
    }
    public  boolean updateVehicleAfterReturn(String vehicle_id, int battery, int broken,String to_location) {

        boolean res = orderDao.updateVehicleAfterReturn(vehicle_id,battery,broken,to_location);
        return res;
    }

    public  boolean updateOrderInfoPaid(String order_id) {

        boolean res = orderDao.updateOrderInfoPaid(order_id);
        return res;
    }
    public  boolean updateUserAccount(String user_id,String order_id) {

        boolean res = orderDao.updateUserAccount(user_id,order_id);
        return res;
    }

    public  List<Order> getOrderInfoByUserName(String user_id) {

        List<Order> res = orderDao.getOrderInfoByUserName(user_id);
        return res;
    }


    public  int getNormalVec() {

        int res = orderDao.getNormalVec();
        return res;
    }

    public  int getBrokenVec() {

        int res = orderDao.getBrokenVec();
        return res;
    }
    public  int getLowBatteryVec() {

        int res = orderDao.getLowBatteryVec();
        return res;
    }
    public  int getInUseVec() {

        int res = orderDao.getInUseVec();
        return res;
    }
    public  int getBrokenReport() {

        int res = orderDao.getBrokenReport();

        return res;
    }
    public  int getLowBatteryReport() {

        int res = orderDao.getLowBatteryReport();
        return res;
    }
}
