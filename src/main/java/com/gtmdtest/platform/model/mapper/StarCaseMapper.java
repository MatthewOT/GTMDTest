package com.gtmdtest.platform.model.mapper;

import com.gtmdtest.platform.model.entity.StarCase;
import com.gtmdtest.platform.model.entity.StarCaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StarCaseMapper {
    long countByExample(StarCaseExample example);

    int deleteByExample(StarCaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StarCase record);

    int insertSelective(StarCase record);

    List<StarCase> selectByExample(StarCaseExample example);

    StarCase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StarCase record, @Param("example") StarCaseExample example);

    int updateByExample(@Param("record") StarCase record, @Param("example") StarCaseExample example);

    int updateByPrimaryKeySelective(StarCase record);

    int updateByPrimaryKey(StarCase record);
}