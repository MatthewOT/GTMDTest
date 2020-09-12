package com.gtmdtest.platform.service.impl;

import com.gtmdtest.platform.model.entity.TestCase;
import com.gtmdtest.platform.model.entity.TestCaseExample;
import com.gtmdtest.platform.model.mapper.TestCaseMapper;
import com.gtmdtest.platform.service.TestCaseService;
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
public class TestCaseServiceImpl implements TestCaseService {

    private static final Logger logger = LoggerFactory.getLogger(TestCaseServiceImpl.class);

    @Resource
    private TestCaseMapper caseMapper;

    @Override
    public void addTestCase(TestCase newTestCase) {
        caseMapper.insert(newTestCase);
    }

    @Override
    public void deleteTestCase(Integer id) {
        caseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateTestCase(TestCase newTestCase) {
        caseMapper.updateByPrimaryKey(newTestCase);
    }

    @Override
    public TestCase getTestCaseById(Integer id) {
        return caseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TestCase> getTestCaseBySystemType(Integer systemType) {
        TestCaseExample example = new TestCaseExample();
        example.createCriteria().andSystemTypeEqualTo(systemType);
        return caseMapper.selectByExample(example);
    }

    @Override
    public List<TestCase> getAllTestCase() {
        TestCaseExample example = new TestCaseExample();
        example.createCriteria().andIdIsNotNull();
        return caseMapper.selectByExample(example);
    }
}
