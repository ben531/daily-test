package com.huwei.dailytest.jishiTest;

import java.util.*;
import java.util.stream.Collectors;

public class Day0214 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        test53();
        test52();
    }

    /**
     * 磁盘的容量单位有M,G,T这三个等级
     * 他们之间的换算关系为
     * 1T=1024G
     * 1G=1024M
     * 现在给定N块磁盘的容量
     * 请对他们按从小到大的顺序进行稳定排序
     * 例如给定5块盘容量
     * 1T,20M,3G,10G6T,3M12G9M
     * 排序后的结果为20M,3G,3M12G9M,1T,10G6T
     * <p>
     * 注意单位可以重复出现
     * 上述3M12G9M为 3M+12G+9M和 12M12G相等
     * <p>
     * 输入描述:
     * 输入第一行包含一个整数N
     * 2<=N<=100 ,表示磁盘的个数
     * 接下来的N行每行一个字符串 长度 (2<l<30)
     * 表示磁盘的容量
     * 有一个或多个格式为 mv的子串组成
     * 其中m表示容量大小 v表示容量单位
     * 例如
     * <p>
     * 磁盘容量m的范围 1~1024正整数
     * 容量单位v的范围包含题目中提到的M,G,T
     * <p>
     * 输出描述:
     * 输出N行
     * 表示N块磁盘容量排序后的结果
     * <p>
     * 示例1:
     * 输入
     * 3
     * 1G
     * 2G
     * 1024M
     * <p>
     * 输出
     * 1G
     * 1024M
     * 2G
     * <p>
     * 说明 1G和1024M容量相等,稳定排序要求保留他们原来的相对位置
     * 故1G在1024M前
     * <p>
     * 示例二:
     * 输入
     * 3
     * 2G4M
     * 3M2G
     * 1T
     * <p>
     * 输出
     * 3M2G
     * 2G4M
     * 1T
     * 说明1T大于2G4M大于3M2G
     */
    private static void test52() {
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Test52_2> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = scanner.nextLine();
                list.add(test52_1(s));
            }
            list.sort(new Comparator<Test52_2>() {
                @Override
                public int compare(Test52_2 o1, Test52_2 o2) {
                    if (o1.t != o2.t) {
                        return o1.t - o2.t;
                    }
                    if (o1.g != o2.g) {
                        return o1.g - o2.g;
                    }
                    if (o1.m != o2.m) {
                        return o1.m - o2.m;
                    }
                    return 0;
                }
            });

            list.forEach(e -> System.out.println(e.str));
        }
    }

    private static void tet52_3() {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        ArrayList<String> sizes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            sizes.add(in.nextLine());
        }
        in.close();
        sizes.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Long.compare(parseLong(o1), parseLong(o2));
            }
        });

        sizes.forEach(System.out::println);
    }

    static Long parseLong(String size) {
        String[] units = size.split("[0-9]+");
        String[] nums = size.split("[A-Z]+");
        //[, M, G, M]
        //[3, 12, 9]

        long sum = 0;
        for (int i = 1; i < units.length; i++) {
            long num = Long.parseLong(nums[i - 1]);
            switch (units[i]) {
                case "M":
                    sum += num;
                    break;
                case "G":
                    sum += num * 1024;
                    break;
                case "T":
                    sum += num * 1024 * 1024;
                    break;
            }
        }

        return sum;
    }

    static class Test52_2 {
        int m;
        int g;
        int t;
        String str;

        public Test52_2(int m, int g, int t, String str) {
            this.m = m;
            this.g = g;
            this.t = t;
            this.str = str;
        }

    }

    private static Test52_2 test52_1(String str) {
        Test52_2 test = new Test52_2(0, 0, 0, str);
        int begin = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                int n = Integer.parseInt(str.substring(begin, i));
                begin = i + 1;
                switch (c) {
                    case 'M':
                        if (n >= 1024) {
                            int i1 = n / 1024;
                            test.g += i1;
                            test.m += n % 1024;
                        } else {
                            test.m += n;
                        }
                        break;
                    case 'G':
                        if (n >= 1024) {
                            int i1 = n / 1024;
                            test.t += i1;
                            test.g += n % 1024;
                        } else {
                            test.g += n;
                        }
                        break;
                    case 'T':
                        test.t += n;
                        break;
                    default:
                        break;
                }
            }
        }
        return test;
    }

    /**
     * 停车场有一横排车位0代表没有停车,1代表有车.
     * 至少停了一辆车在车位上,也至少有一个空位没有停车.
     * 为防止刮蹭,需为停车人找到一个车位
     * 使得停车人的车最近的车辆的距离是最大的
     * 返回此时的最大距离
     * <p>
     * 输入描述:
     * 1. 一个用半角逗号分割的停车标识字符串,停车标识为0或1,
     * 0为空位,1为已停车
     * 2. 停车位最多有100个
     * <p>
     * 输出描述
     * 1. 输出一个整数记录最大距离
     * <p>
     * 示例一:
     * 输入
     * 1,0,0,0,0,1,0,0,1,0,1
     * <p>
     * 0,0,1,1,0,0
     * 输出
     * 2
     * <p>
     * 说明
     * 当车停在第三个位置上时,离其最近的车距离为2(1~3)
     * 当车停在第四个位置上时,离其最近的车距离为2(4~6)
     * 其他位置距离为1
     * 因此最大距离为2
     */
    private static void test53() {
        while (scanner.hasNext()) {
            List<Integer> collect = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
            int max = Integer.MIN_VALUE;
            // 1,0,0,0,0,1,0,0,1,0,1
            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i) == 1) {
                    continue;
                }
                int j = i + 1;
                int k = i - 1;
                int lTemp = 1;
                while (k >= 0 && collect.get(k) != 1) {
                    lTemp++;
                    k--;
                }
                int rTemp = 1;
                while (j < collect.size() && collect.get(j) != 1) {
                    rTemp++;
                    j++;
                }
                if (i == 0) {
                    max = Math.max(max, rTemp);
                } else if (i == collect.size() - 1) {
                    max = Math.max(max, lTemp);
                } else {
                    max = Math.max(max, Math.min(lTemp, rTemp));
                }
            }
            System.out.println(max);
        }

    }
}
