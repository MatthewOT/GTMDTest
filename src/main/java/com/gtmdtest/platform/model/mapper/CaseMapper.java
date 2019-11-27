package com.gtmdtest.platform.model.mapper;

import com.gtmdtest.platform.model.entity.Case;
import com.gtmdtest.platform.model.entity.CaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaseMapper {
    long countByExample(CaseExample example);

    int deleteByExample(CaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Case record);

    int insertSelective(Case record);

    List<Case> selectByExample(CaseExample example);

    Case selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Case record, @Param("example") CaseExample example);

    int updateByExample(@Param("record") Case record, @Param("example") CaseExample example);

    int updateByPrimaryKeySelective(Case record);

    int updateByPrimaryKey(Case record);
}