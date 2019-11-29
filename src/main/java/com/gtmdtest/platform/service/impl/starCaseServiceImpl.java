package com.gtmdtest.platform.service.impl;

import com.gtmdtest.platform.model.entity.StarCase;
import com.gtmdtest.platform.model.entity.StarCaseExample;
import com.gtmdtest.platform.model.mapper.StarCaseMapper;
import com.gtmdtest.platform.service.starCaseService;
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
public class starCaseServiceImpl implements starCaseService {

    private static final Logger logger = LoggerFactory.getLogger(starCaseServiceImpl.class);

    @Resource
    private StarCaseMapper starCaseMapper;

    @Override
    public void addStarCase(StarCase starCase) {
        starCaseMapper.insert(starCase);
    }

    @Override
    public void deleteStarCase(Integer id) {
        starCaseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateStarCase(StarCase starCase) {
        starCaseMapper.updateByPrimaryKey(starCase);
    }

    @Override
    public StarCase getStarCaseById(Integer id) {
        return null;
    }

    @Override
    public List<StarCase> getAllStarCase() {
        StarCaseExample example = new StarCaseExample();
        example.createCriteria().andIdIsNotNull();
        return starCaseMapper.selectByExample(example);
    }
}
