package com.feng.web.mapper.apis;

import com.feng.web.domain.apis.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2017/3/11.
 */
@Mapper
public interface StudentMapper {
    void insert(Student user);
}
