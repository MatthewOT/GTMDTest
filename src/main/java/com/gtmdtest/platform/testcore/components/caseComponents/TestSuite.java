package com.gtmdtest.platform.testcore.components.caseComponents;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class TestSuite implements Runable {

    private String path;
    private String type;

    private List<TestCase> testCases = new ArrayList<>();

    @Override
    public void run() {

    }
}
