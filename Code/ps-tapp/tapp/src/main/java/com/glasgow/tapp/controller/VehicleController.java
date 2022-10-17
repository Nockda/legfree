package com.glasgow.tapp.controller;

import com.glasgow.tapp.pojo.Vehicle;
import com.glasgow.tapp.service.UserService;
import com.glasgow.tapp.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hongbin BAO
 * @Date 2022/10/16 18:02
 */

@ResponseBody
@RestController
@Slf4j
public class VehicleController {



    @Autowired
    private VehicleService vehicleService;


    /**
     *查询可用车辆
     */
    @RequestMapping(value = "vehicle/getVehicleInfo",method = RequestMethod.GET)
    public List<Vehicle> getVehicleInfo(){
       return vehicleService.getVehicleInfo();
    }

    /**
     * 查询当前地区可用车辆
     */
    @RequestMapping(value = "vehicle/getVehicleInfoByLocation",method = RequestMethod.POST)
    public List<Vehicle> getVehicleInfoByLocation(@RequestParam(value = "location", required = true)  String location){
        return vehicleService.getVehicleInfoByLocation(location);
    }


    /**
     * 根据id 更新车辆状态
     */
    @RequestMapping(value = "vehicle/setVehicleStateById",method = RequestMethod.POST)
    public String setVehicleStateById(@RequestParam(value = "id", required = true)  String id,
                                      @RequestParam(value = "userId", required = true)  String userId,
                                      @RequestParam(value = "time", required = true)  int  time){
        return vehicleService.setVehicleStateById(id,userId,time);
    }

//    /**
//     * 根据车辆id 修改durable值
//     */
//    @RequestMapping(value = "vehicle/updateVehicleDurableById",method = RequestMethod.POST)
//    public String updateVehicleDurableById(@RequestParam(value = "id", required = true)  String id){
//
//    }
}
