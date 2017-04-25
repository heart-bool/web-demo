package com.feng.web.controller.user;

import com.feng.web.domain.apis.Student;
import com.feng.web.mapper.apis.StudentMapper;
import com.feng.web.service.UserService;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/11.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentMapper studentMapper;

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

    @RequestMapping("stu")
    public String insert() {
        Student student = new Student();
        student.setAge(10);
        student.setName("sadas");
        student.setCreatedAt(new DateTime());
        studentMapper.insert(student);
        return null;
    }
}
