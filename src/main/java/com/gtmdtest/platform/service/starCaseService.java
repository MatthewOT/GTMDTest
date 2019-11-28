package com.gtmdtest.platform.service;

import com.gtmdtest.platform.model.entity.StarCase;

import java.util.List;

public interface starCaseService {

    void addStarCase(StarCase starCase);
    void deleteStarCase(Integer id);
    void updateStarCase(StarCase starCase);
    StarCase getStarCaseById(Integer id);
    List<StarCase> getAllStarCase();
}
