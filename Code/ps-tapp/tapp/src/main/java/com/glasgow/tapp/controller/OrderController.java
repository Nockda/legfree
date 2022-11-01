package com.glasgow.tapp.controller;

import com.glasgow.tapp.pojo.Order;
import com.glasgow.tapp.service.OrderService;
import com.glasgow.tapp.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hongbin BAO
 * @Date 2022/10/16 22:05
 */



@ResponseBody
@RestController
@Slf4j
public class OrderController extends SuperController{
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private OrderService orderService;

    /**
     * 查询订单
     */
    @RequestMapping(value = "order/getOrderInfoByUserId",method = RequestMethod.POST)
    public List<Order> getUserMoneyByUserName(){
        return orderService.getOrderInfoByUserId(String.valueOf(getCurrentUser().getUserId()));
    }


    /**
     * 更改订单状态
     */
    @RequestMapping(value = "order/updateOrderStateByOrderId",method = RequestMethod.POST)
    public Order updateOrderStateByOrderId(@RequestParam(value = "orderId", required = true)  String orderId){
        return orderService.updateOrderStateByOrderId(orderId);
    }
}
