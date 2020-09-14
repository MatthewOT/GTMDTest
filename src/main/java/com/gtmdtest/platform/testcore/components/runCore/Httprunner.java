package com.gtmdtest.platform.testcore.components.runCore;

import lombok.Data;

@Data
public class Httprunner {
    private Boolean failfast;

    private Boolean saveTest;

    private String reportTemplate;

    private String reportDir;

    private String logLevel;

    private String logFile;

//  TODO:这个类需要好好想一下怎么搞，python项目java重构真是坑太多了
    private Object unittestRunner;

    void addTests(){}

    void runSuite(){}

    void aggregate(){}

    void runTest(){}

    void getVarsOut(){}

    void runPath(){}

    void run(){}

    void summary(){}

}
