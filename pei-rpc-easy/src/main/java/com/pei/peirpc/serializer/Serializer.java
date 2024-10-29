package com.pei.peirpc.serializer;

/*
 * @author 帕斯卡的芦苇
 * @date 2024/10/29
 * @description Serializer
 */

import java.io.IOException;

/**
 * 序列化器接口
 * */
public interface Serializer {
    /**
     * 序列化
     */

    <T> byte[] serialize(T object)throws IOException;
    /**
     * 反序列化
     */
    <T> T deserialize(byte[] bytes, Class<T> type)throws IOException;
}
