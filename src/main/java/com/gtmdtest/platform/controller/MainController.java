package com.gtmdtest.platform.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-11-21 21:35
 **/
@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private static final Map<String,String> SYSTEM_NAME = new HashMap(){{
        put("eSaler","电销");
        put("sunflower","直销");
        put("publicService","公共服务");
        put("agency","代理商");
        put("finance","财务");
        put("afterMarket","车后服务");
    }};


    @GetMapping("/")
    public String hello(){
        return "html/index";
    }

    @GetMapping("listPage")
    public String listPage(@RequestParam(value = "pageType",required = false) String pageType,
                           Model model){
        model.addAttribute("pageType",pageType);
        model.addAttribute("systemName",SYSTEM_NAME.get(pageType));
        return "html/listpage";
    }

    @GetMapping("/apiPage")
    public String apiPage(){
        return "html/apipage";
    }


    @GetMapping("/errorPage")
    public String errorPage(){
        return "html/500";
    }

    @GetMapping("/singleDiff")
    public String singleDiff(){
        return "html/singlediff";
    }

    @GetMapping("manyDiff")
    public String manyDiff(){
        return "html/manydiff";
    }

}
