package com.gtmdtest.platform;

import com.gtmdtest.platform.common.OkHttpUtil;
import com.gtmdtest.platform.model.entity.TestCase;
import com.gtmdtest.platform.service.testCaseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class PlatformApplicationTests {

    @Resource
    private testCaseService testCaseService;

    @Resource
    private OkHttpUtil okHttpUtil;

    @Test
    void contextLoads() {
    }

    @Test
    void serviceTest(){
        List<TestCase> list = testCaseService.getAllTestCase();
        System.out.println(list.get(0).getCaseName());
    }

    @Test
    void getTest(){
        System.out.println(okHttpUtil.get("http://www.baidu.com",null));
    }

}
