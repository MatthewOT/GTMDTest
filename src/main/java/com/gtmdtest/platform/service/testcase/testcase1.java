package com.gtmdtest.platform.service.testcase;


import com.gtmdtest.platform.common.JsonUtil;
import com.gtmdtest.platform.common.OkHttpUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class testcase1 {

    private Map<String,String> tempValue = new HashMap<>();

    @Resource
    private OkHttpUtil okHttpUtil;

    private String url1 = "https://wk.baidu.com/view/api/xpage?formId=wk_wap_ad_tmp";

    private Map<Object,Object> TempValue;

    /*
    此处的path用于json内部寻址,找寻我们所需要的值,具体的正则语法demo可见测试类中的jsontest
     */
    public void testone(){
       String response1 = okHttpUtil.get(url1);
       tempValue.put("id",JsonUtil.getValue(response1,"$.setting.read_end_ad"));
        System.out.println(tempValue.get("id"));
    }


}
