package com.gtmdtest.platform.common;

import okhttp3.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

@Component
public class OkHttpUtil{
    private  final Logger logger = LoggerFactory.getLogger(OkHttpUtil.class);
    
    @Autowired
    private OkHttpClient  okHttpClient;

    /**
     * 用于get请求url拼接字符串
     * @param url 地址url
     * @param queries 请求参数
     * @return 拼接后地址url
     */
    private String splitUrl(String url, Map<String, String> queries){
        StringBuffer sb = new StringBuffer(url);
        if (queries != null && queries.keySet().size() > 0) {
            boolean firstFlag = true;
            Iterator iterator = queries.entrySet().iterator();
            while(iterator.hasNext()) {
                Map.Entry entry = (Map.Entry<String, String>) iterator.next();
                if (firstFlag) {
                    sb.append("?" + entry.getKey() + "=" + entry.getValue());
                    firstFlag = false;
                } else {
                    sb.append("&" + entry.getKey() + "=" + entry.getValue());
                }
            }
        }
        return sb.toString();
    }

    /**
     * okhttp的request执行器
     * @param request 请求实体
     * @return 响应
     */
    private String requestExecutor(Request request){
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            int status = response.code();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (Exception e) {
            logger.error("okhttp3 error >> ex = {}", ExceptionUtils.getStackTrace(e));
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return "";
    }

    /**
     * get
     * @param url     请求的url
     * @param queries 请求的参数，在浏览器？后面的数据，没有可以传null
     * @return 响应
     */
    public String get(String url, Map<String, String> queries) {
        String requestUrl =  splitUrl(url,queries);

        Request request = new Request.Builder()
                .url(requestUrl)
                .build();

        return requestExecutor(request);
    }

    /**
     * post
     *
     * @param url    请求的url
     * @param params post form 提交的参数
     * @return 响应
     */
    public  String post(String url, Map<String, String> params) {

        FormBody.Builder builder = new FormBody.Builder();

        //添加参数
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }

        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();

        return requestExecutor(request);
    }

    /**
     * get
     * @param url     请求的url
     * @param queries 请求的参数，在浏览器？后面的数据，没有可以传null
     * @return 响应
     */
    public  String getForHeader(String url, Map<String, String> queries) {
        String requestUrl = splitUrl(url,queries);

        Request request = new Request.Builder()
                .addHeader("key", "value")
                .url(requestUrl)
                .build();

        return requestExecutor(request);
    }

    /**
     * Post请求发送JSON数据....{"name":"zhangsan","pwd":"123456"}
     * 参数一：请求Url
     * 参数二：请求的JSON
     * 参数三：请求回调
     */
    public  String postJsonParams(String url, String jsonParams) {

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        return requestExecutor(request);
    }

    /**
     * Post请求发送xml数据....
     * 参数一：请求Url
     * 参数二：请求的xmlString
     * 参数三：请求回调
     */
    public  String postXmlParams(String url, String xml) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/xml; charset=utf-8"), xml);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        return requestExecutor(request);
    }
}