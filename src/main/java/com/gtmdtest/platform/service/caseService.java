package com.gtmdtest.platform.service;

import com.gtmdtest.platform.model.entity.Case;

import java.util.List;

public interface caseService {

    void addCase();
    void deleteCase();
    void updateCase();
    Case getCaseById();
    List<Case> getAllCase();
}
