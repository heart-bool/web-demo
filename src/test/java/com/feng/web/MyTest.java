/**
 * Created by Administrator on 2017/3/12.
 */

package com.feng.web;

import com.feng.web.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 *
 * @Author: Heart_Bool / FENG WANG
 * @Email: <email>18908069164@163.com</email>
 * @Date: 2017/3/12 22:41
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class MyTest {

    @Autowired
    UserService userService;

    @Test
    public void exampleTest() {
        userService.insertUser();
    }

}
