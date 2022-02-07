package com.huwei.dailytest.niuke;

import java.util.*;

public class Day0204 {
    public static void main(String[] args) {
//        test6();
        test7();
    }

    /**
     * 字符串截取
     */
    private static void test7() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String n = scanner.nextLine();
            int parseInt = Integer.parseInt(n);
            System.out.println(str.substring(0, parseInt));

        }
    }

    /**
     * 名字的漂亮度
     */
    private static void test6() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            int n = Integer.parseInt(string);
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                char[] chars = line.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (hashMap.containsKey(chars[j])) {
                        hashMap.put(chars[j], hashMap.get(chars[j]) + 1);
                    } else {
                        hashMap.put(chars[j], 1);
                    }
                }


                List<Map.Entry<Character, Integer>> list = new ArrayList<>(hashMap.entrySet());
                list.sort(new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                });

                int result = 0;
                for (int j = 0, k = 26; j < list.size(); j++) {
                    result += list.get(j).getValue() * k;
                    k--;
                }
                hashMap.clear();
                System.out.println(result);
            }
        }
    }

    /**
     * 统计字符
     */
    private void test5() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            int n1 = 0, n2 = 0, n3 = 0, n4 = 0; //英文字符/空格/数字/其他字符
            for (int i = 0; i < chars.length; i++) {
                if (Character.isLetter(chars[i])) {
                    n1++;
                } else if (Character.isSpaceChar(chars[i])) {
                    n2++;
                } else if (Character.isDigit(chars[i])) {
                    n3++;
                } else {
                    n4++;
                }

            }
            System.out.println(n1);
            System.out.println(n2);
            System.out.println(n3);
            System.out.println(n4);
        }
    }

    /**
     * 小球弹跳
     */
    private static void test4() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String h = scanner.nextLine(); // 高度
            String nstr = scanner.nextLine(); // 高度
            int n = Integer.parseInt(nstr); // 弹跳几次
            double h1 = Double.parseDouble(h); //弹跳的距离
            double temp = h1 / 2;   // 弹跳多高
            for (int i = 1; i < n; i++) {
                h1 += temp * 2;
                temp = temp / 2;
            }
            System.out.println(h1);
            System.out.println(temp);

//            System.out.println(String.format("%6f", 2.875 * h));
//            System.out.println(String.format("%6f", 0.03125 * h));
        }
    }

    /**
     * 字符串加密
     */
    private void test3() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String key = scanner.nextLine(); // key
            String str = scanner.nextLine(); // 明文
            char[] chars1 = str.toCharArray();
            char[] chars = key.toCharArray();
            char[] ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            ArrayList<Character> list = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                if (!list.contains(chars[i])) {
                    list.add(chars[i]);
                }
            }

            for (int i = 0; i < ch.length; i++) {
                if (!list.contains(ch[i])) {
                    list.add(ch[i]);
                }
            }

            HashMap<Character, Character> hashMap = new HashMap<>();
            for (int i = 0; i < ch.length; i++) {
                hashMap.put(ch[i], list.get(i));
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars1.length; i++) {
                sb.append(hashMap.get(chars1[i]));
            }
            System.out.println(sb.toString());
        }
    }

    /**
     * 图片整理
     */
    private void test2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ch.length; i++) {
                sb.append(ch[i]);
            }
            System.out.println(sb.toString());
        }
    }

    /**
     * 字符串排序
     */
    private void test1() {
        //输入： Type 输出： epTy
        //输入： BabA 输出： aABb
        //输入： By?e 输出： Be?y
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            char[] ch = line.toCharArray();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < ch.length; i++) {
                if (Character.isLetter(ch[i])) {
                    list.add(ch[i]);
                }
            }
            list.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return Character.toLowerCase(o1) - Character.toLowerCase(o2);
                }
            });

            for (int i = 0; i < ch.length; i++) {
                if (!Character.isLetter(ch[i])) {
                    list.add(i, ch[i]);
                }
            }
            StringBuilder sb = new StringBuilder();
            list.forEach(c -> sb.append(c));
            System.out.println(sb.toString());
        }
    }
}
