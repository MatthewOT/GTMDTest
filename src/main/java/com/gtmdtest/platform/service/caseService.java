package com.gtmdtest.platform.service;

import com.gtmdtest.platform.model.entity.Case;

import java.util.List;

public interface caseService {

    void addCase(Case newcase);
    void deleteCase(Integer id);
    void updateCase(Case newcase);
    Case getCaseById(Integer id);
    List<Case> getAllCase();
}
