package com.gtmdtest.platform.service.impl;

import com.gtmdtest.platform.model.entity.Case;
import com.gtmdtest.platform.model.mapper.CaseMapper;
import com.gtmdtest.platform.service.caseService;
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
public class caseServiceImpl implements caseService {

    private static final Logger logger = LoggerFactory.getLogger(caseServiceImpl.class);

    @Resource
    private CaseMapper caseMapper;

    @Override
    public void addCase(Case newCase) {

    }

    @Override
    public void deleteCase(Integer id) {

    }

    @Override
    public void updateCase(Case newCase) {

    }

    @Override
    public Case getCaseById(Integer id) {
        return null;
    }

    @Override
    public List<Case> getAllCase() {
        return null;
    }
}
