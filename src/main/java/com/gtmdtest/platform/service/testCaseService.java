package com.gtmdtest.platform.service;

import com.gtmdtest.platform.model.entity.TestCase;

import java.util.List;

public interface testCaseService {

    void addTestCase(TestCase newcase);
    void deleteTestCase(Integer id);
    void updateTestCase(TestCase newcase);
    TestCase getTestCaseById(Integer id);
    List<TestCase> getAllTestCase();
}
