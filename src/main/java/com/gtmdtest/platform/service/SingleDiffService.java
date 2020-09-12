//package com.gtmdtest.platform.service;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.gtmdtest.platform.common.DiffTools;
//
//import java.util.Map;
//
///**
// * @program: platform
// * @description:
// * @author:
// * @create: 2019-11-25 13:31
// **/
//public class singleDiffService {
//    public JSONObject generalMethod(Object o1, Object o2, int i, JSONObject resultJson, String original_key) {
//       /* if(o1==null){
//            o1=01;
//        }
//        if (o2==null){
//            o2=01;
//        }*/
//        int status = DiffTools.verificationBykey(o1);
//        int status2 = DiffTools.verificationBykey(o2);
////              两种URL虽然key相等，但是对应的value类型不一致，例如一个是数组，另一个是json
//        if (status != status2) {
//            resultJson.put("message", "在" + i + "层错误，" + original_key + "对应的值类型不一致。value1：" + o1 + ";value2:" + o2);
//            return resultJson;
//        }
////                两种URL类型相等，都是嵌套了一个数组，需要继续进行解析
//        if (status == 1) {
//            JSONArray jsonArray1 = JSONArray.parseArray(o1.toString());
//            JSONArray jsonArray2 = JSONArray.parseArray(o2.toString());
//            if (jsonArray1.size() != jsonArray2.size()) {
//                resultJson.put("message", "在" + i + "层错误，结构不一致"+ original_key);
//                return resultJson;
//            }
//            for (int k = 0; k < jsonArray1.size(); k++) {
//                //数组不当做嵌套关系，平级关系，所以这里i不在+1。所以key也不需要传入复合状态。
//                resultJson = generalMethod(jsonArray1.get(k), jsonArray2.get(k), i,  resultJson, original_key);
//            }
//        }
////                两种URL类型相等，都是嵌套了一个json，需要继续进行解析
//        if (status == 2) {
//            //2019.8.12
//            System.out.println(o1.toString());
//            Map map = JSONObject.parseObject(o1.toString(), Map.class);
//            JSONObject jsonObject = new JSONObject(map);
//            System.out.println("-----"+jsonObject.toString());
//            JSONObject jsonObject1 = JSONObject.parseObject(o1.toString());
//            JSONObject jsonObject2 = JSONObject.parseObject(o2.toString());
//
//            if (jsonObject1.size() != jsonObject2.size()) {
//                resultJson.put("msg", "在" + i + "层错误，结构不一致"+ original_key );
//                return resultJson;
//            }
//            for (String key : jsonObject1.keySet()) {
//                // 根据每次得到的map1集合中的key，map2.contains（）方法判断是否含有key，
//                if (jsonObject2.keySet().contains(key)) {
//                    resultJson = generalMethod(jsonObject1.get(key), jsonObject2.get(key), i + 1, resultJson, original_key + ":" + key);
//                } else {
//                    resultJson.put("msg", "第" + i + "层错误，接口1中的key：" + key + "  在接口2结果中不存在");
//                }
//            }
//        }
////      两种URL类型相等，都是普通的键值对，可以直接判断
//        if (status == 5) {
//            boolean result_value = o1.equals(o2);
//            if (result_value == false) {
//                //考虑如何更友好的显示到前端
//                resultJson.put(original_key, "在" + i + "层错误," + original_key + "对应的value不同。value1：" + o1 + "。value2:" + o2);
//                return resultJson;
//                //resultJson.put(original_key,"对应的值不一致");
//            }
//        }
//        //其他结果为：两者都为null；两者都是空字符串；
//        return resultJson;
//    }
//
//    /**
//     * Json方式-----遍历第一层
//     *
//     * @param json1
//     * @param json2
//     * @return
//     */
//    public JSONObject getResultByJson(JSONObject json1, JSONObject json2) {
//        //        0.方法返回结果
//        JSONObject resultJson = new JSONObject();
//        JSONObject resultJson_final = new JSONObject();/*
//        String data_api_1 = JSONObject.toJSONString(json1, SerializerFeature.WriteMapNullValue);
//        String data_api_2 = JSONObject.toJSONString(json2, SerializerFeature.WriteMapNullValue);
//        JSONObject jsonObject = JSONObject.parseObject(data_api_2);
//        Object parse = JSONObject.parse(data_api_2);
//        System.out.println(
//                data_api_2+"有没有error"
//        );*/
//        resultJson_final.put("data_api_1", json1);
//        resultJson_final.put("data_api_2", json2);
////        1、分解第一层
//        int i = 0;
//        int j = 1;
//        if (json1.size() != json2.size()) {
//            resultJson.put("msg", "在" + i + "层错误,二者体系结构不同");
//            resultJson_final.put("diff", resultJson);
//            return resultJson_final;
//        }
//        for (String key : json1.keySet()) {
//            // 根据每次得到的key，map2.contains（）方法判断是否含有key，
//            //2019.8.12暂时修改,Json反序列化会报错，考虑是否实现序列化接口
//            if (json2.keySet().contains(key)) {
//               /* System.out.println("json1.getJSONObject(key).toString();"+json1.getJSONObject(key).toString());
//                System.out.println("json1.getJSONObject(key).toString();"+json1.getJSONObject(key).toString());
//                System.out.println("--第二级别json1.get(key)："+json1.get(key));
//                System.out.println("--第二级别json1.get(key)："+json2.toString());
//                JSONObject.toJSONString(json1);
//                String jsonString1 = JSONObject.toJSONString(json1, SerializerFeature.WriteMapNullValue);
//                String jsonString2 = JSONObject.toJSONString(json2, SerializerFeature.WriteMapNullValue);
//                System.out.println("显示null"+jsonString2);
//                resultJson = generalMethod(json1.get(key), json2.get(key), i + 1, j, resultJson, key);
//               String json2String = json2.getString(key);
//                System.out.println(json2String);
//                System.out.println("2"+json2.get(key).toString());
//                */
//
//                //System.out.println("1"+json2.getJSONObject(key).toString());
//                resultJson = generalMethod(json1.get(key), json2.get(key), i + 1, resultJson, key);
//            } else {
//                resultJson.put("msg", "在" + i + "层错误，接口1中的key：" + key + "在接口2不存在");
//            }
//        }
//        resultJson_final.put("diff", resultJson);
//        return resultJson_final;
//    }
//}
