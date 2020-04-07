package com.gtmdtest.platform.common;

import com.alibaba.fastjson.JSONPath;

public class JsonUtil {

    public static String getValue(String jsonStr,String valuePath) throws Exception {
        if (jsonStr.isEmpty()||valuePath.isEmpty()){
            throw new Exception("json体或jsonpath为空");
        }
        String str = String.valueOf(JSONPath.read(jsonStr, valuePath));
        return str ;
    }
}
