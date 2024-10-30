package com.pei.peirpc;

import com.pei.peirpc.common.model.User;
import com.pei.peirpc.common.service.UserService;
import com.pei.peirpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
//        // 动态代理
//        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        // 静态代理
        UserService userService = new UserServiceProxy();
        User user = new User();
        user.setName("yupi");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
