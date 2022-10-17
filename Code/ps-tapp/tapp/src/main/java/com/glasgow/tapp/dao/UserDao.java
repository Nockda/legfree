package com.glasgow.tapp.dao;

import com.glasgow.tapp.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 查找用户信息并分页
     * @param searchValue 检索词，用户id或用户名
     * @param time1 时间1，该时间及以前
     * @param time2 时间2，该时间及以后
     * @param limit 分页
     * @return List<User>
     */
    List<User> selectUser(String searchValue, String time1, String time2, String limit);

    /**
     * 查找用户返回数量
     * @param searchValue 检索词，用户id或用户名
     * @param time1 时间1，该时间及以前
     * @param time2 时间2，该时间及以后
     * @return Integer
     */
    int searchUserReturnNum(String searchValue,String time1,String time2);

    /**
     * 按照用户id查找
     * @param userId 用户id
     * @return User
     */
    User selectUserById(Integer userId);

    /**
     * 根据用户名或ID查找用户
     * @param account
     * @return
     */
    User selectUserByAccount(String account);

    /**
     * 通过用户名密码查找用户(用于登录功能)**已作废
     * @param account 用户名或ID
     * @param password 密码
     * @return List<User>
     */
    List<User> selectUserByAccountPassword(String account,String password);

    /**
     * 新增用户
     * @param user
     * @return 新增个数
     */
    int insertUser(User user);

    /**
     * 修改用户
     * @param user
     * @return 修改个数
     */
    int updateUser(User user);

    /**
     * 删除用户
     * @param userIds 用户id
     * @return 删除个数
     */
    int deleteUser(Integer[] userIds);

    int getUserMoneyByUserName(String userName);

    int updateUserMoneyByUserId(int money, String userId);

    int getUserMoneyByUserId(String userId);


    /**
     * 查询可用车车辆
     */
}
