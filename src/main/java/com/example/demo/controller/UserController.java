package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.beetl.sql.core.page.DefaultPageRequest;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.erupt.core.annotation.EruptRecordOperate;
import xyz.erupt.core.annotation.EruptRouter;
import xyz.erupt.core.constant.EruptRestPath;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(tags="User")
@RequestMapping(EruptRestPath.ERUPT_API + "/user")
@Log
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation("pageUser")
    @GetMapping("/pageUser")
    @ResponseBody
    // @EruptRecordOperate("登录可调用")
    @EruptRouter(verifyType = EruptRouter.VerifyType.LOGIN, authIndex = 0)
    public PageResult<User> pageUser(Integer pageNumber, Integer pageSize) {
        return userMapper.pageUser(DefaultPageRequest.of(pageNumber, pageSize));
    }

}