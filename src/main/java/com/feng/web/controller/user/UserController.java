package com.feng.web.controller.user;

import com.feng.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return "index.html";
    }
}
