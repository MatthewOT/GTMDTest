package com.gtmdtest.platform.controller;

import com.gtmdtest.platform.service.usersService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-11-29 12:19
 **/
@RestController
public class usersController {

    @Resource
    usersService usersService;
}
