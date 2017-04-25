package com.feng.web.domain.user;

import org.joda.time.DateTime;

/**
 * Created by Administrator on 2017/3/11.
 */
public class User {

    private String name;
    private int age;
    private DateTime createdAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }
}
