package com.glasgow.tapp.dao;

import com.glasgow.tapp.pojo.ErrorInfo;
import com.glasgow.tapp.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Hongbin BAO
 * @Date 2022/10/31 00:33
 */
@Mapper
@Repository
public interface ErrorInfoDao {

    List<ErrorInfo> getErrorInfo();


    int insertErrorInfo(Map map);
}
