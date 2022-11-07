package com.glasgow.tapp.common.shiro;

import com.glasgow.tapp.pojo.User;
import com.glasgow.tapp.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;


/**
 * SimSystem的自定义realm
 * 从数据库获取认证和授权
 */
public class SimSystemRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    /**
     * 用户认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userAccount= (String) token.getPrincipal();
        //从数据库获取用户信息
        User user=userService.getUserByAccout(userAccount);
        if (user!=null){
            //参数一：正确的用户id //参数二：正确的密码  //参数三：加密盐  //参数四：当前realm的名称
            SimpleAuthenticationInfo authenticationInfo=
                    new SimpleAuthenticationInfo
                            (user.getUserId(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());
            return authenticationInfo;
        }
        return null;
    }

    /**
     * 用户授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户信息
//        int primaryPrincipal= (int) principalCollection.getPrimaryPrincipal();
//        //从数据库获取用户权限等级信息
//        List<Role> roleList=roleService.getRolesByUserId(primaryPrincipal);
//        if (!CollectionUtils.isEmpty(roleList)){
//            SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
//            for (Role role:roleList) {
//                authorizationInfo.addRole(role.getRoleName());
//            }
//            return authorizationInfo;
//        }
        return null;
    }
}
