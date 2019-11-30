package com.gtmdtest.platform.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gtmdtest.platform.model.entity.TestCase;
import com.gtmdtest.platform.model.vo.BaseResponseVO;
import com.gtmdtest.platform.service.testCaseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-11-29 12:20
 **/
@RequestMapping("/testcase")
@RestController
public class testCaseController {

    private static final Map<String,String> SYSTEM_NAME = new HashMap(){{
        put("eSaler","电销");
        put("sunflower","直销");
        put("publicService","公共服务");
        put("agency","代理商");
        put("finance","财务");
        put("afterMarket","车后服务");
    }};

    @Resource
    testCaseService testCaseService;

    @PostMapping("/add")
    public BaseResponseVO addTestCase(@RequestParam(value = "systemType")Integer systemType,
                                      @RequestParam(value = "caseName")String caseName,
                                      @RequestParam(value = "descption")String descption,
                                      @RequestParam(value = "runUrl")String runUrl){
        TestCase testCase = new TestCase();
        testCase.setCaseName(caseName);
        testCase.setSystemType(systemType);
        testCase.setSystemName(SYSTEM_NAME.get(systemType));
        testCase.setDescription(descption);
        testCase.setRunUrl(runUrl);
        testCaseService.addTestCase(testCase);
        return BaseResponseVO.success("成功");
    }

    @GetMapping("/deleteById")
    public BaseResponseVO deleteTestCase(@RequestParam(value = "caseId")Integer caseId){
        testCaseService.deleteTestCase(caseId);
        return BaseResponseVO.success("操作成功");
    }

    @PostMapping("/update")
    public BaseResponseVO updateTestCase(@RequestParam(value ="id" )Integer id,
                                         @RequestParam(value = "systemType")Integer systemType,
                                         @RequestParam(value = "caseName")String caseName,
                                         @RequestParam(value = "descption")String descption,
                                         @RequestParam(value = "runUrl")String runUrl){
        TestCase testCase = new TestCase();
        testCase.setId(id);
        testCase.setCaseName(caseName);
        testCase.setSystemType(systemType);
        testCase.setSystemName(SYSTEM_NAME.get(systemType));
        testCase.setDescription(descption);
        testCase.setRunUrl(runUrl);
        testCaseService.updateTestCase(testCase);
        return BaseResponseVO.success("成功");
    }

    @GetMapping("/getById")
    public BaseResponseVO getTestCaseById(@RequestParam(value = "caseId")Integer caseId){

        return BaseResponseVO.success(testCaseService.getTestCaseById(caseId));
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
