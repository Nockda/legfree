package com.glasgow.tapp.common.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 */
@Configuration
public class ShiroConfig {

    //创建ShiroFilter，用于拦截所有请求
    @Bean(name="shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String, Filter> filters=new LinkedHashMap<>();
        filters.put("roles",new SimRolesAuthorizationFilter());
        //配置拦截器
        shiroFilterFactoryBean.setFilters(filters);
        //配置系统受限资源
        //配置系统公共资源
        /**
         * anon 可匿名访问
         * authc 需要登录，未登录自动跳转默认登录页面
         * logout 登出过滤器
         * 更多配置参考官网
         */
        Map<String,String> filterChainDefinitionMap=new HashMap<>();
        filterChainDefinitionMap.put("/logout","logout");//登出
        //系统设置页码仅超管和管理员可访问
        filterChainDefinitionMap.put("/page/system/**","authc,roles[sa,admin]");// 指定认证才可访问子页面
        filterChainDefinitionMap.put("/static/**","anon");// 静态资源不需要拦截
        filterChainDefinitionMap.put("/**","anon");// 静态资源不需要拦截
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //配置默认登陆url
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        return shiroFilterFactoryBean;
    }
    //创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        //给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }
    //创建自定义realm
    @Bean
    public Realm getRealm(){
        SimSystemRealm realm=new SimSystemRealm();
        //修改realm凭证校验匹配器
        HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
        //设置加密算法为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //设置哈希散列次数
        credentialsMatcher.setHashIterations(1024);
        realm.setCredentialsMatcher(credentialsMatcher);
        return realm;
    }


}
