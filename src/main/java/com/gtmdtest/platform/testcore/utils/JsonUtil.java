package com.gtmdtest.platform.testcore.utils;

import com.alibaba.fastjson.JSONPath;

public class JsonUtil {

    public static String getValue(String jsonStr,String valuePath){
        if (jsonStr.isEmpty()||valuePath.isEmpty()){
            try {
                throw new Exception("json体或jsonpath为空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String str = String.valueOf(JSONPath.read(jsonStr, valuePath));
        return str ;
    }
}
