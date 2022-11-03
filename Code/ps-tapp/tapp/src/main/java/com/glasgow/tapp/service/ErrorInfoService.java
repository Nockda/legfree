package com.glasgow.tapp.service;

import com.glasgow.tapp.dao.ErrorInfoDao;
import com.glasgow.tapp.dao.VehicleDao;
import com.glasgow.tapp.pojo.ErrorInfo;
import com.glasgow.tapp.pojo.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Hongbin BAO
 * @Date 2022/10/31 00:28
 */
@Service
public class ErrorInfoService {


    @Autowired
    private ErrorInfoDao errorInfoDao;
    public List<ErrorInfo> getErrorInfo(){
        List<ErrorInfo> errorInfoList = new ArrayList<>();
        errorInfoList = errorInfoDao.getErrorInfo();
        return errorInfoList;
    }

    public String insertErrorInfo(String vehicleId,String message,String userId) {

        String errorId = "";
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            errorId += String.valueOf(random.nextInt(10));
        }


        Map errorInfoMap = new HashMap();
        errorInfoMap.put("errorId",errorId);
        errorInfoMap.put("vehicleId",vehicleId);
        errorInfoMap.put("userId",userId);
        errorInfoMap.put("message",message);

        errorInfoDao.insertErrorInfo(errorInfoMap);


        return "success";
    }
}
