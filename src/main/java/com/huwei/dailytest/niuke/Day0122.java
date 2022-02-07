package com.huwei.dailytest.niuke;

import java.util.*;
import java.util.stream.Collectors;

public class Day0122 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String n = scanner.nextLine();
            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < Integer.parseInt(n); i++) {
                String line = scanner.nextLine();
                String[] split = line.split(" ");
                int key = Integer.parseInt(split[0]);
                int value = Integer.parseInt(split[1]);
                if (hashMap.containsKey(key)) {
                    hashMap.put(key, hashMap.get(key) + value);
                } else {
                    hashMap.put(key, value);
                }
            }

            List<Integer> collect = hashMap.keySet().stream().sorted().collect(Collectors.toList());
            LinkedHashMap<Integer, Integer> newMap = new LinkedHashMap<>();
            for (int i = 0; i < collect.size(); i++) {
                newMap.put(collect.get(i), hashMap.get(collect.get(i)));
            }
            newMap.forEach((k, v) -> {
                System.out.println(k + " " + v);
            });
        }
    }

    private void test1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            String substring = nextLine.substring(2);
            int i = Integer.parseInt(substring, 16);
            System.out.println(i + "");
        }
    }

    private void test2() {
        Scanner scanner = new Scanner(System.in);
        double f = scanner.nextFloat();
        System.out.println(Math.round(f));
    }

}
