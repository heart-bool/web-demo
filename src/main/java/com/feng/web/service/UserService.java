package com.feng.web.service;

import com.feng.web.domain.User;
import com.feng.web.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/11.
 */
@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insertUser() {
        User user = new User();
        user.setName("123");
        user.setAge(10);
        userMapper.insert(user);
    }
}
