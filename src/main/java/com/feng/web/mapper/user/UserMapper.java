package com.feng.web.mapper.user;

import com.feng.web.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2017/3/11.
 */
@Mapper
public interface UserMapper {
    void insert(User user);
}
