package com.glasgow.tapp.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * Vehicle class
 *
 * @author Hongbin BAO
 * @Date 2022/10/13 14:49
 */
@Data
public class Vehicle implements Serializable {

    private String vehicleId;

    private String vehicleName;

    private String vehicleLocation;

    private int vehicleFree;

    private int vehicleDurable;

    private int vehicleBattery;

    private int vehicleState;



}
