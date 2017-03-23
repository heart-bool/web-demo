package com.feng.web.service;

import com.feng.web.domain.User;
import com.feng.web.mapper.user.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */
@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insertUser() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("123"+i);
            user.setAge(i);
            userMapper.insert(user);
        }

    }

    public List<User> findAll() {
        Page page = PageHelper.startPage(1, 10);

        userMapper.findAll();
        return page;
    }
}
