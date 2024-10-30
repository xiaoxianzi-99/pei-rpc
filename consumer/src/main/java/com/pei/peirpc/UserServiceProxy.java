package com.pei.peirpc;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.pei.peirpc.common.model.User;
import com.pei.peirpc.common.service.UserService;
import com.pei.peirpc.model.RpcRequest;
import com.pei.peirpc.model.RpcResponse;
import com.pei.peirpc.serializer.JdkSerializer;
import com.pei.peirpc.serializer.Serializer;

import java.io.IOException;

/**
 * @author 帕斯卡的芦苇
 * @date 2024/10/30
 * @description UserServiceProxy
 **/

/**
 * 静态代理
 */
public class UserServiceProxy implements UserService {
    @Override
    public User getUser(User user) {
        //指定序列化器
        Serializer serializer = new JdkSerializer();

        //发送请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
        .args(new Object[]{user}).build();

        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()) {
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
