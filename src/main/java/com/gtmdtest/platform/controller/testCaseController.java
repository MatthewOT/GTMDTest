package com.gtmdtest.platform.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gtmdtest.platform.model.entity.TestCase;
import com.gtmdtest.platform.model.vo.BaseResponseVO;
import com.gtmdtest.platform.service.testCaseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-11-29 12:20
 **/
@RequestMapping("/testcase")
@RestController
public class testCaseController {

    @Resource
    testCaseService testCaseService;

    @PostMapping("/add")
    public BaseResponseVO addTestCase(){
        return null;
    }

    @GetMapping("/deleteById")
    public BaseResponseVO deleteTestCase(){
        return null;
    }

    @PostMapping("/update")
    public BaseResponseVO updateTestCase(){
        return null;
    }

    @GetMapping("/getById")
    public BaseResponseVO getTestCaseById(){
        return null;
    }

    @GetMapping("/getAll")
    public BaseResponseVO getAllTestCase(@RequestParam(value = "pn",defaultValue = "1") Integer pageNumber){
        //分页
        PageHelper.startPage(pageNumber,5);
        List<TestCase> testCases = testCaseService.getAllTestCase();
        PageInfo<TestCase> pageInfo = new PageInfo<>(testCases,5);
        return BaseResponseVO.success(pageInfo);
    }

    @GetMapping("/getBySystemType")
    public BaseResponseVO getAllTestCaseBySystemType(@RequestParam(value = "pn",defaultValue = "1") Integer pageNumber,
                                                     @RequestParam(value = "systemType",defaultValue = "1")Integer systemType){

        PageHelper.startPage(pageNumber,5);
        List<TestCase> testCases = testCaseService.getTestCaseBySystemType(systemType);
        PageInfo<TestCase> pageInfo = new PageInfo<>(testCases,5);
        return BaseResponseVO.success(pageInfo);
    }
}
