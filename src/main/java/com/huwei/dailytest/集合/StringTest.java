package com.huwei.dailytest.集合;

import cn.hutool.core.util.StrUtil;

import java.util.Arrays;

/**
 * jdk的split方法与hutool的split方法不同
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "a,,b,c";
        String[] split = str.split(",");
        System.out.println(split.length);
        System.out.println(Arrays.asList(split));

        str = "a,b,c,,";
        String[] split1 = str.split(",");
        System.out.println(split1.length);
        System.out.println(Arrays.asList(split1));

        String[] split2 = StrUtil.split(str, ",");
        System.out.println(split2.length);
        System.out.println(Arrays.asList(split2));


    }
}
