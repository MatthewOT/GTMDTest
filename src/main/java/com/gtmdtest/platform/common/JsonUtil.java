package com.gtmdtest.platform.common;

import com.alibaba.fastjson.JSONPath;

public class JsonUtil {

    public static String getValue(String jsonStr,String valuePath){
        String str = String.valueOf(JSONPath.read(jsonStr, valuePath));
        return str ;
    }
}
