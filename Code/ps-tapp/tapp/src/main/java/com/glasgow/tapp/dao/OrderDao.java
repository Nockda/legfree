package com.glasgow.tapp.dao;

import com.glasgow.tapp.pojo.Order;
import com.glasgow.tapp.pojo.Vehicle;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Hongbin BAO
 * @Date 2022/10/16 22:04
 */


@Mapper
@Repository
public interface OrderDao {
    List<Order> getOrderInfo();



    List<Order> getOrderInfoByUserId(String userId);

    int insertOrderInfo(Map map);

    int updateOrderStateByOrderId(String orderId);

    Order getOrderInfoByOrderId(String orderId);
}
