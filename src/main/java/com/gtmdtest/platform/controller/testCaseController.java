package com.gtmdtest.platform.controller;

import com.gtmdtest.platform.service.testCaseService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-11-29 12:20
 **/
@RestController
public class testCaseController {

    @Resource
    testCaseService testCaseService;
}
