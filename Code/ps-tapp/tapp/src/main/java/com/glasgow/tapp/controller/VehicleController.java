package com.glasgow.tapp.controller;

import com.glasgow.tapp.pojo.User;
import com.glasgow.tapp.pojo.Vehicle;
import com.glasgow.tapp.service.UserService;
import com.glasgow.tapp.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Hongbin BAO
 * @Date 2022/10/16 18:02
 */

@ResponseBody
@RestController
@Slf4j
public class VehicleController extends SuperController{



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
    public List<Vehicle> getVehicleInfoByLocation(@RequestBody Map<String,String> param){
        return vehicleService.getVehicleInfoByLocation(param.get("location"));
    }


    /**
     * update vehicle State By ID
     */
    @RequestMapping(value = "vehicle/setVehicleStateById",method = RequestMethod.POST)
    public String setVehicleStateById(@RequestBody Map<String,String> param){
        return vehicleService.setVehicleStateById(param.get("vehicleId"),String.valueOf(getCurrentUser().getUserId()),
                Integer.parseInt(param.get("time")),
                param.get("location") );
    }

//    /**
//     * 根据车辆id 修改durable值
//     */
//    @RequestMapping(value = "vehicle/updateVehicleDurableById",method = RequestMethod.POST)
//    public String updateVehicleDurableById(@RequestParam(value = "id", required = true)  String id){
//

    /**
     * 根据车辆id 修改durable值
     */
    @RequestMapping(value = "vehicle/updateVehicleDurableById",method = RequestMethod.POST)
    public String updateVehicleDurableById(@RequestBody Map<String,String> param){
        return vehicleService.updateVehicleDurableById(param.get("vehicleId"));
    }



    /**
     * 根据车辆id 修改durable值
     */
    @RequestMapping(value = "vehicle/updateVehicleBatteryById",method = RequestMethod.POST)
    public String updateVehicleBatteryById(@RequestBody Map<String,String> param){
        return vehicleService.updateVehicleBatteryById(param.get("vehicleId"));
    }
}
