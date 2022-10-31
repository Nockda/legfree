package com.glasgow.tapp.service;

import com.glasgow.tapp.dao.ErrorInfoDao;
import com.glasgow.tapp.dao.VehicleDao;
import com.glasgow.tapp.pojo.ErrorInfo;
import com.glasgow.tapp.pojo.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

}
