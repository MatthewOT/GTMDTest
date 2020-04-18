package com.gtmdtest.platform.model.mapper;

import com.gtmdtest.platform.model.entity.TestInterface;
import com.gtmdtest.platform.model.entity.TestInterfaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestInterfaceMapper {
    long countByExample(TestInterfaceExample example);

    int deleteByExample(TestInterfaceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestInterface record);

    int insertSelective(TestInterface record);

    List<TestInterface> selectByExample(TestInterfaceExample example);

    TestInterface selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestInterface record, @Param("example") TestInterfaceExample example);

    int updateByExample(@Param("record") TestInterface record, @Param("example") TestInterfaceExample example);

    int updateByPrimaryKeySelective(TestInterface record);

    int updateByPrimaryKey(TestInterface record);
}