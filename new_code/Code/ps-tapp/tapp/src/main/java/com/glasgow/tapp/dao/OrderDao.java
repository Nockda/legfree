package com.glasgow.tapp.dao;

import com.glasgow.tapp.pojo.Order;
import com.glasgow.tapp.pojo.Vehicle;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Hongbin BAO
 * @Date 2022/10/16 22:04
 */


@Mapper
@Repository
public interface OrderDao {
    List<Order> getOrderInfo();



    List<Order> getOrderInfoByUserId(String userId);

    int insertOrderInfo(Map map);

    int updateOrderStateByOrderId(String orderId);

    Order getOrderInfoByOrderId(String orderId);


    List<Order> getAllOrderInfo();
    List<Order> getAllOrderInfoByDate(String date1,String date2);

    boolean insertErrorInfo(String userId,String vehicleId,String message);
    boolean updateVehicleInfoSts(String vehicleId,String message);
    boolean chargeVehicle(String vehicleId);
    boolean repairVehicle(String vehicleId);
    boolean moveVehicle(String vehicleId,String location);

    boolean insertOriginOrderInfo(String order_id, String user_id,String vehicle_id, int fee,String vehicle_location);
    boolean updateVehicleInfoStsToInUse(String vehicle_id);

    boolean updateOrderInfoForReturn(String order_id, String to_location,int time,String vehicle_id);
    boolean updateVehicleAfterReturn(String vehicle_id,int battery,int broken,String to_location);

    boolean updateOrderInfoPaid(String order_id);
    boolean updateUserAccount(String user_id,String order_id);
    List<Order> getOrderInfoByUserName(String user_id);

    int getNormalVec();

    int getBrokenVec();

    int getLowBatteryVec();

    int getInUseVec();
    int getBrokenReport();

    int getLowBatteryReport();

}
