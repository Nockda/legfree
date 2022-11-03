package com.glasgow.tapp.controller;

import com.glasgow.tapp.pojo.ErrorInfo;
import com.glasgow.tapp.pojo.Vehicle;
import com.glasgow.tapp.service.ErrorInfoService;
import com.glasgow.tapp.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Hongbin BAO
 * @Date 2022/10/31 00:19
 */
@ResponseBody
@RestController
@Slf4j
public class ErrorInfoController extends SuperController {

    @Autowired
    private ErrorInfoService errorInfoService;


    /**
     *操作员查询 报告车辆详情
     */
    @RequestMapping(value = "errorInfo/getErrorInfo",method = RequestMethod.GET)
    public List<ErrorInfo> getErrorInfo(){
        return errorInfoService.getErrorInfo();
    }

    /**
     * 新增错误信息
     */
    @RequestMapping(value = "errorInfo/insertErrorInfo",method = RequestMethod.POST)
    public String insertErrorInfo(@RequestBody Map<String,String> param)
    {
        return errorInfoService.insertErrorInfo(param.get("vehicleId"),param.get("message"),String.valueOf(getCurrentUser().getUserId()));
    }
}
