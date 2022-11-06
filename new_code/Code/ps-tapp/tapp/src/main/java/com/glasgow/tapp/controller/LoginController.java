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
        User user=getCurrentUser();
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



    @RequestMapping ("/toManager/{user_id}")
    public ModelAndView toManager(@PathVariable  String user_id, HttpServletRequest request)  {
        String tmp[]= user_id.split(",");
        request.setAttribute("userId", tmp[0]);
        request.setAttribute("tmp_1", tmp[1]);
        request.setAttribute("tmp_2", tmp[2]);


//            System.out.println("renting");
        return new ModelAndView("/user/manager");
    }

    @RequestMapping ("/toOperator/{user_id}")
    public ModelAndView toOperator(@PathVariable  String user_id, HttpServletRequest request)  {


        request.setAttribute("userId", user_id);

//            System.out.println("renting");
        return new ModelAndView("/user/operator");
    }

    @RequestMapping ("/toConsumer/{user_id}")
    public ModelAndView toConsumer(@PathVariable  String user_id, HttpServletRequest request)  {

        request.setAttribute("userId", user_id);

//            System.out.println("renting");
        return new ModelAndView("/user/consumer");
    }


    @RequestMapping("/moneyInfo")
    public ModelAndView setVehicleInfo(HttpServletResponse response) throws IOException {
        User user=getCurrentUser();
//        if(user==null){
        return new ModelAndView("/user/money");
//        }else {
//        response.sendRedirect("index");
//        return new ModelAndView("index");
//        }
    }

}
