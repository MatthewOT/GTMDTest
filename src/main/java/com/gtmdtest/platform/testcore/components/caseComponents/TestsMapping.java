package com.gtmdtest.platform.testcore.components.caseComponents;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestsMapping {

    private ProjectMapping projectMapping;

    private List<TestSuite> testSuites = new ArrayList<>();

    private List<TestCase> testCases = new ArrayList<>();

    private List<Api> apis = new ArrayList<>();

}
