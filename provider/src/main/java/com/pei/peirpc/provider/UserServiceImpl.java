package com.pei.peirpc.provider;

import com.pei.peirpc.common.model.User;
import com.pei.peirpc.common.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
