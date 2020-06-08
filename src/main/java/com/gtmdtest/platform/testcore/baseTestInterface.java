package com.gtmdtest.platform.testcore;

import com.gtmdtest.platform.testcore.utils.JsonUtil;
import com.gtmdtest.platform.common.OkHttpUtil;
import com.gtmdtest.platform.model.enums.requestMethod;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Slf4j
public class baseTestInterface {
    
    private OkHttpUtil okHttpUtil = new OkHttpUtil();
    private String itfName;//接口名
    private String url;//请求地址
    private String method;//请求方法
    private String response;//响应
    private Map<Object,Object> headersOfItf = new HashMap<>();//接口请求头
    private Map<String,String> cookiesOfItf = new HashMap<>();//接口cookie
    private Map<String,String> assertOfItf = new HashMap<>();//接口断言
    private Map<String,String> params = new HashMap<>();//请求参数
    private Map<String,String> output = new HashMap<>();//输出至控制台或报告
    private Map<String,String> tempValueOfItf = new HashMap<>();//断言中间值，存放着断言的实际值
    private Map<String,Boolean> assertResults = new HashMap<>();//断言结果

    /**
     * 运行接口请求并进行响应参数提取
     * 空指针控制放在被调用方处理（okHttpUtil中）
     * @return 响应体
     */
    public String runInterface(){
        //get请求
        if (Objects.equals(this.method, requestMethod.get.getName())){

            response = okHttpUtil.get(url,params,headersOfItf);

            //解析响应
            resolveTempValues(response);
            //执行断言
            assertResponse();
            return response;

            //post请求
        }if (Objects.equals(this.method, requestMethod.post.getName())){

            response = okHttpUtil.post(url,params,headersOfItf);

            //解析响应
            resolveTempValues(response);
            //执行断言
            assertResponse();
            return response;

        }

        log.error("-->-->请检查请求方法<--<--");
        return null;
    }

    /**
     * 解析output：
     *     解析前output内为{"要输出的变量名","要输出的变量的jsonpath"}
     *     解析后output内为{"要输出的变量名","要输出的变量的值"}
     * 解析assert：
     *     assertOfItf内为{"要断言的jsonpath","期望值"}
     *     tempValueOfItf内为{"要断言的jsonpath","实际值"}
     * 目前的边界及异常处理不够细致，后续代码需要优化
     * @param responseBody 响应体
     */
    private void resolveTempValues(String responseBody){
        //解析output中
        if (!output.isEmpty()) {
            for (Map.Entry entry : output.entrySet()) {
                output.put((String) entry.getKey(),
                        JsonUtil.getValue(responseBody, (String) entry.getValue()));
            }
        }

        if (!assertOfItf.isEmpty()){
            for (Map.Entry entry : assertOfItf.entrySet()){
                tempValueOfItf.put((String) entry.getKey(),
                        JsonUtil.getValue(responseBody, (String) entry.getKey()));
            }
        }

    }

    /**
     * 对接口响应进行断言
     * 方法还需要做一些边界处理和异常捕获
     */
    private void assertResponse(){
        if (!assertOfItf.isEmpty()){

            for (Map.Entry e : assertOfItf.entrySet()){
                assertResults.put((String) e.getKey(),
                        Objects.equals(e.getValue(),tempValueOfItf.get(e.getKey())));
            }
        }
    }

    public baseTestInterface(String itfName, String url, String method,Map<Object,Object> headersOfItf,
                             Map<String,String> cookiesOfItf, Map<String,String> params,
                             Map<String,String> assertOfItf){
        this.itfName = itfName;
        this.url = url;
        this.method = method;
        this.headersOfItf = headersOfItf;
        this.cookiesOfItf = cookiesOfItf;
        this.params = params;
        this.assertOfItf = assertOfItf;
        if (Objects.nonNull(this.cookiesOfItf)){
            this.headersOfItf.put("Cookies",this.cookiesOfItf);
        }
    }

}
