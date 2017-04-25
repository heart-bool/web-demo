/**
 * Created by Heart_Bool on 2017/4/26.
 */
package com.feng.web.domain.apis;

import org.joda.time.DateTime;

/***
 * Description: 
 *
 * @AUTHOR: HEART_BOOL
 * @EMAIL: 18908069164@163.com
 * @DATE: 2017/4/26 0:17
 */
public class Student {


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
