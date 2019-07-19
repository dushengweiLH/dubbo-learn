package com.du.dubbolearn.consumer;

import com.du.dubbolearn.serviceapi.pojo.User;
import com.du.dubbolearn.serviceapi.service.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {}

    @Test
    public void t() {
        try {
            int i = 0;
            while (i < 30) {
                System.out.println(userService.addUser(new User().setName("kl").setAge(19)));
                //Thread.sleep(2000);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t1() {
        CollectionUtils.isNotEmpty(null);
    }
}
