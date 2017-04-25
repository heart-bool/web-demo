package com.feng.web.mapper.user;

import com.feng.web.domain.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */
@Mapper
public interface UserMapper {
    void insert(User user);

    List<User> findAll();

    List<User> findNull();
}
