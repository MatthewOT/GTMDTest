package com.gtmdtest.platform.testcore.components.caseComponents;

import lombok.Data;
import java.util.Map;

@Data
public class ProjectMapping {
    private String PWD;
    private Class functions;
    //    TODO:这里可能涉及到lazyString的问题
    private Map<String,Object> variables;
    private Map<String,Object> env;
    private Map<String,Object> api;
}
