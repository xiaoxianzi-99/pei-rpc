package com.pei.peirpc.server;

import io.vertx.core.Vertx;

public class VertxHttpServer implements HttpServer {

    public void doStart(int port) {
        //创建Vertx实例
        Vertx vertx = Vertx.vertx();
        //创建http服务器
        io.vertx.core.http.HttpServer server = vertx.createHttpServer();
        //监听端口并处理请求
        server.requestHandler(request -> {
            //处理http请求
            System.out.println("Received request: " + request.method() + " " + request.uri());
            //发送http响应
            request.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x HTTP server!");
        });
        //启动http服务器并监听指定端口
        server.listen(port,result->{
            if(result.succeeded()){
                System.out.println("Vert.x HTTP server started on port " + port);
            }else {
                System.err.println("Vert.x HTTP server failed to start on port " + result.cause());
            }
        });
    }
}
