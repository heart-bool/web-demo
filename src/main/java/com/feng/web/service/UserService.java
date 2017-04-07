package com.feng.web.service;

import com.feng.web.domain.User;
import com.feng.web.mapper.user.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/3/11.
 */
@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insertUser() {

        ExecutorService service = Executors.newFixedThreadPool(10);
        AtomicInteger incr = new AtomicInteger(0);


        incr.incrementAndGet();
        service.execute(new Runnable() {
            boolean is = true;

            @Override
            public void run() {
                while (is) {
                    User user = new User();
                    user.setName("zhangsan");
                    user.setAge(33);
                    user.setCreatedAt(DateTime.now());
                    userMapper.insert(user);
                    if (incr.incrementAndGet() == 100000) {
                        is = false;
                    }
                }
            }
        });

    }

    public PageInfo<List<User>> findAll() {
        Page page = PageHelper.startPage(4, 10);

        userMapper.findAll();
        return page.toPageInfo();
    }

    public HashMap<String, Object> findNull() {
        Page page = PageHelper.startPage(1, 3);
        List<User> users = userMapper.findNull();
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("pageSize", page.getPageSize());
        map.put("total", page.getTotal());
        map.put("pageNum", page.getPageNum());
        map.put("pages", page.getPages());
        map.put("result", users);
        users.forEach(user -> System.out.println(user.getCreatedAt()));

        return map;
    }
}
