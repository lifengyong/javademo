package com.neu.lify.data.batch.common.util;

import java.util.UUID;

public class UUIDGenerator {

    public static String getUUID() {
        // 去掉"-"符号
        return UUID.randomUUID().toString().replace("-", "");
    }

    //获得指定数量的UUID
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] uuid = new String[number];
        for (int i = 0; i < number; i++) {
            uuid[i] = getUUID();
        }
        return uuid;
    }
}
