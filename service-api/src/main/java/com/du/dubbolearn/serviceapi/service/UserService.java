package com.du.dubbolearn.serviceapi.service;

import com.du.dubbolearn.serviceapi.pojo.User;

public interface UserService {
    Long addUser(User user) throws Exception;
}
