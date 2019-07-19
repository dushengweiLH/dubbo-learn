package com.du.dubbolearn.consumer.controller;

import com.du.dubbolearn.serviceapi.pojo.User;
import com.du.dubbolearn.serviceapi.service.UserService;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dushengwei@duoshengbu.com
 * @since 2019/7/19
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add() {
        Long id = null;
        try {
            id = userService.addUser(new User().setName("kl").setAge(19));
        } catch (Exception e) {
            log.error("error: {}", e);
        }

        return ImmutableMap.of("id",id);

    }
}
