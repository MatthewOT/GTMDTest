package com.gtmdtest.platform.service.impl;

import com.gtmdtest.platform.model.entity.Users;
import com.gtmdtest.platform.model.entity.UsersExample;
import com.gtmdtest.platform.model.mapper.UsersMapper;
import com.gtmdtest.platform.service.usersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-11-28 13:06
 **/
@Service
public class usersServiceImpl implements usersService {

    private static final Logger logger = LoggerFactory.getLogger(usersServiceImpl.class);

    @Resource
    private UsersMapper usersMapper;

    @Override
    public void addUser(Users user) {
        usersMapper.insert(user);
    }

    @Override
    public void deleteUser(Integer id) {
        usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUser(Users user) {
        usersMapper.updateByPrimaryKey(user);
    }

    @Override
    public Users getUserById(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Users> getAllUser() {
        UsersExample example = new UsersExample();
        example.createCriteria().andIdIsNotNull();
        return usersMapper.selectByExample(example);
    }
}
