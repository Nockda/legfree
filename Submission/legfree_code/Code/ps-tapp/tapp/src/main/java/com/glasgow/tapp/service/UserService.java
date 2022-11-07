package com.glasgow.tapp.service;



import com.glasgow.tapp.pojo.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 查找用户信息并分页
     * @param searchValue 检索词，用户id或用户名
     * @param time1 时间1，该时间及以前
     * @param time2 时间2，该时间及以后
     * @param pageNum 页码
     * @param itemPerPage 每页展示个数
     * @return List<User>
     */
    public Map<String,Object> searchUser(String searchValue, String time1, String time2, int pageNum, int itemPerPage);

    /**
     * 按照用户id查找
     * @param userId 用户id
     * @return User
     */
    public User getUserById(int userId);


    /**
     * 根据用户名或ID查找用户
     * @param account
     * @return
     */
    public User getUserByAccout(String account);

    /**
     * 新增用户
     * @param user
     * @return 新增个数
     */
    public int addUser(User user);

    /**
     * 修改用户
     * @param user
     * @return 修改个数
     */
    public int modifyUser(User user);

    /**
     * 删除用户
     * @param userIds 用户id
     * @return 删除个数
     */
    public int deleteUser(Integer[] userIds);



}
