package com.gtmdtest.platform;

//import com.gtmdtest.platform.common.OkHttpUtil;
import com.gtmdtest.platform.common.OkHttpUtil;
import com.gtmdtest.platform.model.mapper.TestCaseMapper;
import com.gtmdtest.platform.service.TestCaseService;
import com.gtmdtest.platform.testcore.components.TestInterface;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PlatformApplicationTests {

    @Resource
    private TestCaseService TestCaseService;

    @Resource
    private TestCaseMapper caseMapper;

//    @Resource
//    private OkHttpUtil okHttpUtil;
    private OkHttpUtil okHttpUtil = new OkHttpUtil();
    private TestInterface inter = new TestInterface();
    private TestInterface inter2 = new TestInterface("test","http://www.kuaidi100.com/query?type=shunfeng&postid=123454545451",
            "get",null,null,null,null);

//    @Resource
//    testcase1 testcase1;

    @Test
    void contextLoads() {

    }

    @Test
    void serviceTest(){
//        List<BaseTestCase> list = TestCaseService.getAllTestCase();
        System.out.println(TestCaseService.getTestCaseBySystemType(1));
//        System.out.println(list.get(0).getCaseName());
    }

    @Test
    void mapperTest(){
        System.out.println(caseMapper.selectByPrimaryKey(1));
    }

    @Test
    void getTest(){
        System.out.println(okHttpUtil.get("http://www.kuaidi100.com/query?type=shunfeng&postid=123454545451"));
//        System.out.println(okHttpUtil.post("http://www.baidu.com",null,null));
    }


    @Test
    void getTest1(){
        String url1 = "https://wq.360buyimg.com/js/common/dest/m.xstorage.client.min.js?t=201809121400&sceneval=2";
        System.out.println(okHttpUtil.get(url1));
//        System.out.println(okHttpUtil.post("http://www.baidu.com",null,null));
    }

//    @Test
//    void test11(){
//        testcase1.testone();
//    }

    @Test
    void test2() throws Exception {
        inter.setUrl("http://www.kuaidi100.com/query?type=shunfeng&postid=123454545451")
                .setMethod("GET");

        System.out.println(inter.runInterface());
    }

}
