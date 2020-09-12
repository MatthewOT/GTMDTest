package com.gtmdtest.platform.service;

import com.gtmdtest.platform.model.entity.Users;

import java.util.List;

public interface UsersService {

    void addUser(Users user);
    void deleteUser(Integer id);
    void updateUser(Users user);
    Users getUserById(Integer id);
    List<Users> getAllUser();
}
