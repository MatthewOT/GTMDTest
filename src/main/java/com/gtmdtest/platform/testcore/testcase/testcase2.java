package com.gtmdtest.platform.testcore.testcase;

import com.gtmdtest.platform.testcore.baseTestInterface;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.HashMap;

@Slf4j
public class testcase2 {
    private baseTestInterface itf = new baseTestInterface();

    @Test
    void test2(){
        itf.setMethod("GET")
                .setUrl("https://wk.baidu.com/view/api/xpage?formId=wk_wap_ad_tmp")
                .setAssertOfItf(new HashMap<String, String>(){{
                    put("$.setting.read_end_ad","1");
                }})
                .setOutput(new HashMap<String, String>(){{
                    put("except","$.setting.read_end_ad");
                }});
        log.info(itf.runInterface());
        log.info(String.valueOf(itf.getAssertResults().get("$.setting.read_end_ad")));
        log.info(itf.getOutput().entrySet().iterator().next().getValue());
    }
}
