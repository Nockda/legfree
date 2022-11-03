package com.glasgow.tapp.controller;


import com.glasgow.tapp.common.utils.ResponseModel;
import com.glasgow.tapp.pojo.Vehicle;
import com.glasgow.tapp.service.UserService;
import com.glasgow.tapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController extends SuperController{


    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     *查询账户余额
     */
    @RequestMapping(value = "user/getUserMoneyByUserName",method = RequestMethod.GET)
    public Map getUserMoneyByUserName(){

       return userServiceImpl.getUserMoneyByUserName(String.valueOf(getCurrentUser().getUserName()));
    }


}
