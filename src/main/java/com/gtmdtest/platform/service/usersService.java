package com.gtmdtest.platform.service;

import com.gtmdtest.platform.model.entity.Users;

public interface usersService {

    void addUser();
    void deleteUser();
    void updateUser();
    Users getUser();
}
