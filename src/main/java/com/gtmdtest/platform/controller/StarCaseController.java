package com.gtmdtest.platform.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gtmdtest.platform.model.entity.StarCase;
import com.gtmdtest.platform.model.vo.BaseResponseVO;
import com.gtmdtest.platform.service.StarCaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-11-29 12:20
 **/
@RequestMapping("/starcase")
@RestController
public class StarCaseController {

    @Resource
    private StarCaseService StarCaseService;


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

    public BaseResponseVO getAllStarCase(@RequestParam(value = "pn",defaultValue = "1") Integer pageNumber){
        //分页
        PageHelper.startPage(pageNumber,8);
        List<StarCase> starCases = StarCaseService.getAllStarCase();
        PageInfo<StarCase> pageInfo = new PageInfo<>(starCases,8);
        return BaseResponseVO.success(pageInfo);
    }

}
