package com.huwei.dailytest.jishiTest;

import java.util.*;
import java.util.stream.Collectors;

public class Day0221 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        test1();
        test2();
    }

    /**
     * 有一个简易内存池，内存按照大小粒度分类
     * 每个粒度有若干个可用内存资源
     * 用户会进行一系列内存申请
     * 需要按需分配内存池中的资源
     * 返回申请结果成功失败列表
     * 分配规则如下
     * 1.分配的内存要大于等于内存的申请量
     * 存在满足需求的内存就必须分配
     * 优先分配粒度小的，但内存不能拆分使用
     * 2.需要按申请顺序分配
     * 先申请的先分配，有可用内存分配则申请结果为true
     * 没有可用则返回false
     * 注释：不考虑内存释放
     * <p>
     * 输入描述
     * 输入为两行字符串
     * 第一行为内存池资源列表
     * 包含内存粒度数据信息，粒度数据间用逗号分割
     * 一个粒度信息内用冒号分割
     * 冒号前为内存粒度大小，冒号后为数量
     * 资源列表不大于1024
     * 每个粒度的数量不大于4096
     * <p>
     * 第二行为申请列表
     * 申请的内存大小间用逗号分割，申请列表不大于100000
     * <p>
     * 如
     * 64:2,128:1,32:4,1:128
     * 50,36,64,128,127
     * <p>
     * 输出描述
     * 输出为内存池分配结果
     * 如true,true,true,false,false
     * <p>
     * 示例一：
     * 输入：
     * 64:2,128:1,32:4,1:128
     * 50,36,64,128,127
     * 输出：
     * true,true,true,false,false
     * <p>
     * 说明:
     * 内存池资源包含：64k共2个、128k共1个、32k共4个、1k共128个的内存资源
     * 针对50,36,64,128,127的内存申请序列，
     * 分配的内存依次是，64,64,128,null,null
     * 第三次申请内存时已经将128分配出去，因此输出的结果是
     * true,true,true,false,false
     */
    private static void test2() {
        String[] split = scanner.nextLine().split(",");
        List<Integer> collect = Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt).collect(Collectors.toList());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(":");
            map.put(Integer.parseInt(split1[0]), Integer.parseInt(split1[1]));
        }
        List<Integer> list = map.keySet().stream().sorted().collect(Collectors.toList());
        Integer max = list.get(list.size() - 1);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < collect.size(); i++) {
            Integer apply = collect.get(i);
            if (apply > max) {
                sb.append("false,");
                continue;
            }
            for (int j = 0; j < list.size(); j++) {
                Integer key = list.get(j);
                if (apply <= key) {
                    Integer value = map.get(key);
                    if (value > 0) {
                        sb.append("true").append(",");
                        map.put(key, value - 1);
                        break;
                    } else {
                        if (j == list.size() - 1) {
                            sb.append("false").append(",");
                        }
                    }

                }
            }
        }
        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }

    private static void test1() {
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).sorted().collect(Collectors.toList());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Integer key = list.get(i);
            Integer orDefault = map.getOrDefault(key, 0);
            map.put(key, orDefault + 1);
        }

        // map 按value排序
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        List<Map.Entry<Integer, Integer>> list1 = new ArrayList<>(entries);
        list1.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        List<Integer> zs = new ArrayList<>();
        Integer value = list1.get(0).getValue();
        zs.add(list1.get(0).getKey());
        for (int i = 1; i < list1.size(); i++) {
            if (list1.get(i).getValue() < value) {
                break;
            } else {
                zs.add(list1.get(i).getKey());
            }
        }
        zs.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int i = zs.size() / 2;
        if (zs.size() % 2 == 1) {
            System.out.println(zs.get(i));
        } else {
            System.out.println((zs.get(i - 1) + zs.get(i)) / 2);
        }

    }
}
