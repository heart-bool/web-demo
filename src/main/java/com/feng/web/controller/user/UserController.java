package com.feng.web.controller.user;

import com.feng.web.domain.User;
import com.feng.web.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/11.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String hello() {
        userService.insertUser();
        return "/index.html";
    }

    @RequestMapping("all")
    @ResponseBody
    public PageInfo getAll() {
        HashMap<String, Object> map = Maps.newHashMap();
        PageInfo page = userService.findAll();

        return page;
    }

    @RequestMapping("null")
    @ResponseBody
    public Map<String, Object> getNull() {
        return userService.findNull();
    }
}
