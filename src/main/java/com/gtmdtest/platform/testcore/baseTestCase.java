package com.gtmdtest.platform.testcore;

import com.gtmdtest.platform.common.JsonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Slf4j
public class baseTestCase {

    String caseName = "";
    Map<String,baseTestInterface> itfs;
    Map<String,String> tempValue = new HashMap<>();
    Map<String,String> caseConfig = new HashMap<>();
    Map<String,String> responses = new HashMap<>();

    void runCase(){

    }

    void runInterfaceInCase(baseTestInterface itf){

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

    private void parseOutPut(baseTestInterface itf) {
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
    private void parseTempValue(baseTestInterface itf){

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
