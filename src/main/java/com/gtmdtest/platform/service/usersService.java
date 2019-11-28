package com.gtmdtest.platform.service;

import com.gtmdtest.platform.model.entity.Users;

import java.util.List;

public interface usersService {

    void addUser();
    void deleteUser();
    void updateUser();
    Users getUserById();
    List<Users> getAllUser();
}
