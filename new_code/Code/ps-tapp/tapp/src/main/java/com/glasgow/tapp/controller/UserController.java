package com.glasgow.tapp.controller;


import com.glasgow.tapp.common.utils.ResponseModel;
import com.glasgow.tapp.dao.UserDao;
import com.glasgow.tapp.pojo.Order;
import com.glasgow.tapp.pojo.User;
import com.glasgow.tapp.pojo.Vehicle;
import com.glasgow.tapp.service.UserService;
import com.glasgow.tapp.service.VehicleService;
import com.glasgow.tapp.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     *查询账户余额
     */
    @RequestMapping("user/getUserMoneyByUserName")
    public int getUserMoneyByUserName(@RequestParam(value = "userName", required = true)  String userName){
       return userServiceImpl.getUserMoneyByUserName(userName);
    }



    @RequestMapping ("/toRenting/{user}")
    public ModelAndView toRenting(@PathVariable  String user, HttpServletRequest request)  {

        String tmp[] = user.split(",");
        String order_id = tmp[0];
        String user_id = tmp[1];
        String vehicle = tmp[2];
        String vehicle_fee = tmp[3];
        String vehicle_location = tmp[4];

        request.setAttribute("orderId", order_id);

        request.setAttribute("userId", user_id);
        request.setAttribute("vehicleId", vehicle);

        request.setAttribute("vehicleFee", vehicle_fee);
        request.setAttribute("vehicleLocation", vehicle_location);

//            System.out.println("renting");
        return new ModelAndView("/user/renting");
    }

    @RequestMapping ("/toRentingHis/{user_id}")
        public ModelAndView toRentingHis(@PathVariable  String user_id, HttpServletRequest request)  {


            request.setAttribute("userId", user_id);

//            System.out.println("renting");
        return new ModelAndView("/user/renting_history");
    }

    @RequestMapping ("/toReporting/{user_id}")
    public ModelAndView toReporting(@PathVariable  String user_id, HttpServletRequest request)  {

        String tmp[] = user_id.split(",");
        String user = tmp[0];
        String vehicle_no = tmp[1];
        request.setAttribute("userId", user);
        request.setAttribute("vehicleNo", vehicle_no);

//            System.out.println("renting");
        return new ModelAndView("/user/reporting");
    }

    @RequestMapping ("/toMoving/{vehicle_no}")
    public ModelAndView toMoving(@PathVariable  String vehicle_no, HttpServletRequest request)  {

        String tmp[] = vehicle_no.split(",");
        String vehicle = tmp[0];
        String location = tmp[1];
        String userId = tmp[2];
        request.setAttribute("vehicleNo", vehicle);
        request.setAttribute("vehicleLocation", location);
        request.setAttribute("user", userId);
//            System.out.println("renting");
        return new ModelAndView("/user/moving");
    }


}
