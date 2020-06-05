package com.huwei.dailytest.collection;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {

        Map<Integer, List<String>> hashMap = new HashMap<Integer, List<String>>() {

            {
                put(1, new ArrayList<String>() {
                    {
                        add("a");
                    }
                });
                put(2, new ArrayList<String>() {
                    {
                        add("c");
                        add("d");
                    }
                });
            }
        };

        for (Map.Entry<Integer, List<String>> entry : hashMap.entrySet()) {
            List<String> value = entry.getValue();
            Iterator<String> iterator = value.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                if (next.equals("a")) {
                    iterator.remove();
                }
            }
        }
        hashMap.forEach((k, v) -> {
            System.out.println(k + "->" + v);
        });


//        HashMap<String, String> hashMap = new HashMap<String, String>() {
//            {
//                put("姓名", "张三");
//                put("性别", "男");
//                put("年龄", "22");
//            }
//        };


//        hashMap.forEach((k, v) -> {
//            System.out.println(k + ":" + v);
//        });

//        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
//            if (entry.getKey().equals("年龄")) {
//                hashMap.remove(entry.getKey());
//            }
////            System.out.println(entry.getKey() + "->" + entry.getValue());
//        }

//        for (String key : hashMap.keySet()) {
//            System.out.println(key + " >>> " + hashMap.get(key));
//        }


    }
}
