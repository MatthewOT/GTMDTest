package com.gtmdtest.platform.testcore.testcase;

import com.gtmdtest.platform.testcore.baseTestInterface;
import org.testng.annotations.Test;

public class testcase2 {
    private baseTestInterface itf = new baseTestInterface();

    @Test
    void test2(){
        itf.setMethod("GET");
        itf.setUrl("https://wk.baidu.com/view/api/xpage?formId=wk_wap_ad_tmp");
        String result = itf.runInterface();
        System.out.println(result);
    }
}
