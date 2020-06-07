package com.gtmdtest.platform.testcore;

import com.gtmdtest.platform.common.JsonUtil;
import com.gtmdtest.platform.common.OkHttpUtil;
import com.gtmdtest.platform.model.enums.requestMethod;
import com.gtmdtest.platform.model.vo.BaseResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class baseTestInterface {

    private Logger logger = LoggerFactory.getLogger(baseTestInterface.class);

//    @Resource
//    private OkHttpUtil okHttpUtil;
    
    private OkHttpUtil okHttpUtil = new OkHttpUtil();
    private String itfName;//接口名
    private String url;//请求地址
    private String method;//请求方法
    private String response;//响应
    private Map<Object,Object> headersOfItf = new HashMap<>();//接口请求头
    private Map<String,String> cookiesOfItf = new HashMap<>();//接口cookie
    private Map<String,String> assertOfItf = new HashMap<>();//接口断言，可能需要再加一个map，作为assert结果集
    private Map<String,String> params = new HashMap<>();//请求参数
    private Map<String,String> output = new HashMap<>();//输出至控制台或报告
    private Map<String,String> tempValueOfItf = new HashMap<>();//接口层级的变量池

    /**
     * 运行接口请求并进行响应参数提取
     * 空指针控制放在被调用方处理（okHttpUtil中）
     * @return 响应体
     */
    public String runInterface(){
        //get请求
        if (this.method == requestMethod.get.getName()){

            response = okHttpUtil.get(url,params,headersOfItf);

            //解析响应内参数至变量池
            try {
                resolveTempValues(response);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return response;

            //post请求
        }if (this.method == requestMethod.post.getName()){

            response = okHttpUtil.post(url,params,headersOfItf);

            //解析响应内参数至变量池
            try {
                resolveTempValues(response);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return response;

        }

        logger.error("-->-->请检查请求方法<--<--");
        return null;
    }

    /**
     * 解析output和assert中的参数至变量池
     * 目前的边界及异常处理不够细致，后续代码需要优化
     * @param responseBody 响应体
     * @throws Exception 响应体为空或map中的jsonPath为空
     */
    private void resolveTempValues(String responseBody) throws Exception {
        //解析output中
        if (!output.isEmpty()) {
            for (Map.Entry entry : output.entrySet()) {
                tempValueOfItf.put((String) entry.getKey(),
                        JsonUtil.getValue(responseBody, (String) entry.getValue()));
            }
        }

        if (!assertOfItf.isEmpty()){
            for (Map.Entry entry : assertOfItf.entrySet()){
                tempValueOfItf.put((String) entry.getKey(),
                        JsonUtil.getValue(responseBody, (String) entry.getValue()));
            }
        }

    }

    /**
     * 对接口响应进行断言
     * 方法还需要做一些边界处理和异常捕获
     */
    public void AssertResponse(){
        for (Map.Entry e :assertOfItf.entrySet()){
            Assert.assertEquals(e.getValue(),tempValueOfItf.get(e.getKey()));
        }

    }


    public baseTestInterface(){}

    public baseTestInterface(String url, String method,Map headersOfItf,Map cookiesOfItf,
                             Map params,Map assertOfItf){
        this.url = url;
        this.method = method;
        this.headersOfItf = headersOfItf;
        this.cookiesOfItf = cookiesOfItf;
        this.params = params;
        this.assertOfItf = assertOfItf;
        this.headersOfItf.put("Cookies",this.cookiesOfItf);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Map<Object, Object> getHeadersOfItf() {
        return headersOfItf;
    }

    public void setHeadersOfItf(Map<Object, Object> headersOfItf) {
        this.headersOfItf = headersOfItf;
    }

    public Map<String, String> getCookiesOfItf() {
        return cookiesOfItf;
    }

    public void setCookiesOfItf(Map<String, String> cookiesOfItf) {
        this.cookiesOfItf = cookiesOfItf;
    }

    public Map<String, String> getAssertOfItf() {
        return assertOfItf;
    }

    public void setAssertOfItf(Map<String, String> assertOfItf) {
        this.assertOfItf = assertOfItf;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Map<String, String> getOutput() {
        return output;
    }

    public void setOutput(Map<String, String> output) {
        this.output = output;
    }

    public String getItfName() {
        return itfName;
    }

    public void setItfName(String itfName) {
        this.itfName = itfName;
    }

    public Map<String, String> getTempValueOfItf() {
        return tempValueOfItf;
    }

    public void setTempValueOfItf(Map<String, String> tempValueOfItf) {
        this.tempValueOfItf = tempValueOfItf;
    }
}
