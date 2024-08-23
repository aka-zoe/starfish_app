package com.zoe.starfish_server.utils;

import java.util.Random;

/**
 * 生成用户的唯一ID用于IM注册
 */
public class PIDUtils {
    public static  String generatePID() {
        Random random = new Random();
        StringBuilder qqNumber = new StringBuilder();

        // 生成第一位数字，不能为0
        qqNumber.append(random.nextInt(9) + 1);

        // 生成剩余位数的数字
        for (int i = 1; i < 8; i++) {
            qqNumber.append(random.nextInt(10));
        }

        return qqNumber.toString();
    }

    public static void main(String[] args) {
        String pid = PIDUtils.generatePID();
        System.out.println(pid);
    }
}
