package com.huwei.dailytest.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>() {
            {
                put("姓名", "张三");
                put("性别", "男");
                put("年龄", "22");
            }
        };

        hashMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        for (Map.Entry<String, String> entry :
                hashMap.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        for (String key :
                hashMap.keySet()) {
            System.out.println(key + " >>> " + hashMap.get(key));
        }

        List<String> collect = hashMap.values().stream().collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
