//package com.gtmdtest.platform.controller;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.gtmdtest.platform.common.diffTools;
//import com.gtmdtest.platform.model.vo.BaseResponseVO;
//import com.gtmdtest.platform.service.singleDiffService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.net.URLDecoder;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @program: platform
// * @description: 单接口diff的controller
// * @author:
// * @create: 2019-11-25 13:08
// **/
//@RestController
//public class singleDiffController {
//
//    /*
//    get方法
//     */
//    public BaseResponseVO byJsonMethod( @RequestParam("requestUrl1") String requestUrl1,
//                                        @RequestParam("requestUrl2") String requestUrl2,
//                                        @RequestParam(required = false, defaultValue = "") String params1,
//                                        @RequestParam(required = false, defaultValue = "") String params2,
//                                        @RequestParam(required = false, defaultValue = "") String headers1,
//                                        @RequestParam(required = false, defaultValue = "") String headers2,
//                                        @RequestParam(required = false, defaultValue = "") String userCookies1,
//                                        @RequestParam(required = false, defaultValue = "") String userCookies2,
//                                        HttpServletRequest request){
//        Map<String, String> param1;
//        Map<String, String> param2;
//        Map<String, String> header1;
//        Map<String, String> header2;
//        Map<String, String> userCookie1;
//        Map<String, String> userCookie2;
//        try {
//            param1 = parameterNormalization(params1);
//            param2 = parameterNormalization(params2);
//            header1 = parameterNormalization(headers1);
//            header2 = parameterNormalization(headers2);
//            userCookie1 = parameterNormalization(userCookies1);
//            userCookie2 = parameterNormalization(userCookies2);
//        } catch (Exception e) {
//            System.out.println(e);
//            return BaseResponseVO.error("请求参数数据不合法,请检查后输入");
//        }
//        //将前端的复合参数转为map集合封装到对应的request请求。
//        try {
//            requestUrl1 = URLDecoder.decode(requestUrl1, "UTF-8");
//            requestUrl2 = URLDecoder.decode(requestUrl2, "UTF-8");
//
//            String responseBody1 = responseApi.Get(requestUrl1, param1, header1, userCookie1);
//            String responseBody2 = responseApi.Get(requestUrl2, param2, header2, userCookie2);
//            Map<String,Object> diffResult = new HashMap<>();
//            diffResult.put("result1",responseBody1);
//            diffResult.put("result2",responseBody2);
//            return BaseResponseVO.success(diffResult);
//        } catch (Exception e) {
//            return BaseResponseVO.fail("对比过程中出现错误，请重试");
//    }
//
//
//
//
//        /*
//           参数的格式化
//         */
//    }
//    public Map<String, String> parameterNormalization(String param) {
//        Map paramMap = new HashMap<>();
//        //若为空，初始化为null
//        if (param.isEmpty()) {
//            paramMap = null;
//        } else if (param.charAt(0) == '{') {  //在这里判断参数是如何传递到后端的--1、json-{"":"","":""}类型；2、字符串（页面展示key=value；这种类型）
//            paramMap = JSONObject.parseObject(param, Map.class);
//        } else {
//            String[] keyValues = param.split(";");
//            for (int i = 0; i < keyValues.length; i++) {
//                String[] key_value = keyValues[i].split("=");
//                String key = key_value[0];
//                String value = key_value[1];
//                paramMap.put(key, value);
//
//            }
//        }
//        return paramMap;
//    }
//
///*
//post方法
// */
//    public BaseResponseVO byJsonMethodStringss(
//            @RequestBody DiffPostParams diffPostParams) {
//        try{
//           /* JSONObject requestBody2 = diffPostParams.getRequestBody2();
//            String sq = requestBody2.toString(SerializerFeature.WriteMapNullValue);
//            String s2 = diffPostParams.getRequestBody2().toString();
//            System.out.println("s2"+s2+"---"+sq);
//            System.out.println(diffPostParams.getRequestBody2());*/
//            //2019.8.12解决了在Json转为String出现的忽视null字段的问题。
//            return resultByString(diffPostParams.getRequestBody1().toString(SerializerFeature.WriteMapNullValue), diffPostParams.getRequestBody2().toString(SerializerFeature.WriteMapNullValue));
//        } catch (Exception e) {
//            return BaseResponseVO.fail("请求参数数据不合法,请检查后输入");
//        }
//
//
//
//        /*
//        将传入的string转为JsonObject类型
//         */
//    public BaseResponseVO resultByString(String responseBody1,String responseBody2){
//        try {
//            //这里需要引入一个diff工具
//            int status1 = diffTools.verificationBykey(responseBody1);
//            int status2 = diffTools.verificationBykey(responseBody2);
//            if (status1 != 1 && status1 != 2 || status1 != status2 || status2 != 1 && status2 != 2) {
//                return BaseResponseVO.error("请求数据中含有不合法数据,请检查后输入");
//            }
//            if (status1 == 2) {
//                /*JSONObject.parseObject(response_body1, SerializerFeature.WRITE_MAP_NULL_FEATURES);
//                net.sf.json.JSONObject jsonObjectss = net.sf.json.JSONObject.fromObject(response_body2);*/
//                JSONObject jsonObject1 = JSONObject.parseObject(responseBody1);
//                JSONObject jsonObject2 = JSONObject.parseObject(responseBody2);
//
//                JSONObject resultByJson = singleDiffService.getResultByJson(jsonObject1, jsonObject2);
//
//                if (resultByJson.getJSONObject("diff").size() >= 1) {
//
//                    return BaseResponseVO.success( new HashMap<String,Object>(){{
//                        put("两个接口不一致",resultByJson);
//                    }});
//                } else {
//                    return BaseResponseVO.success(resultByJson);
//                }
//            } else {
//                JSONArray jsonArray1 = JSONArray.parseArray(responseBody1);
//                JSONArray jsonArray2 = JSONArray.parseArray(responseBody2);
//                JSONObject resultByJson = singleDiffService.getResultByJson(jsonArray1, jsonArray2);
//
//                if (resultByJson.getJSONObject("diff").size() >= 1) {
//
//                    return BaseResponseVO.success( new HashMap<String,Object>(){{
//                        put("两个接口不一致",resultByJson);
//                    }});
//                } else {
//                    return BaseResponseVO.success(resultByJson);
//                }
//            }
//        } catch (Exception e) {
//            return BaseResponseVO.fail("请求数据不合法,请检查后输入");
//        }
//    }
//    }
//}
