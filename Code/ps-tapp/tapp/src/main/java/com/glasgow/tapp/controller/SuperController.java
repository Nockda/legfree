package com.glasgow.tapp.controller;


import com.glasgow.tapp.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * SuperController包含各个Controller可能所需的各种方法
 */
public class SuperController {

    public User getCurrentUser(){
        Subject subject= SecurityUtils.getSubject();
        Session session=subject.getSession();
        User user= (User) session.getAttribute("sessionUser");
        return user;
    }

    /**
     * 请求参数处理公用方法
     *
     * @param request HttpServletRequest
     * @return returnMap
     */
    public Map<String, String> paramValueDispose(HttpServletRequest request) {
        Map<String, String> returnMap = new HashMap<String, String>();
        Map properties = request.getParameterMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }
}
