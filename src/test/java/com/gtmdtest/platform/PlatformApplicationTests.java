package com.gtmdtest.platform;

import com.gtmdtest.platform.model.entity.TestCase;
import com.gtmdtest.platform.service.testCaseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class PlatformApplicationTests {

    @Resource
    testCaseService testCaseService;

    @Test
    void contextLoads() {
    }

    @Test
    void serviceTest(){
        List<TestCase> list = testCaseService.getAllTestCase();
        System.out.println(list.get(0).getCaseName());
    }

}
