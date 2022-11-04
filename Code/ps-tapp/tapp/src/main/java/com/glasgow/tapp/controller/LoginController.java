package com.glasgow.tapp.controller;

import com.glasgow.tapp.common.utils.ResponseModel;


import com.glasgow.tapp.pojo.User;
import com.glasgow.tapp.pojo.Vehicle;
import com.glasgow.tapp.service.UserService;

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
import java.util.List;
import java.util.Map;


@RestController
public class LoginController extends SuperController {
    // extends SuperController

    @Autowired
    private UserService userService;



    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(HttpServletResponse response) throws IOException {
        User user = getCurrentUser();
//        if(user==null){
        return new ModelAndView("/user/login");
//        }else {
//        response.sendRedirect("index");
//        return new ModelAndView("index");
//        }
    }


    @RequestMapping("/toVehicle")
    public ModelAndView vehicle_info(HttpServletResponse response) throws IOException {
        User user=getCurrentUser();
//        if(user==null){
        return new ModelAndView("/user/consumer");
//        }else {
//        response.sendRedirect("index");
//        return new ModelAndView("index");
//        }
    }


    @RequestMapping("/toLocationVehicle")
    public ModelAndView vehicle_location_info(HttpServletResponse response) throws IOException {
        User user = getCurrentUser();
//        if (user!=null){
        return new ModelAndView("/test/location");
//        }else {
//            return new ModelAndView("/user/login");
//        }
    }

    @RequestMapping("/toLocationInfoVehicle/{location}")
    public ModelAndView vehicle_location_info_location(@PathVariable String location,HttpServletRequest request) {
        User user = getCurrentUser();
//        if (user!=null){
        request.setAttribute("locationInfo",location);
        return new ModelAndView("/test/locationInfo");
//        }else {
//            return new ModelAndView("/user/login");
//        }
    }

    /**
     * 登录方法
     *
     * @param loginParam {
     *                   userAccount,
     *                   password,
     *                   code
     *                   }
     * @param request
     * @return
     */
//    @RequestMapping("/doLogin")
//    @ResponseBody
    @PostMapping("/doLogin")
    public ResponseModel login(@RequestBody Map<String, Object> loginParam, HttpServletRequest request) {
        int state = 0;
        String message = "";
        String userAccount = (String) loginParam.get("userAccount");
        String password = (String) loginParam.get("password");
        String code = (String) loginParam.get("code");
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        UsernamePasswordToken token = new UsernamePasswordToken(userAccount, password);
        try {
            currentUser.login(token);
            session.setAttribute("sessionUser", userService.getUserByAccout(userAccount));
            session.removeAttribute("sessionSecurityCode");
            state = 1;
            message = userService.getUserByAccout(userAccount).getLevel().toString();
            System.out.println(state);
            System.out.println(message);
        } catch (UnknownAccountException exception) {
            System.out.println("用户不存在！");
            message = "用户不存在！";
        } catch (IncorrectCredentialsException exception) {
            System.out.println("密码错误！");
            message = "密码错误！";
        }

        return new ResponseModel(state, message);
    }

    @RequestMapping("/doLogout")
    public ModelAndView logout(HttpServletRequest request) {
        // shiro管理的session
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.removeAttribute("sessionUser");
        // shiro销毁登录
        currentUser.logout();
        return new ModelAndView("/home/login");
    }

    @GetMapping("/test")
    public String test() {


        return "00001";
    }


    /*
     跳转界面
     */

    @RequestMapping("/toUserLogin")
    public ModelAndView toUserLogin (HttpServletResponse response) throws IOException {
        User user=getCurrentUser();
//        if(user==null){
        return new ModelAndView("/test/login");
//        }else {
//        response.sendRedirect("index");
//        return new ModelAndView("index");
//        }
    }



    @RequestMapping("/toVehicleInfo")
    public ModelAndView vehicleInfo(HttpServletResponse response) throws IOException {
        User user=getCurrentUser();
//        if(user==null){
        return new ModelAndView("/test/vehicle");
//        }else {
//        response.sendRedirect("index");
//        return new ModelAndView("index");
//        }
    }


    @RequestMapping("/orderInfo")
    public ModelAndView setVehicleInfo(HttpServletResponse response) throws IOException {
        User user=getCurrentUser();
//        if(user==null){
        return new ModelAndView("/test/order");
//        }else {
//        response.sendRedirect("index");
//        return new ModelAndView("index");
//        }
    }


    @RequestMapping("/operator")
    public ModelAndView operatorInfo(HttpServletResponse response) throws IOException {
        User user=getCurrentUser();
//        if(user==null){
        return new ModelAndView("/test/operator");
//        }else {
//        response.sendRedirect("index");
//        return new ModelAndView("index");
//        }
    }


    @RequestMapping("/administrator")
    public ModelAndView administratorInfo(HttpServletResponse response) throws IOException {
        User user=getCurrentUser();
//        if(user==null){
        return new ModelAndView("/test/administrator");
//        }else {
//        response.sendRedirect("index");
//        return new ModelAndView("index");
//        }
    }
}
