package com.huwei.dailytest.jishiTest;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Day0220 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        test9();
        test10();
    }

    /**
     * 用数组代表每个人的能力
     * 一个比赛活动要求 参赛团队的最低能力值为N
     * 每个团队可以由一人或者两人组成
     * 且一个人只能参加一个团队
     * 计算出最多可以派出多少只符合要求的队伍
     * <p>
     * 输入描述
     * 5
     * 3 1 5 7 9
     * 8
     * 第一行代表总人数，范围  1~500000
     * 第二行数组代表每个人的能力
     * 数组大小范围 1~500000
     * 元素取值范围 1~500000
     * 第三行数值为团队要求的最低能力值
     * 1~500000
     * <p>
     * 输出描述
     * 3
     * 最多可以派出的团队数量
     * <p>
     * 示例一
     * 输入
     * 5
     * 3 1 5 7 9
     * 8
     * <p>
     * 输出
     * 3
     * <p>
     * 说明 3、5组成一队   1、7一队  9自己一队  输出3
     * <p>
     * 7
     * 3 1 5 7 9 2 6
     * 8
     * <p>
     * 3
     * 1 1 9
     * 8
     */
    private static void test10() {
        int m = Integer.parseInt(scanner.nextLine());
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).sorted().collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> collect = list.stream().filter(e -> e < n).sorted().collect(Collectors.toList());
        long count = list.size() - collect.size();

        int i = 0;
        int j = collect.size() - 1;
        while (i < j) {
            if ((collect.get(i) + collect.get(j)) >= n) {
                count++;
                i++;
                j--;
            } else {
                i++;
            }
        }

//        for (int i = 0; i < collect.size(); i++) {
//            Integer integer = collect.get(0);
//            Integer integer1 = collect.get(collect.size() - 1);
//            if ((integer + integer1) >= n) {
//                count++;
//                collect.remove(0);
//                collect.remove(collect.size() - 1);
//                i = -1;
//            } else {
//                collect.remove(0);
//                i = -1;
//            }
//        }

        System.out.println(count);

    }

    /**
     * 给定一个url前缀和url后缀
     * 通过,分割 需要将其连接为一个完整的url
     * 如果前缀结尾和后缀开头都没有/
     * 需要自动补上/连接符
     * 如果前缀结尾和后缀开头都为/
     * 需要自动去重
     * 约束：
     * 不用考虑前后缀URL不合法情况
     * <p>
     * 输入描述
     * url前缀(一个长度小于100的字符串)
     * url后缀(一个长度小于100的字符串)
     * 输出描述
     * 拼接后的url
     * <p>
     * 一、
     * 输入
     * /acm,/bb
     * 输出
     * /acm/bb
     * <p>
     * 二、
     * 输入
     * /abc/,/bcd
     * 输出
     * /abc/bcd
     * <p>
     * 三、
     * 输入
     * /acd,bef
     * 输出
     * /acd/bef
     * <p>
     * 四、
     * 输入
     * ,
     * 输出
     * /
     */
    private static void test9() {
        String[] split = scanner.nextLine().split(",");
        if (split.length == 0) {
            System.out.println("/");
            return;
        }

        String str = split[0] + "/" + split[1];
        String url = str.replaceAll("[/]+", "/");
        System.out.println(url);


//        if (split.length == 1) {
//            String s = split[0];
//            if (s.endsWith("/")) {
//                System.out.println(s);
//            } else {
//                System.out.println(s + "/");
//            }
//            return;
//        }
//        String str1 = split[0];
//        String str2 = split[1];
//
//        if ((str1.endsWith("/") && !str2.startsWith("/"))
//                || (!str1.endsWith("/") && str2.startsWith("/"))) {
//            System.out.println(str1 + str2);
//        } else if (str1.endsWith("/") && str2.startsWith("/")) {
//            if (str1.length() > str2.length()) {
//                System.out.println(str1.substring(0, str1.length() - 1) + str2);
//            } else if (str1.length() == str2.length()) {
//                System.out.println("/");
//            } else {
//                System.out.println(str1 + str2.substring(1));
//            }
//        } else if (!str1.endsWith("/") && !str2.startsWith("/")) {
//            System.out.println(str1 + "/" + str2);
//        }
    }

    /**
     * 有一个数列A[n]
     * 从A[0]开始每一项都是一个数字
     * 数列中A[n+1]都是A[n]的描述
     * 其中A[0]=1
     * 规则如下
     * A[0]:1
     * A[1]:11 含义其中A[0]=1是1个1 即11
     * 表示A[0]从左到右连续出现了1次1
     * A[2]:21 含义其中A[1]=11是2个1 即21
     * 表示A[1]从左到右连续出现了2次1
     * A[3]:1211 含义其中A[2]从左到右是由一个2和一个1组成 即1211
     * 表示A[2]从左到右连续出现了一次2又连续出现了一次1
     * A[4]:111221  含义A[3]=1211 从左到右是由一个1和一个2两个1 即111221
     * 表示A[3]从左到右连续出现了一次1又连续出现了一次2又连续出现了2次1
     * <p>
     * 输出第n项的结果
     * 0<= n <=59
     * 输入描述：
     * 数列第n项   0<= n <=59
     * 4
     * 输出描述
     * 数列内容
     * 111221
     */
    private static void test8() {
        // A0 = 1
        // A1 = 11
        // A2 = 21
        // A3 = 1211
        // A4 = 111221
        // A5 = 312211
        // A6 = 13112221
        // A7 = 1113213211
        // A8 = 31131211131221
        int m = scanner.nextInt();
        String first = "1";
        if (m == 1) {
            System.out.println(first);
            return;
        }
        StringBuffer next = new StringBuffer();
        for (int i = 1; i <= m; i++) {
            char[] chars = first.toCharArray();
            char c = chars[0];
            int count = 1;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] == c) {
                    count++;
                } else {
                    next.append(count).append(c);
                    c = chars[j];
                    count = 1;
                }
            }
            next.append(count).append(c);
            first = next.toString();
            next.setLength(0);
        }
        System.out.println(first);
    }

    /**
     * 幼儿园两个班的小朋友排队时混在了一起
     * 每个小朋友都知道自己跟前面一个小朋友是不是同班
     * 请你帮忙把同班的小朋友找出来
     * 小朋友的编号为整数
     * 与前面一个小朋友同班用Y表示
     * 不同班用N表示
     * 输入描述：
     * 输入为空格分开的小朋友编号和是否同班标志
     * 比如 6/N 2/Y 3/N 4/Y
     * 表示一共有4位小朋友
     * 2和6是同班 3和2不同班 4和3同班
     * 小朋友总数不超过999
     * 0< 每个小朋友编号 <999
     * 不考虑输入格式错误
     * <p>
     * 输出两行
     * 每一行记录一班小朋友的编号  编号用空格分开
     * 并且
     * 1. 编号需要按照大小升序排列，分班记录中第一个编号小的排在第一行
     * 2. 如果只有一个班的小朋友 第二行为空
     * 3. 如果输入不符合要求输出字符串ERROR
     * <p>
     * 示例：
     * 输入
     * 1/N 2/Y 3/N 4/Y
     * 输出
     * 1 2
     * 3 4
     * 说明：2的同班标记为Y因此和1同班
     * 3的同班标记位N因此和1,2不同班
     * 4的同班标记位Y因此和3同班
     */
    private static void test7() {
        List<String> strings = Arrays.asList(scanner.nextLine().split(" "));
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        String s = strings.get(0);
        l1.add(Integer.parseInt(s.split("/")[0]));
        for (int i = 1; i < strings.size(); i++) {
            String[] split = strings.get(i).split("/");
            if (split[1].equals("N")) {
                if (l1.contains(Integer.parseInt(strings.get(i - 1).split("/")[0]))) {
                    l2.add(Integer.parseInt(split[0]));
                } else {
                    l1.add(Integer.parseInt(split[0]));
                }
            } else {
                if (l1.contains(Integer.parseInt(strings.get(i - 1).split("/")[0]))) {
                    l1.add(Integer.parseInt(split[0]));
                } else {
                    l2.add(Integer.parseInt(split[0]));
                }
            }

        }
        l1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        l2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        if (l2.size() == 0) {
            l1.forEach(e -> System.out.print(e + " "));
        } else {
            Integer i1 = l1.get(0);
            Integer i2 = l2.get(0);
            if (i1 < i2) {
                l1.forEach(e -> System.out.print(e + " "));
                System.out.println();
                l2.forEach(e -> System.out.print(e + " "));
            } else {
                l2.forEach(e -> System.out.print(e + " "));
                System.out.println();
                l1.forEach(e -> System.out.print(e + " "));
            }
        }
    }

    /**
     * 给定参数n 从1到n会有n个整数 1，2，3，...n
     * 这n个数字共有n!种排列 按大小顺序升序列出所有排列情况
     * 并一一标记
     * 当n=3时，所有排列如下
     * "123","132","213","231","312","321"
     * 给定n和k 返回第n个排列
     * <p>
     * 输入描述
     * 第一行为n
     * 第二行为k
     * n的范围是 1~9
     * k的范围是 1~n!
     * <p>
     * 输出描述
     * 输出排列第k位置的数字
     * <p>
     * 示例一：
     * 输入
     * 3
     * 3
     * 输出
     * 213
     * <p>
     * 示例二:
     * 输入
     * 2
     * 2
     * 输出
     * 21
     */
    static TreeSet<String> treeSet = new TreeSet<>();

    private static void test6() {
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        Integer[] arr = new Integer[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }
        perm(arr, 0, m - 1);
        ArrayList<String> list = new ArrayList<>(treeSet);
        System.out.println(list.get(k - 1));
    }

    private static void perm(Integer[] arr, int begin, int end) {
        if (begin == end) {
            String s = Arrays.toString(arr).replaceAll("\\W+", "");
            treeSet.add(s);
        } else {
            for (int i = begin; i <= end; i++) {
                swap(arr, begin, i);
                perm(arr, begin + 1, end);
                swap(arr, begin, i);
            }
        }
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * Vlan是一种为局域网设备进行逻辑划分的技术
     * 为了标识不同的vlan 引入了vlan id 1~4094之间的整数
     * 定义一个vlan id 的资源池
     * 资源池中连续的vlan用开始vlan-结束vlan表示，
     * 不连续的用单个整数表示
     * 所有的vlan用英文逗号连接起来
     * 现有一个vlan资源池，业务需要从资源池中申请一个vlan
     * 需要你输出从vlan资源池中移除申请的vlan后的资源池
     * <p>
     * 输入描述
     * 第一行为字符串格式的vlan资源池
     * 第二行为业务要申请的vlan vlan的取值范围1~4094
     * <p>
     * 输出描述
     * 从输入vlan资源池中移除申请的vlan后
     * 字符串格式的vlan资源池
     * 输出要求满足题目中要求的格式，
     * 并且要求从小到大升序输出
     * 如果申请的vlan不在原资源池，输出升序排序的原资源池的字符串即可
     * <p>
     * 示例一
     * 输入
     * 1-5
     * 2
     * 输出
     * 1,3-5
     * 说明：原vlan资源池中有1 2 3 4 5 移除2后
     * 剩下的1 3 4 5按照升序排列的方式为 1 3-5
     * <p>
     * 示例二
     * 输入
     * 20-21,15,18,30,5-10
     * 15
     * 输出
     * 5-10,18,20-21,30
     * 说明：
     * 原vlan资源池中有5 6 7 8 9 10 15 18 20 21 30
     * 移除15后 剩下的为 5 6 7 8 9 10 18 20 21 30
     * 按照题目描述格式并升序后的结果为5-10,18,20-21,30
     * <p>
     * 示例三
     * 输入
     * 5,1-3
     * 10
     * 输出
     * 1-3,5
     * 资源池中有1 2 3 5
     * 申请的资源不在资源池中
     * 将原池升序输出为1-3,5
     * <p>
     * 输入池中vlan数量范围为2~2094的整数
     * 资源池中vlan不重复且合法1~2094的整数
     * 输入是乱序的
     */
    private static void test5() {
        String[] split = scanner.nextLine().split(",");
        Integer m = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s.indexOf("-") != -1) {
                String[] split1 = s.split("-");
                for (int j = Integer.valueOf(split1[0]); j <= Integer.valueOf(split1[1]); j++) {
                    arrayList.add(j);
                }
            } else {
                arrayList.add(Integer.parseInt(s));
            }
        }
        List<Integer> collect = arrayList.stream().distinct().sorted().collect(Collectors.toList());
        collect.remove(m);
        int[] arr = new int[collect.get(collect.size() - 1) + 1];
        collect.forEach(e -> arr[e] = e);
        StringBuffer sb = new StringBuffer();
        // 1,2,0,0,8,0,10
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int j = i;
                while (j < arr.length && arr[j] != 0) {
                    j++;
                }
                if (j > i + 1) {
                    sb.append(arr[i]).append("-").append(arr[j - 1]).append(",");
                } else {
                    sb.append(arr[i]).append(",");
                }
                i = j;
            }
        }
        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }


    /**
     * 实现一个整数编码方法
     * 使得待编码的数字越小
     * 编码后所占用的字节数越小
     * 编码规则如下
     * 1.编码时7位一组，每个字节的低7位用于存储待编码数字的补码
     * 2.字节的最高位表示后续是否还有字节，置1表示后面还有更多的字节，
     * 置0表示当前字节为最后一个字节
     * 3.采用小端序编码，低位和低字节放在低地址上
     * 4.编码结果按16进制数的字符格式进行输出，小写字母需要转化为大写字母
     * <p>
     * 输入描述
     * 输入的为一个字符串表示的非负整数
     * 输出描述
     * 输出一个字符串表示整数编码的16进制码流
     * <p>
     * 示例一
     * 输入
     * 0
     * 输出
     * 00
     * 说明：输出的16进制字符不足两位的前面补零
     * <p>
     * 示例二
     * 输入
     * 100
     * 输出
     * 64
     * 说明:100的二进制表示为0110 0100只需一个字节进行编码
     * 字节的最高位0，剩余7位存储数字100的低7位(1100100)所以编码后的输出为64
     * <p>
     * 示例三
     * 输入
     * 1000
     * 输出
     * E807
     * 说明
     * 1000的二进制表示为 0011 1110 1000 至少需要两个字节进行编码
     * 第一个字节最高位是1 剩余7位存储数字 1000的低7位(1101000)
     * 所以第一个字节的二进制位(1110 1000)即E8
     * 第二个字节最高位置0 剩余的7位存储数字 1000的第二个低7位(0000111)
     * 所以第一个字节的二进制为(0000 0111)即07
     * 采用小端序编码 所以低字节E8输出在前面
     * 高字节07输出在后面
     * <p>
     * 备注
     * 代编码数字取值范围为 [0,1<<64-1]
     */
    private static void test4() {
        while (true) {
            // 1111101000
            int m = scanner.nextInt();
            String mbin = Integer.toBinaryString(m);
            System.out.println(mbin);
            StringBuffer sb1 = new StringBuffer();
            for (int i = mbin.length(); i > 0; i -= 7) {
                int start = Math.max(0, i - 7);
                String substring = mbin.substring(start, i);
                if (substring.length() < 7) {
                    // 1111
                    StringBuffer sb = new StringBuffer();
                    for (int j = 0; j < 7 - substring.length(); j++) {
                        sb.append("0");
                    }
                    substring = sb.append(substring).toString();
                }
                if (i - 7 >= 0) {
                    substring = "1" + substring;
                } else {
                    substring = "0" + substring;
                }
                String s = Integer.toHexString(Integer.valueOf(substring, 2)).toUpperCase();
                if (s.length() < 2) {
                    s = "0" + s;
                }
                sb1.append(s);
            }
            System.out.println(sb1.toString());
        }
    }

    @Test
    public void test() {
        int[] arr1 = {1, 2, 3};
        Integer[] arr2 = {1, 2, 3};
        System.out.println(Arrays.toString(arr1).replaceAll("\\W+", ""));
        System.out.println(Arrays.toString(arr2).replaceAll("\\W+", ""));
    }

    /**
     * 有N个正整数组成的一个序列
     * 给定一个整数sum
     * 求长度最长的的连续子序列使他们的和等于sum
     * 返回此子序列的长度
     * 如果没有满足要求的序列 返回-1
     * 案例1：
     * 输入
     * 1,2,3,4,2
     * 6
     * 输出
     * 3
     * 解析：1,2,3和4,2两个序列均能满足要求
     * 所以最长的连续序列为1,2,3 因此结果为3
     * <p>
     * 示例2：
     * 输入
     * 1,2,3,4,2
     * 20
     * 输出
     * -1
     * 解释：没有满足要求的子序列，返回-1
     * <p>
     * 备注： 输入序列仅由数字和英文逗号构成
     * 数字之间采用英文逗号分割
     * 序列长度   1<=N<=200
     * 输入序列不考虑异常情况
     * 由题目保证输入序列满足要求
     */
    private static void test3() {
        List<Integer> list = Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt).collect(Collectors.toList());
        int m = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int start = 0;
        int end;
        int max = -1;
        for (int i = 0; i < list.size(); i++) {
            if (sum == 0) {
                start = i;
            }
            sum += list.get(i);
            if (sum > m) {
                sum = 0;
                i = start;
            }
            if (sum == m) {
                end = i;
                sum = 0;
                i = start;
                max = Math.max(max, (end - start) + 1);
            }
        }
        System.out.println(max);
    }

    /**
     * 给定一个正整数数组
     * 检查数组中是否存在满足规则的数组组合
     * 规则：
     * A=B+2C
     * 输入描述
     * 第一行输出数组的元素个数
     * 接下来一行输出所有数组元素  用空格隔开
     * 输出描述
     * 如果存在满足要求的数
     * 在同一行里依次输出 规则里 A/B/C的取值 用空格隔开
     * 如果不存在输出0
     * <p>
     * 示例1：
     * 输入
     * 4
     * 2 7 3 0
     * 输出
     * 7 3 2
     * 说明：
     * 7=3+2*2
     * 示例2：
     * 输入
     * 3
     * 1 1 1
     * 输出
     * 0
     * 说明找不到满足条件的组合
     * <p>
     * 备注：
     * 数组长度在3~100之间
     * 数组成员为0~65535
     * 数组成员可以重复
     * 但每个成员只能在结果算式中使用一次
     * 如 数组成员为 [0,0,1,5]
     * 0出现两次允许，但结果0=0+2*0不允许  因为算式中使用了3个0
     * <p>
     * 用例保证每组数字里最多只有一组符合要求的解
     */
    private static void test2() {
        int m = Integer.parseInt(scanner.nextLine());
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).distinct().collect(Collectors.toList());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2 < 0 ? 1 : -1;
            }
        });
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Integer A = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Integer B = list.get(j);
                if ((A - B) % 2 == 0) {
                    int C = (A - B) / 2;
                    if (C != B && list.contains(C)) {
                        strings.add(A + " " + B + " " + C);
                    }
                }

            }
        }
        if (strings.size() == 0) {
            System.out.println(0);
        } else {
            strings.forEach(System.out::println);
        }
    }

    /**
     * 已知火星人使用的运算符号为#;$
     * 其与地球人的等价公式如下
     * x#y=2*x+3*y+4
     * x$y=3*x+y+2
     * x y是无符号整数
     * 地球人公式按照c语言规则进行计算
     * 火星人公式中$符优先级高于#相同的运算符按从左到右的顺序运算
     * <p>
     * 输入描述：
     * 火星人字符串表达式结尾不带回车换行
     * 输入的字符串说明是 字符串为仅有无符号整数和操作符组成的计算表达式
     * <p>
     * 1.用例保证字符串中操作数与操作符之间没有任何分隔符
     * 2.用例保证操作数取值范围为32位无符号整数，
     * 3.保证输入以及计算结果不会出现整型溢出
     * 4.保证输入的字符串为合法的求值报文
     * 例如: 123#4$5#76$78
     * 5.保证不会出现非法的求值报文
     * 例如: #4$5 这种缺少操作数
     * 4$5#  这种缺少操作数
     * 4#$5  这种缺少操作数
     * 4 $5  有空格
     * 3+4-5*6/7 有其他操作符
     * 12345678987654321$54321 32位整数溢出
     * <p>
     * 输出描述：
     * 根据火星人字符串输出计算结果
     * 结尾不带回车换行
     * <p>
     * 案例1：
     * 输入：
     * 7#6$5#12
     * 输出：
     * 226
     * <p>
     * 说明 示例7#6$5#12=7#(3*6+5+2)#12
     * =7#25#12
     * =(2*7+3*25+4)#12
     * =93#12
     * =2*93+3*12+4
     * =226
     */
    private static void test1() {
        String s = scanner.nextLine();
        // 7#6$5#12
        // # $ #
        List<String> collect1 = Arrays.stream(s.split("[\\w+]")).filter(e -> !e.isEmpty()).collect(Collectors.toList());
        // 7 6 5 12
        List<Integer> collect2 = Arrays.stream(s.split("[\\W+]")).map(Integer::parseInt).collect(Collectors.toList());

        int pos = collect1.indexOf("$");
        while (pos != -1) {
            Integer integer = collect2.get(pos);
            Integer integer1 = collect2.get(pos + 1);
            int temp = 3 * integer + integer1 + 2;
            collect2.set(pos, temp);
            collect2.remove(pos + 1);
            collect1.remove("$");
            pos = collect1.indexOf("$");
        }
        int sum = collect2.get(0);
        for (int i = 1; i < collect2.size(); i++) {
            sum = 2 * sum + 3 * collect2.get(i) + 4;
        }
        System.out.println(sum);
    }
}
