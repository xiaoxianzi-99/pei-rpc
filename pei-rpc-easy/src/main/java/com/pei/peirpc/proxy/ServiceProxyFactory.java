package com.pei.peirpc.proxy;

import java.lang.reflect.Proxy;

/**
 * @author 帕斯卡的芦苇
 * @date 2024/10/30
 * @description ServiceProxyFactory
 **/

/**
 * 服务代理工厂（用于创建代理对象）
 */
public class ServiceProxyFactory {
    /**
     * 根据服务类获取代理对象
     *
     * @param serviceClass
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy());
    }
}
