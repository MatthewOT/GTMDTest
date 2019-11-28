package com.gtmdtest.platform.model.mapper;

import com.gtmdtest.platform.model.entity.TestCase;
import com.gtmdtest.platform.model.entity.TestCaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestCaseMapper {
    long countByExample(TestCaseExample example);

    int deleteByExample(TestCaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestCase record);

    int insertSelective(TestCase record);

    List<TestCase> selectByExample(TestCaseExample example);

    TestCase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestCase record, @Param("example") TestCaseExample example);

    int updateByExample(@Param("record") TestCase record, @Param("example") TestCaseExample example);

    int updateByPrimaryKeySelective(TestCase record);

    int updateByPrimaryKey(TestCase record);
}