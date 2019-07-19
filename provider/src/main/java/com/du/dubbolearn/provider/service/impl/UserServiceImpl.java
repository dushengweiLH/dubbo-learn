package com.du.dubbolearn.provider.service.impl;

import com.du.dubbolearn.provider.dao.UserDao;
import com.du.dubbolearn.serviceapi.pojo.User;
import com.du.dubbolearn.serviceapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dushengwei@duoshengbu.com
 * @since 2019/7/18
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Long addUser(User user) throws Exception {
        return userDao.addUser(user);
    }
}
