package com.du.dubbolearn.provider.controller;

import com.du.dubbolearn.serviceapi.pojo.User;
import com.du.dubbolearn.serviceapi.service.UserService;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dushengwei@duoshengbu.com
 * @since 2019/7/18
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addUser(@RequestBody User user) {
        log.info("user---------------: {}", user);
        Long id = null;
        try {
            id = userService.addUser(user);
        } catch (Exception e) {
            log.error("error: {}", e);
            return ImmutableMap.of("status", 201, "mess", "fail", "id", id);
        }

        return ImmutableMap.of("status", 200, "mess", "ok", "id", id);
    }
}
