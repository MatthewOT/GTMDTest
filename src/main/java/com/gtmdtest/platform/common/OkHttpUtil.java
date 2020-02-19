package com.gtmdtest.platform.common;

import okhttp3.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Map;

@Component
public class OkHttpUtil{
    private  final Logger logger = LoggerFactory.getLogger(OkHttpUtil.class);

    @Resource
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
     * 解析headers对象
     * @param headers 存储headers的键值对
     * @return okhttp中的headers对象
     */
    private Headers resolveHeaders(Map<String,String> headers){

        Headers.Builder builder = new Headers.Builder();

        for (Map.Entry<String,String> entry : headers.entrySet()){
            builder.add(entry.getKey(),entry.getValue());
        }
        return builder.build();
    }

    /**
     * okhttp的request执行器
     * @param request 请求实体
     * @return 响应
     */
    private String requestExecutor(Request request){

        String responseBody = null;
        try (Response response = okHttpClient.newCall(request).execute()) {

            if (response.body() != null) {
                responseBody = response.body().string();
            }

            logger.info("\nresponse:[\n  <code:{}>,\n  <message:{}>,\n  <body:{}>]",
                    response.code(),
                    response.message(),
                    responseBody);

            if (response.isSuccessful()) {
                return responseBody;
            }
        } catch (Exception e) {
            logger.error("okhttp3 error >> ex = {}", ExceptionUtils.getStackTrace(e));
        }
        return "";
    }

    /**
     * get
     * @param url     请求的url
     * @param queries 请求的参数，在浏览器？后面的数据，没有可以传null
     * @return 响应
     */
    public String get(String url, Map<String, String> queries, Map<String,String> headers) {
        String requestUrl =  splitUrl(url,queries);
        Headers header;

        if (headers!=null){
            header = resolveHeaders(headers);
        }else {
            header = new Headers.Builder().add("request-remark","no-header").build();
        }

        Request request = new Request.Builder()
                .url(requestUrl)
                .headers(header)
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
    public  String post(String url, Map<String, String> params, Map<String,String> headers) {

        FormBody.Builder builder = new FormBody.Builder();

        Headers header;

        if (headers!=null){
            header = resolveHeaders(headers);
        }else {
            header = new Headers.Builder().add("request-remark","no-header").build();
        }
        //添加参数
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }

        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .headers(header)
                .build();

        return requestExecutor(request);
    }

    /**
     * get
     * @param url     请求的url
     * @param queries 请求的参数，在浏览器？后面的数据，没有可以传null
     * @return 响应
     */
    public  String getForHeader(String url, Map<String, String> queries, Map<String,String> headers) {
        String requestUrl = splitUrl(url,queries);

        Headers header;

        if (headers!=null){
            header = resolveHeaders(headers);
        }else {
            header = new Headers.Builder().add("request-remark","no-header").build();
        }

        Request request = new Request.Builder()
                .headers(header)
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
    public  String postJsonParams(String url, String jsonParams, Map<String,String> headers) {

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);

        Headers header;

        if (headers!=null){
            header = resolveHeaders(headers);
        }else {
            header = new Headers.Builder().add("request-remark","no-header").build();
        }

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .headers(header)
                .build();

        return requestExecutor(request);
    }

    /**
     * Post请求发送xml数据....
     * 参数一：请求Url
     * 参数二：请求的xmlString
     * 参数三：请求回调
     */
    public  String postXmlParams(String url, String xml, Map<String,String> headers) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/xml; charset=utf-8"), xml);

        Headers header;

        if (headers!=null){
            header = resolveHeaders(headers);
        }else {
            header = new Headers.Builder().add("request-remark","non-header").build();
        }

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .headers(header)
                .build();

        return requestExecutor(request);
    }

    public String get(String url, Map<String, String> headers){
        if (headers.isEmpty()){
            return get(url,null,null);
        }
        return get(url,null,headers);
    }

    public String get(String url){
        return get(url,null,null);
    }

}