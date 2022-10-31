package com.glasgow.tapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagePathController {
    @RequestMapping("/")
    public String loadIndex(){
        return "index";
    }
    //二级页面
    @RequestMapping("/page/{pageName}")
    public String loadPage(@PathVariable String pageName){
        return pageName;
    }
    //三级页面
    @RequestMapping("/page/{fileName}/{pageName}")
    public String loadPage(@PathVariable String fileName, @PathVariable String pageName){
        return fileName+"/"+pageName;
    }
}
