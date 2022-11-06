package com.glasgow.tapp.controller;

import com.glasgow.tapp.common.utils.ResponseModel;
import com.glasgow.tapp.pojo.Order;
import com.glasgow.tapp.pojo.User;
import com.glasgow.tapp.pojo.Vehicle;
import com.glasgow.tapp.service.UserService;
import com.glasgow.tapp.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.lang.Integer.parseInt;

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


    @RequestMapping(value = "/order/getAllOrder",method = RequestMethod.GET)
    public List<Order> getAllOrderInfo(){
        return vehicleService.getAllOrderInfo();
    }

    @RequestMapping("/order/getAllOrderByDate/{date_time}")
    public List<Order> login(@PathVariable  String date_time, HttpServletRequest request) {
        String tmp[] = date_time.split(",");
        String date_front = tmp[0];
        String date_back = tmp[1];
        System.out.println(date_front+date_back);
        List<Order> res =  vehicleService.getAllOrderInfoByDate(date_front,date_back);
        return res;
    }

    @PostMapping("/errorInfo/getErrorInfo")
    public ResponseModel login(@RequestBody Map<String, Object> param, HttpServletRequest request) {
        String userId = (String) param.get("userId");
        String vehicleId = (String) param.get("vehicleId");
        String message = (String) param.get("message");
        Boolean res = false;
        String sts = "failed";
        try {
            res =  vehicleService.insertErrorInfo(userId,vehicleId,message);
            vehicleService.updateVehicleInfoSts(vehicleId,message);
            if (res){
                sts = "success";
            }
            System.out.println(res);

        } catch (UnknownAccountException exception) {
            System.out.println("用户不存在！");
            message = "用户不存在！";
        } catch (IncorrectCredentialsException exception) {
            System.out.println("密码错误！");
            message = "密码错误！";
        }

        return new ResponseModel(sts);
    }

    @RequestMapping("/vehicle/doVehicle/{vehicle_id}")
    public String doVehicle(@PathVariable  String vehicle_id, HttpServletRequest request) {
        String tmp[] = vehicle_id.split(",");
        String vehicleId = tmp[0];
        String opt = tmp[1];
        System.out.println(vehicleId+opt);
        String sts = "failed";
        if("c".equals(opt)){
            vehicleService.chargeVehicle(vehicleId);
            sts = "success";
        }else if("r".equals(opt)){
            vehicleService.repairVehicle(vehicleId);
            sts = "success";
        }

        return sts;
    }

    @RequestMapping("/vehicle/moveVehicle/{vehicle_id}")
    public String moveVehicle(@PathVariable  String vehicle_id, HttpServletRequest request) {
        String tmp[] = vehicle_id.split(",");
        String vehicleId = tmp[0];
        String location = tmp[1];
        System.out.println(vehicleId+location);
        String sts = "failed";
        Boolean res =  vehicleService.moveVehicle(vehicleId, location);
        if(res){
            sts = "success";
        }


        return sts;
    }



    @PostMapping("/rentVehicle")
    public ResponseModel rentVehicle(@RequestBody Map<String, Object> param, HttpServletRequest request) {
        String user_id = (String) param.get("userId");
        String vehicle_id = (String) param.get("vehicleId");
        int fee = (int) param.get("vehicleFee");
        String vehicle_location = (String) param.get("vehicleLocation");

        Boolean res = false;
        String sts = "failed";
        Date date=new Date();//此时date为当前的时间
        SimpleDateFormat dateFormat=new SimpleDateFormat("YYYYMMddHHmmss");
        String order_id = dateFormat.format(date);
            res =  vehicleService.insertOriginOrderInfo(order_id,user_id,vehicle_id,fee,vehicle_location);
            vehicleService.updateVehicleInfoStsToInUse(vehicle_id);
            if (res){
                sts = order_id;
            }
            System.out.println(res);

        return new ResponseModel(sts);
    }

    @PostMapping("/updateOrderInfoAgain")
    public ResponseModel updateOrderInfoAgain(@RequestBody Map<String, Object> param, HttpServletRequest request) {

        String order_id = (String) param.get("orderId");
        String vehicle_id = (String) param.get("vehicleId");
        String to_location = (String) param.get("destination");
        Random random = new Random();
        //int time = random.nextInt(10);

        int time =parseInt(param.get("time").toString());
        int battery = random.nextInt(15)%5+5;
        int broken = random.nextInt(8);
//        int battery = time;
//        int broken = time;

        Boolean res = false;
        String sts = "failed";
        res =  vehicleService.updateOrderInfoForReturn(order_id,to_location,time,vehicle_id);
        vehicleService.updateVehicleAfterReturn(vehicle_id,battery,broken,to_location);
        if (res){
            sts = "success";
        }
        System.out.println(res);

        return new ResponseModel(sts);
    }

    @PostMapping("/payBill")
    public ResponseModel payBill(@RequestBody Map<String, Object> param, HttpServletRequest request) {

        String order_id = (String) param.get("orderId");
        String user_id = (String) param.get("userId");

        Boolean res = false;
        String sts = "failed";
        res =  vehicleService.updateOrderInfoPaid(order_id);
        vehicleService.updateUserAccount(user_id,order_id);
        if (res){
            sts = "success";
        }
        System.out.println(res);

        return new ResponseModel(sts);
    }


    @RequestMapping("/getOrderInfoByUserName/{user_id}")
    public List<Order> getOrderInfoByUserName(@PathVariable  String user_id, HttpServletRequest request) {


        return vehicleService.getOrderInfoByUserName(user_id);
    }

    @RequestMapping("/getStatistics")
    public int[] getStatistics() {

        int[] tmp = new int[6];

        tmp[0] = vehicleService.getNormalVec();
        tmp[1] = vehicleService.getBrokenVec();
        tmp[2] = vehicleService.getLowBatteryVec();
        tmp[3] = vehicleService.getInUseVec();
        tmp[4] = vehicleService.getBrokenReport();
        tmp[5] = vehicleService.getLowBatteryReport();


        System.out.println(tmp);

        return tmp;
    }

}
