package com.huwei.dailytest.jishiTest;

import java.util.*;
import java.util.stream.Collectors;

public class Day0227 {
    public static void main(String[] args) {
//        test17();
//        test2();
//        test3();
//        test4();
//        test13();
//        test6();

    }

    /**
     * 对一个数据a进行分类
     * 分类方法是 此数据a(4个字节大小)的4个字节相加对一个给定值b取模
     * （byte）(x>>i*8)
     * <p>
     * 如果得到的结果小于一个给定的值c则数据a为有效类型
     * 其类型为取模的值
     * 如果得到的结果大于或者等于c则数据a为无效类型
     * <p>
     * 比如一个数据a=0x01010101 b=3
     * 按照分类方法计算  (0x01+0x01+0x01+0x01)%3=1
     * 所以如果c等于2 则此a就是有效类型  其类型为1
     * 如果c等于1 则此a是无效类型
     * <p>
     * 又比如一个数据a=0x01010103 b=3
     * 按分类方法计算(0x01+0x01+0x01+0x03)%3=0
     * 所以如果c=2则此a就是有效类型  其类型为0
     * 如果c等于0 则此a是无效类型
     * <p>
     * 输入12个数据
     * 第一个数据为c  第二个数据为b
     * 剩余10个数据为需要分类的数据
     * <p>
     * 请找到有效类型中包含数据最多的类型
     * 并输出该类型含有多少个数据
     * <p>
     * 输入描述
     * 输入12个数据用空格分割
     * 第一个数据为c  第二个数据为b
     * 剩余10个数据为需要分类的数据
     * <p>
     * 输出描述
     * 请找到有效类型中包含数据最多的类型
     * 并输出该类型含有多少个数据
     * <p>
     * 实例：
     * 输入
     * 3 4 256 257 258 259 260 261 262 263 264 265
     * 输出
     * 3
     * 说明
     * 这10个数据4个字节相加后的结果分别是
     * 1 2 3 4 5 6 7 8 9 10
     * 故对4取模的结果为
     * 1 2 3 0 1 2 3 0 1 2
     * c是3所以012都是有效类型
     * 类型为1和2的有3个数据
     * 类型为0和3的只有两个
     * <p>
     * 例子2
     * 输入
     * 1 4 256 257 258 259 260 261 262 263 264 265
     * 输出
     * 2
     */
    private static void test6() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int c = list.get(0);
        int b = list.get(1);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 2; i < list.size(); i++) {
            int a = intByteSum(list.get(i)) % b;
            if (a < c) {
                hashMap.put(a, hashMap.getOrDefault(a, 0) + 1);
            }
        }
        Integer integer = hashMap.values().stream().reduce(Integer::max).get();
        System.out.println(integer);


    }

    private static int intByteSum(Integer x) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += (byte) (x >> (i * 8));
        }
        return sum;
    }


    /**
     * 二叉树也可以用数组来存储
     * 给定一个数组
     * 树的根节点的值储存在下标1
     * 对于储存在下标n的节点，
     * 他的左子节点和右子节点分别储存在下标2*n和2*n+1
     * 并且我们用-1代表一个节点为空
     * 给定一个数组存储的二叉树
     * 试求从根节点到最小的叶子节点的路径
     * 路径由节点的值组成
     * <p>
     * 输入描述
     * 输入一行为数组的内容
     * 数组的每个元素都是正整数，元素间用空格分割
     * 注意第一个元素即为根节点的值
     * 即数组的第n元素对应下标n
     * 下标0在树的表示中没有使用
     * 所以我们省略了
     * 输入的树最多为7层
     * <p>
     * 输出描述
     * 输出从根节点到最小叶子节点的路径上各个节点的值
     * 由空格分割
     * 用例保证最小叶子节点只有一个
     * <p>
     * 例子
     * 输入
     * 3 5 7 -1 -1 2 4
     * 输出
     * 3 7 2
     * <p>
     * 例子
     * 输入
     * 5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6
     * 0 1 2  3  4 5  6  7  8  9  10 11
     * 输出
     * 5 8 7 6
     */
    private static void test13() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        list.add(0, -1);
        Integer first = list.get(1);
        Integer min = list.stream().filter(e -> e != first && e != -1).reduce(Integer::min).get();
        int i = list.indexOf(min);
        StringBuffer sb = new StringBuffer();
        List<Integer> result = new ArrayList<>();
        result.add(min);
        for (int j = i; j > 1; ) {
            if (j % 2 == 0) {
                j = j / 2;
            } else {
                j = (j - 1) / 2;
            }
            result.add(list.get(j));
        }
        Collections.reverse(result);
        result.forEach(e -> sb.append(e).append(" "));
        System.out.println(sb.toString().trim());

    }

    /**
     * 一辆运送快递的货车
     * 运送的快递放在大小不等的长方体快递盒中
     * 为了能够装载更多的快递同时不能让货车超载
     * 需要计算最多能装多少个快递
     * 注：快递的体积不受限制
     * 快递数最多1000个
     * 货车载重最大50000
     * 输入描述
     * 第一行输入每个快递的重量
     * 用英文逗号隔开
     * 如 5,10,2,11
     * 第二行输入货车的载重量
     * 如 20
     * 输出描述
     * 输出最多能装多少个快递
     * 如 3
     * 示例一
     * 输入
     * 5,10,2,11
     * 20
     * 输出
     * 3
     */
    private static void test4() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int i;
        for (i = 0; i < list.size(); i++) {
            sum += list.get(i);
            if (sum > n) {
                break;
            }
        }
        System.out.println(i);
    }

    /**
     * 给航天器一侧加装长方形和正方形的太阳能板(图中的斜线区域)
     * 需要先安装两个支柱(图中的黑色竖条)
     * 再在支柱的中间部分固定太阳能板
     * 但航天器不同位置的支柱长度不同
     * 太阳能板的安装面积受限于最短一侧的那支支柱的长度
     * <p>
     * 现提供一组整型数组的支柱高度数据
     * 假设每个支柱间的距离相等为一个单位长度
     * 计算如何选择两根支柱可以使太阳能板的面积最大
     * <p>
     * 输入描述
     * 10,9,8,7,6,5,4,3,2,1
     * 注释，支柱至少有两根，最多10000根，能支持的高度范围1~10^9的整数
     * <p>
     * 柱子的高度是无序的
     * 例子中的递减是巧合
     * <p>
     * 输出描述
     * 可以支持的最大太阳板面积:(10m高支柱和5m高支柱之间)
     * 25
     * <p>
     * 示例1
     * 输入
     * 10,9,8,7,6,5,4,3,2,1
     * 输出
     * 25
     * 备注 10米高支柱和5米高支柱之间宽度为5，高度取小的支柱高度也是5
     * 面积为25
     * 任取其他两根支柱所能获得的面积都小于25 所以最大面积为25
     */
    private static void test3() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        long mj = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                long temp = Math.min(list.get(i), list.get(j)) * (j - i);
                if (temp > mj) {
                    mj = temp;
                }
            }
        }
        System.out.println(mj);
    }

    /**
     * 单词接龙的规则是
     * 可用于接龙的单词 首字母必须要与前一个单词的尾字母相同
     * 当存在多个首字母相同的单词时，取长度最长的单词
     * 如果长度也相等，则取字典序最小的单词
     * 已经参与接龙的单词不能重复使用
     * 现给定一组全部由小写字母组成的单词数组
     * 并指定其中一个单词为起始单词
     * 进行单词接龙
     * 请输出最长的单词串
     * 单词串是单词拼接而成的中间没有空格
     * <p>
     * 输入描述
     * 输入第一行为一个非负整数
     * 表示起始单词在数组中的索引k
     * 0<=k<N
     * 输入的第二行为非负整数N
     * 接下来的N行分别表示单词数组中的单词
     * <p>
     * 输出描述，
     * 输出一个字符串表示最终拼接的单词串
     * <p>
     * 示例
     * 0
     * 6
     * word
     * dd
     * da
     * dc
     * dword
     * d
     * <p>
     * 输出
     * worddwordda
     * 说明 先确定起始单词word 在接dword
     * 剩余dd da dc 则取da
     * <p>
     * 示例2
     * 4
     * 6
     * word
     * dd
     * da
     * dc
     * dword
     * d
     * <p>
     * 输出
     * dwordda
     * <p>
     * 单词个数1<N<20
     * 单个单词的长度  1~30
     */
    private static void test2() {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < b; i++) {
            list.add(scanner.nextLine());
        }
        StringBuffer sb = new StringBuffer();
        String first = list.remove(a);
        sb.append(first);
        List<String> collect = list.stream().sorted((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length() < 0 ? 1 : -1;
            }
            return o1.compareTo(o2);
        }).collect(Collectors.toList());

        boolean flag = false;
        while (true) {
            String end = sb.substring(sb.length() - 1, sb.length());
            for (int i = 0; i < collect.size(); i++) {
                flag = false;
                if (collect.get(i).startsWith(end)) {
                    sb.append(collect.remove(i));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        System.out.println(sb);

    }

    /**
     * 给定一个字符串
     * 只包含大写字母
     * 求在包含同一字母的子串中
     * 长度第K长的子串
     * 相同字母只取最长的子串
     * <p>
     * 输入
     * 第一行 一个子串 1<len<=100
     * 只包含大写字母
     * 第二行为k的值
     * <p>
     * 输出
     * 输出连续出现次数第k多的字母的次数
     * <p>
     * 例子：
     * 输入
     * AABAAA
     * 2
     * 输出
     * 1
     * 同一字母连续出现最多的A 3次
     * 第二多2次  但A出现连续3次
     * <p>
     * 输入
     * <p>
     * AAAAHHHBBCDHHHH
     * 3
     * <p>
     * 输出
     * 2
     * <p>
     * //如果子串中只包含同一字母的子串数小于k
     * <p>
     * 则输出-1
     */
    private static void test17() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        HashMap<Character, Integer> map = new HashMap<>();

        char temp = str.charAt(0);
        int count = 1;
        map.put(temp, count);
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == temp) {
                count++;
            } else {
                temp = current;
                count = 1;
            }

            Integer orDefault = map.getOrDefault(temp, 0);
            if (orDefault < count) {
                map.put(temp, count);
            }

        }


//        for (int i = 0; i < str.length(); i++) {
//            char current = str.charAt(i);
//            int j = i + 1;
//            int count = 1;
//            while (j < str.length() && str.charAt(j) == current) {
//                j++;
//                count++;
//            }
//            Integer orDefault = map.getOrDefault(current, 0);
//            if (count > orDefault) {
//                map.put(current, count);
//            }
//            i = j - 1;
//        }
        map.forEach((m, v) -> System.out.println(m + ":" + v));
        List<Integer> collect = map.values().stream().sorted().collect(Collectors.toList());
        if (k > collect.size()) {
            System.out.println(-1);
        }
        System.out.println(collect.get(collect.size() - k));

    }
}
