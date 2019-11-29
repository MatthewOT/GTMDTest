package com.gtmdtest.platform.controller;

import com.gtmdtest.platform.model.vo.BaseResponseVO;
import com.gtmdtest.platform.service.starCaseService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-11-29 12:20
 **/
@RestController
public class starCaseController {

    @Resource
    starCaseService starCaseService;

    public BaseResponseVO addStarCase(){
        return null;
    }

    public BaseResponseVO deleteStarCase(){
        return null;
    }

    public BaseResponseVO updateStarCase(){
        return null;
    }

    public BaseResponseVO getStarCaseById(){
        return null;
    }

    public BaseResponseVO getAllStarCase(){
        return null;
    }

}
