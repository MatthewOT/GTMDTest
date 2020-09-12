package com.gtmdtest.platform.testcore.components.caseComponents;

import lombok.Data;

import java.util.HashMap;

@Data
public class ProjectMapping {
    private String PWD;
    private Class functions;
//    TODO:这里可能涉及到lazyString的问题
    private HashMap<String,Object> variables;
    private HashMap<String,Object> env;
    private String projectPath;
}
