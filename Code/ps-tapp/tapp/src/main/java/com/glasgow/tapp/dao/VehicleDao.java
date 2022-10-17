package com.glasgow.tapp.dao;

import com.glasgow.tapp.pojo.Vehicle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Hongbin BAO
 * @Date 2022/10/16 18:03
 */

@Mapper
@Repository

public interface VehicleDao {


    /**
     * 获取VehicleInfo
     * @param
     * @return
     */
    List<Vehicle> getVehicleInfo();

    /**
     * 获取VehicleInfoByLocation
     * @param location
     * @return
     */
    List<Vehicle> getVehicleInfoByLocation(String location);

    /**
     * 更改车辆状态
     * @param id
     */
    void setVehicleStateById(String id);

    int updateVehicleInfoById(String vehicleId, int vehicleDurable, int vehicleBattery);

    Vehicle getVehicleInfoById(String vehicleId);
}
