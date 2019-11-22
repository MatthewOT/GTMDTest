package com.gtmdtest.platform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
