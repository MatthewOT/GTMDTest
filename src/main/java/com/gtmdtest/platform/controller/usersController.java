package com.gtmdtest.platform.controller;

import com.gtmdtest.platform.model.vo.BaseResponseVO;
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

    public BaseResponseVO addUser(){
        return null;
    }

    public BaseResponseVO deleteUser(){
        return null;
    }

    public BaseResponseVO updateUser(){
        return null;
    }

    public BaseResponseVO getUserById(){
        return null;
    }

    public BaseResponseVO getAllUsers(){
        return null;
    }
}
