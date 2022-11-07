package com.glasgow.tapp.controller;

import com.glasgow.tapp.pojo.ErrorInfo;
import com.glasgow.tapp.pojo.Vehicle;
import com.glasgow.tapp.service.ErrorInfoService;
import com.glasgow.tapp.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hongbin BAO
 * @Date 2022/10/31 00:19
 */
@ResponseBody
@RestController
@Slf4j
public class ErrorInfoController {

    @Autowired
    private ErrorInfoService errorInfoService;


    /**
     *查询可用车辆
     */
    @RequestMapping(value = "errorInfo/getErrorInfo",method = RequestMethod.GET)
    public List<ErrorInfo> getErrorInfo(){
        return errorInfoService.getErrorInfo();
    }


}
