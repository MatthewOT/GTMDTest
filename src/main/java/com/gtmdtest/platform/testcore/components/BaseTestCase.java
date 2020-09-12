package com.gtmdtest.platform.testcore.components;

import com.gtmdtest.platform.testcore.utils.JsonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Slf4j
public class BaseTestCase {

    String caseName = "";
    Set<TestInterface> itfs = new LinkedHashSet<>();
    Map<String,String> tempValue = new HashMap<>();
    Map<String,String> caseConfig = new HashMap<>();
    Map<String,String> responses = new HashMap<>();

    public void runCase(){
        for (TestInterface itf : itfs){
            runInterfaceInCase(itf);
        }

    }

    void runInterfaceInCase(TestInterface itf){

       parseTempValue(itf);

       try {
           itf.setResponse(itf.runInterface());
       } catch (Exception e) {
           e.printStackTrace();
       }

       responses.put(itf.getItfName(),itf.getResponse());

       parseOutPut(itf);

    }

    /**
     * 将接口中的参数变量输出到用例内的变量池中
     * @param itf
     */

    private void parseOutPut(TestInterface itf) {
        String reponseJson = itf.getResponse();

        if (!itf.getOutput().isEmpty()){
            for (Map.Entry<String,String> entry : itf.getOutput().entrySet()){

                String tempValueItf = "";

                if (JsonUtil.getValue(reponseJson,entry.getValue()).isEmpty()){

                    log.info("请注意检查，中间变量《{}》的值为空",entry.getKey());

                }else if (!JsonUtil.getValue(reponseJson,entry.getValue()).isEmpty()){

                    tempValueItf = JsonUtil.getValue(reponseJson,entry.getValue());

                }
                tempValue.put(entry.getKey(),tempValueItf);
            }
        }
    }

    /**
     * 将用例中间变量池中的上下文接口参数解析到接口实例中
     * @param itf 需要进行解析的接口实例
     */
    private void parseTempValue(TestInterface itf){

         if (!itf.getHeadersOfItf().isEmpty()){
             for (Map.Entry entry1:itf.getHeadersOfItf().entrySet()){
                 if (entry1.getValue().toString().contains("$")){
                     itf.getHeadersOfItf().put(entry1.getKey(),tempValue.get(entry1.getValue()));
                 }
             }
         }

         if (!itf.getCookiesOfItf().isEmpty()){
             for (Map.Entry entry2:itf.getCookiesOfItf().entrySet()){
                 if (entry2.getValue().toString().contains("$")){
                     itf.getCookiesOfItf().put((String) entry2.getKey(),tempValue.get(entry2.getValue()));
                 }
             }
         }

         if (!itf.getParams().isEmpty()){
             for (Map.Entry entry2:itf.getParams().entrySet()){
                 if (entry2.getValue().toString().contains("$")){
                     itf.getParams().put((String) entry2.getKey(),tempValue.get(entry2.getValue()));
                 }
             }
         }
    }
}
