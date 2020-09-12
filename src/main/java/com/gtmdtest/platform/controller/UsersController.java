package com.gtmdtest.platform.controller;

import com.gtmdtest.platform.model.entity.Users;
import com.gtmdtest.platform.model.vo.BaseResponseVO;
import com.gtmdtest.platform.service.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-11-29 12:19
 **/
@RequestMapping("/user")
@RestController
public class UsersController {

    @Resource
    private UsersService UsersService;

    @PostMapping("/add")
    public BaseResponseVO addUser(@RequestParam(value = "username")String username,
                                  @RequestParam(value = "password")String password){
        Users users = new Users(username,password);
        UsersService.addUser(users);
        return BaseResponseVO.success("操作成功");
    }

    @GetMapping("deleteById")
    public BaseResponseVO deleteUser(@RequestParam(value = "userId")Integer userId){
        UsersService.deleteUser(userId);
        return BaseResponseVO.success("成功");
    }

    @PostMapping("/update")
    public BaseResponseVO updateUser(){
        return null;
    }

    @GetMapping("/getById")
    public BaseResponseVO getUserById(@RequestParam(value = "userId")Integer userId){
        return BaseResponseVO.success(UsersService.getUserById(userId));
    }

    @GetMapping("/getAll")
    public BaseResponseVO getAllUsers(){
        List<Users> list = UsersService.getAllUser();
        return BaseResponseVO.success(list);
    }
}
