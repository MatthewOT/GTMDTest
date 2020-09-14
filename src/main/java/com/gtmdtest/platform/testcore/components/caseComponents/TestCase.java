package com.gtmdtest.platform.testcore.components.caseComponents;

import com.gtmdtest.platform.testcore.components.runCore.Runner;
import com.gtmdtest.platform.testcore.components.baseComponents.Config;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class TestCase implements Runable {

    private Config config;
    private List<Runable> testSteps = new ArrayList<>();
    private String name;
    private Map<String,Object> variables;
    private List<Map<String,List<Object>>> validate;
    private String baseUrl;
    private String testCasePath;
    private Map<String,List> parameters;
    private TestCase testCaseDef;
    private Runner runner;
    private Map<String,String> extract;
    private List<String> setupHooks;
    private List<String> teardownHooks;
    private String path;
    private String type;
    @Override
    public void run() {

    }

    public TestCase parse(){
        return this;
    }

}
