package com.pei.peirpc.provider;

import com.pei.peirpc.common.service.UserService;
import com.pei.peirpc.registry.LocalRegistry;
import com.pei.peirpc.server.HttpServer;
import com.pei.peirpc.server.VertxHttpServer;

public class EasyProvider {
    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
