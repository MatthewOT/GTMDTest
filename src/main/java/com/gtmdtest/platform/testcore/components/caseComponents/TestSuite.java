package com.gtmdtest.platform.testcore.components.caseComponents;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestSuite implements Runable {

    private List<TestCase> testCases = new ArrayList<>();

    @Override
    public void run() {

    }
}
