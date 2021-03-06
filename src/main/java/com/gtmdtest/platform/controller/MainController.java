package com.gtmdtest.platform.controller;

import com.gtmdtest.platform.common.OkHttpUtil;
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
        put(1,"直销");
        put(2,"公共服务");
        put(3,"代理商");
        put(4,"电销");
        put(5,"财务");
        put(6,"车后服务");
    }};


    @GetMapping("/")
    public String hello(){
        return "html/index";
    }

    @GetMapping("listPage")
    public String listPage(@RequestParam(value = "pageType",required = false) Integer pageType,
                           Model model){
        model.addAttribute("pageType",pageType);
        model.addAttribute("systemName",SYSTEM_NAME.get(pageType));
        return "html/listpage";
    }

    @GetMapping("/apiPage")
    public String apiPage(){
        return "html/apipage";
    }

    @GetMapping("/caseAdmin")
    public String caseAdminPage(){
        return "html/caseAdmin";
    }

    @GetMapping("/errorPage")
    public String errorPage(){
        return "html/404";
    }

    @GetMapping("/singleDiff")
    public String singleDiff(){
        return "html/singlediff";
    }

    @GetMapping("/manyDiff")
    public String manyDiff(){
        return "html/manydiff";
    }

    @GetMapping("/httpMock")
    public String httpMock(){
        return "html/404";
    }

    @GetMapping("/dubboMock")
    public String dubboMock(){
        return "html/404";
    }

    @GetMapping("/kafkaMock")
    public String kafkaMock(){
        return "html/404";
    }

}
