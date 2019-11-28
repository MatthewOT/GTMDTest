package com.gtmdtest.platform.service.impl;

import com.gtmdtest.platform.model.entity.TestCase;
import com.gtmdtest.platform.model.entity.TestCaseExample;
import com.gtmdtest.platform.model.mapper.TestCaseMapper;
import com.gtmdtest.platform.service.testCaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-11-28 13:07
 **/
@Service
public class testCaseServiceImpl implements testCaseService {

    private static final Logger logger = LoggerFactory.getLogger(testCaseServiceImpl.class);

    @Resource
    private TestCaseMapper caseMapper;

    @Override
    public void addTestCase(TestCase newTestCase) {

    }

    @Override
    public void deleteTestCase(Integer id) {

    }

    @Override
    public void updateTestCase(TestCase newTestCase) {

    }

    @Override
    public TestCase getTestCaseById(Integer id) {
        return null;
    }

    @Override
    public List<TestCase> getAllTestCase() {
        TestCaseExample example = new TestCaseExample();
        example.createCriteria().andIdIsNotNull();
        return caseMapper.selectByExample(example);
    }
}
