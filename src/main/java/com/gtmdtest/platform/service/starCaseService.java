package com.gtmdtest.platform.service;

import com.gtmdtest.platform.model.entity.StarCase;

import java.util.List;

public interface starCaseService {

    void addStarCase();
    void deleteStarCase();
    void updateStarCase();
    StarCase getStarCaseById();
    List<StarCase> getAllStarCase();
}
