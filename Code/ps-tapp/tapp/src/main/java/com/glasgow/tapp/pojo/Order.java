package com.glasgow.tapp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Hongbin BAO
 * @Date 2022/10/16 22:06
 */
@Data
public class Order  implements Serializable {


    private String orderId;

    private String userId;

    private String vehicleId;

    private int time;

    private int orderMoney;

    private String state;


    private Date createTime;





}
