package com.glasgow.tapp.controller;


import com.glasgow.tapp.common.utils.ResponseModel;
import com.glasgow.tapp.pojo.Vehicle;
import com.glasgow.tapp.service.UserService;
import com.glasgow.tapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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


}
