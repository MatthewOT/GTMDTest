package com.gtmdtest.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-11-21 21:35
 **/
@Controller
public class MainController {

    @GetMapping("/")
    public String hello(){
        return "html/index";
    }

    @GetMapping("listPage")
    public String listPage(@RequestParam(value = "pageType",required = false) String pageType,
                           Model model){
        model.addAttribute("pageType",pageType);
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

    @GetMapping("/demo")
    public String demo(){
        return "html/index3";
    }

    @GetMapping("/demoPage")
    public String demoPage(){
        return "html/form-basic";
    }

    @GetMapping("/demoPage2")
    public String demoPage2(){
        return "html/form-wizard";
    }
}
