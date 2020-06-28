package com.huwei.dailytest.collection;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;
import java.util.Map;

public class HashMapTest {

    // @NotNull注解在这里没什么卵用
    public static boolean isEmpty(@NotNull Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static void main(String[] args) {

        Map<String, String> map = null;
        boolean empty = isEmpty(map);
        System.out.println(empty);


//        List<User> list = new ArrayList<User>(){
//            {
//                add(new User("zz",11));
//                add(new User("zz",19));
//                add(new User("ls",23));
//                add(new User("ww",15));
//            }
//        };
//        // u.getName必须唯一
//        Map<String, User> collect = list.stream().collect(Collectors.toMap(u -> u.getName(), Function.identity()));
//        collect.forEach((k,v)->{
//            System.out.println(k+"->"+v);
//        });

//        Map<Integer, List<String>> hashMap = new HashMap<Integer, List<String>>() {
//            {
//                put(1, new ArrayList<String>() {
//                    {
//                        add("a");
//                    }
//                });
//                put(2, new ArrayList<String>() {
//                    {
//                        add("c");
//                        add("d");
//                    }
//                });
//            }
//        };
//        boolean empty = hashMap.isEmpty();
//
//        // 操作iterater时,可以remove某个对象
//        for (Map.Entry<Integer, List<String>> entry : hashMap.entrySet()) {
//            List<String> value = entry.getValue();
//            Iterator<String> iterator = value.iterator();
//            while (iterator.hasNext()) {
//                String next = iterator.next();
//                if (next.equals("a")) {
//                    iterator.remove();
//                }
//            }
//        }
//        hashMap.forEach((k, v) -> {
//            System.out.println(k + "->" + v);
//        });

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
