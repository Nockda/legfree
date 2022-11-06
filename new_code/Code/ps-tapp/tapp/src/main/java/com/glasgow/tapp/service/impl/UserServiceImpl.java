package com.glasgow.tapp.service.impl;

import com.glasgow.tapp.common.utils.SaltUtil;
import com.glasgow.tapp.dao.UserDao;
import com.glasgow.tapp.pojo.User;
import com.glasgow.tapp.pojo.Vehicle;
import com.glasgow.tapp.service.UserService;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Map<String,Object> searchUser(String searchValue, String time1, String time2, int pageNum, int itemPerPage) {
        String limit=((pageNum-1)*itemPerPage)+","+itemPerPage;
        List<User>userList=userDao.selectUser(searchValue,time1,time2,limit);
        int num=userDao.searchUserReturnNum(searchValue,time1,time2);
        Map<String,Object> result=new HashMap<>();
        result.put("userList",userList);
        result.put("num",num);
        return result;
    }

    @Override
    public User getUserById(int userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public User getUserByAccout(String account) {
        return userDao.selectUserByAccount(account);
    }

    @Override
    public int addUser(User user) {
        //判断用户名称是否已经存在
        if(userDao.selectUserByAccount(user.getUserName())==null){
            //生成加密盐
            String salt= SaltUtil.getSalt(8);
            user.setSalt(salt);
            //MD5将密码加密（参数三：散列次数）
            Md5Hash md5Hash=new Md5Hash(user.getPassword(),salt,1024);
            user.setPassword(md5Hash.toHex());
            return userDao.insertUser(user);
        }else {
            return -1;
        }
    }

    @Override
    public int modifyUser(User user) {
        String password= user.getPassword();
        //密码为空时代表不修改密码，仅修改密码时进行该操作
        if(password!=null&&!(String.valueOf(password).equals(""))){
            //生成加密盐
            String salt= SaltUtil.getSalt(8);
            user.setSalt(salt);
            //MD5将密码加密（参数三：散列次数）
            Md5Hash md5Hash=new Md5Hash(user.getPassword(),salt,1024);
            user.setPassword(md5Hash.toHex());
        }
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(Integer[] userIds) {
        return userDao.deleteUser(userIds);
    }


    /**
     * 根据用户名查找用户账户余额
     * @param userName
     * @return
     */
    public Map getUserMoneyByUserName(String userName ){
        int money;
        money = userDao.getUserMoneyByUserName(userName);
        Map<String,String> moneyMap = new HashMap<>();
        moneyMap.put("money",String.valueOf(money));
        return moneyMap;
    }


    public String updateUserMoneyByUserId(String money ,String userId) {

        int userCurrentMoney = userDao.getUserMoneyByUserId(userId);
        int userMoney = userCurrentMoney+Integer.parseInt(money);
        userDao.updateUserMoneyByUserId(userMoney,userId);
        return "success";
    }
}
