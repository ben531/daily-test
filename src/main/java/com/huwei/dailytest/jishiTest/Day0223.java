package com.huwei.dailytest.jishiTest;

import java.util.*;
import java.util.stream.Collectors;

public class Day0223 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }

    /**
     * 现在有多组整数数组
     * 需要将他们合并成一个新的数组
     * 合并规则从每个数组里按顺序取出固定长度的内容
     * 合并到新的数组
     * 取完的内容会删除掉
     * 如果改行不足固定长度，或者已经为空
     * 则直接取出剩余部分的内容放到新的数组中继续下一行
     * <p>
     * 输入描述
     * 第一 行每次读取的固定长度
     * 长度0<len<10
     * 第二行是整数数组的数目
     * 数目 0<num<10000
     * 第3~n行是需要合并的数组
     * 不同的数组用换行分割
     * 元素之间用逗号分割
     * 最大不超过100个元素
     * <p>
     * 输出描述
     * 输出一个新的数组，用逗号分割
     * <p>
     * 示例1
     * 输入
     * 3
     * 2
     * 2,5,6,7,9,5,7
     * 1,7,4,3,4
     * 输出
     * 2,5,6,1,7,4,7,9,5,3,4,7
     * <p>
     * 说明  获得长度3和数组数目2
     * 先遍历第一行 获得2,5,6
     * 再遍历第二行 获得1,7,4
     * 再循环回到第一行获得7,9,5
     * 再遍历第二行获得3,4
     * 再回到第一行获得7
     * <p>
     * 示例2
     * 输入
     * 4
     * 3
     * 1,2,3,4,5,6
     * 1,2,3
     * 1,2,3,4
     * 输出
     * 1,2,3,4,1,2,3,1,2,3,4,5,6
     */
    private static void test5() {
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList()));
        }
        StringBuffer sb = new StringBuffer();
        boolean flag = true;
        int[] arr = new int[list.size()];
        while (flag) {
            for (int i = 0; i < list.size(); i++) {
                List<Integer> list1 = list.get(i);
                int nn = Math.min(m, list1.size());
                for (int j = 0; j < nn; j++) {
                    sb.append(list1.get(j)).append(",");
                }
                list1 = list1.subList(nn, list1.size());
                list.set(i, list1);
                arr[i] = list1.size();
            }
            if (Arrays.stream(arr).sum() == 0) {
                flag = false;
            }
        }
        System.out.println(sb);
    }

    /**
     * 疫情过后希望小学终于又重新开学了
     * 3年2班开学第一天的任务是
     * 将后面的黑板报重新制作
     * 黑板上已经写上了N个正整数
     * 同学们需要给这每个数分别上一种颜色
     * 为了让黑板报既美观又有学习意义
     * 老师要求同种颜色的所有数都可以被这个颜色中最小的那个数整除
     * 现在帮小朋友们算算最少需要多少种颜色，给这N个数进行上色
     * <p>
     * 输入描述
     * 第一行有一个正整数N
     * 其中 1 <= n <=100
     * 第二行有N个int型数，保证输入数据在[1,100]范围中
     * 表示黑板上各个正整数的值
     * <p>
     * 输出描述
     * 输出只有一个整数，为最少需要的颜色种数
     * <p>
     * 输入
     * 3
     * 2 4 6
     * 输出
     * 1
     * 说明：
     * 所有数都能被2整除
     * <p>
     * 输入
     * 4
     * 2 3 4 9
     * 输出
     * 2
     * 说明：
     * 2与4涂一种颜色，4能被2整除
     * 3与9涂另一种颜色，9能被3整除
     * 不能涂同一种颜色
     */
    private static void test4() {
        int m = Integer.parseInt(scanner.nextLine());
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).sorted().collect(Collectors.toList());

        if (list.get(0) == 1) {
            System.out.println(1);
            return;
        }
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            boolean flag = false;
            Integer n = list.get(i);
            for (int j = 0; j < i; j++) {
                Integer x = list.get(j);
                if (n % x == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 给定一个非空数组(列表)
     * 起元素数据类型为整型
     * 请按照数组元素十进制最低位从小到大进行排序
     * 十进制最低位相同的元素，相对位置保持不变
     * 当数组元素为负值时，十进制最低为等同于去除符号位后对应十进制值最低位
     * <p>
     * 输入描述
     * 给定一个非空数组(列表)
     * 其元素数据类型为32位有符号整数
     * 数组长度为[1,1000]
     * 输出排序后的数组
     * <p>
     * 输入
     * 1,2,5,-21,22,11,55,-101,42,8,7,32
     * 输出
     * 1,-21,11,-101,2,22,42,32,5,55,7,8
     */
    private static void test3() {
        List<Integer> list = Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt).collect(Collectors.toList());

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return mod(o1) - mod(o2);
            }

            private int mod(Integer o) {
                o = o > 0 ? o : -o;
                return o % 10;
            }
        });
        list.forEach(System.out::println);
    }

    /*数组二叉树
    二叉树也可以用数组来存储，给定一个数组，树的根节点的值存储在下标1，对于存储在下标N的节点，它的左子节点和右子节点分别存储在下标2N和2N+1，并且我们用值-1代表一个节点为空。

    给定一个数组存储的二叉树，试求从根节点到最小的叶子节点的路径，路径由节点的值组成。

    输入描述:
    输入一行为数组的内容，数组的每个元素都是正整数，元素间用空格分隔。注意第一个元素即为根节点的值，即数组的第N个元素对应下标N，下标0在树的表示中没有使用，所以我们省略了。输入的树最多为7层。
    输出描述:
    输出从根节点到最小叶子节点的路径上，各个节点的值，由空格分隔，用例保证最小叶子节点只有一个。

    示例1
            输入
3 5 7-1-1 2 4
    输出
3 7 2
    说明
    数组存储的二叉树如图，故到最小叶子节点的路径为3 7 2
    示例2
            输入
5 9 8-1-1 7-1-1-1-1-1 6
    输出
5 8 7 6
    说明
    数组存储的二叉树如图，故到最小叶子节点的路径为10 8 7 6，注意数组仅存储至最后一个非空节点，故不包含节点“7”右子节点的-1

    答案：
    解法一：
*/
    private static void test2() {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        while (in.hasNextInt()) {
            array.add(in.nextInt());
        }
        fun(array);
    }

    private static int dfs(List<Integer> nums, int index) {
        if (isLeaf(nums, index)) {
            return index;
        } else {
            int i1 = dfs(nums, 2 * index + 1);
            int i2 = dfs(nums, 2 * index + 2);
            if (i1 >= nums.size() || nums.get(i1) == -1) {
                return i2;
            } else if (i2 >= nums.size() || nums.get(i2) == -1) {
                return i1;
            } else {
                return nums.get(i1) < nums.get(i2) ? i1 : i2;
            }
        }
    }

    private static boolean isLeaf(List<Integer> nums, int index) {
        return (2 * index + 1 >= nums.size() || nums.get(2 * index + 1) == -1)
                && (2 * index + 2 >= nums.size() || nums.get(2 * index + 2) == -1);
    }

    private static void fun(List<Integer> nums) {
        int index = dfs(nums, 0);
        ArrayList<Integer> arr = new ArrayList<>();
        while (index > 0) {
            arr.add(nums.get(index));
            index = (index - 1) / 2;
        }
        arr.add(nums.get(0));

        Collections.reverse(arr);
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }


    /**
     * 给定一个数组
     * 编写一个函数
     * 来计算他的最大N个数和最小N个数的和
     * 需要对数组进行去重
     * <p>
     * 说明
     * 第一行输入M
     * M表示数组大小
     * 第二行输入M个数
     * 表示数组内容
     * 第三行输入N表示需要计算的最大最小N的个数
     * <p>
     * 输出描述
     * 输出最大N个数和最小N个数的和
     * <p>
     * 例一：
     * 输入
     * 5
     * 95 88 83 64 100
     * 2
     * <p>
     * 输出
     * 342
     * <p>
     * 说明
     * 最大2个数[100 95] 最小2个数[83 64]
     * 输出342
     * <p>
     * 例二
     * 输入
     * 5
     * 3 2 3 4 2
     * 2
     * <p>
     * 输出
     * -1
     * 说明
     * 最大两个数是[4 3]最小2个数是[3 2]
     * 有重叠输出为-1
     */
    private static void test1() {
        int m = Integer.parseInt(scanner.nextLine());
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).distinct().sorted().collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        if (list.size() < 2 * n) {
            System.out.println(-1);
            return;
        }
        int sum = 0;
        // 1 2 3 4 5
        // 0 1 2 3 4
        //
        for (int i = 0; i < n; i++) {
            sum += list.get(i);
        }
        for (int i = list.size() - n; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}
