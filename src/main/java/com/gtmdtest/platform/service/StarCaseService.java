package com.gtmdtest.platform.service;

import com.gtmdtest.platform.model.entity.StarCase;

import java.util.List;

public interface StarCaseService {

    void addStarCase(StarCase starCase);
    void deleteStarCase(Integer id);
    void updateStarCase(StarCase starCase);
    StarCase getStarCaseById(Integer id);
    List<StarCase> getAllStarCase();
}
