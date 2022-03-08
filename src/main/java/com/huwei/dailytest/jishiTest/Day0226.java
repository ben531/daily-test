package com.huwei.dailytest.jishiTest;


import java.util.*;
import java.util.stream.Collectors;

public class Day0226 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        test5();
//        test4(); // TODO 不会
//        test3();
//        test2();
        test6();

    }

    /**
     * 如果三个正整数A B C ,A²+B²=C²则为勾股数
     * 如果ABC之间两两互质，即A与B A与C B与C均互质没有公约数，
     * 则称其为勾股数元组。
     * 请求出给定n m 范围内所有的勾股数元组
     * 输入描述
     * 起始范围 1<n<10000    n<m<10000
     * 输出目描述
     * abc 保证a<b<c输出格式  a b c
     * 多组勾股数元组 按照a升序b升序 c升序的排序方式输出。
     * 给定范围内，找不到勾股数元组时，输出  Na
     * <p>
     * 案例
     * 输入
     * 1
     * 20
     * 输出
     * 3 4 5
     * 5 12 13
     * 8 15 17
     * <p>
     * 输入
     * 5
     * 10
     * 输出
     * Na
     */
    private static void test6() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = n; i < m; i++) {
            for (int j = i; j < m; j++) {
                for (int k = j; k < m; k++) {
                    if (i < j && j < k && huzhi(i, j) && huzhi(j, k) && huzhi(k, i) && i * i + j * j == k * k) {
                        list.add(i + " " + j + " " + k);
                    }
                }
            }
        }
        if (list.size() > 0) {
            list.forEach(System.out::println);
        } else {
            System.out.println("Na");

        }
    }

    private static boolean huzhi(int i, int j) {
        if (i > j) {
            int temp = i;
            i = j;
            j = temp;
        }
        for (int k = 2; k <= i; k++) {
            if (i % k == 0 && j % k == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给定两个整数数组
     * array1 array2  数组元素按升序排列
     * 假设从arr1 arr2中分别取出一个元素，可构成一对元素
     * 现在需要取出k对元素，并对取出的所有元素求和
     * 计算和的最小值
     * 注意：两对元素对应arr1 arr2的下标是相同的
     * 视为同一对元素
     * <p>
     * 输入描述
     * 输入两行数组arr1 arr2
     * 每行首个数字为数组大小size   0<size<=100
     * arr1，2中的每个元素   0< <1000
     * 接下来一行  正整数k   0<k<=arr1.size * arr2.size
     * 输出描述
     * 满足要求的最小值
     * <p>
     * 例子
     * <p>
     * 输入
     * 3 1 1 2
     * 3 1 2 3
     * 2
     * <p>
     * 输出
     * 4
     * <p>
     * 说明：用例中需要取两个元素，
     * 取第一个数组第0个元素与第二个数组第0个元素组成一个元素
     * [1,1]
     * 取第一个数组第1个元素与第二个数组第0个元素组成一个元素
     * [1,1]
     * <p>
     * 求和为1+1+1+1=4 ,满足要求最小
     */
    private static void test2() {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> linkedList1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
        linkedList1.removeFirst();


        LinkedList<Integer> linkedList2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
        linkedList2.removeFirst();

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < linkedList1.size(); i++) {
            for (int j = 0; j < linkedList2.size(); j++) {
                result.add(linkedList1.get(i) + linkedList2.get(j));
            }
        }
        Collections.sort(result);
//        result.sort(Comparator.comparingInt(o -> o));
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += result.get(i);
        }
        System.out.println(sum);

    }

    /**
     * 给出n阶方阵里所有数
     * 求方阵里所有数的和
     * 输入描述：
     * 输入有多个测试用例
     * 每个测试用例第一个第一个整数n   n<=1000 表示方阵阶数为n
     * 接下来是n行的数字，每行n个数字用空格隔开
     * 输出描述：
     * 输出一个整数表示n阶方阵的和
     * 例子：
     * 输入
     * 3
     * 1 2 3
     * 2 1 3
     * 3 2 1
     * 输出
     * 18
     */
    private static void test3() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).sum();
            }
            System.out.println(sum);
        }
    }

    /**
     * TLV编码是按 Tag Length  Value格式进行编码的
     * 一段码流中的信元用tag标识，tag在码流中唯一不重复
     * length表示信元value的长度  value表示信元的值
     * 码流以某信元的tag开头 ，tag固定占一个字节
     * length固定占两个字节，字节序为小端序
     * 现给定tlv格式编码的码流以及需要解码的信元tag
     * 请输出该信元的value
     * <p>
     * 输入码流的16机制字符中，不包括小写字母
     * 且要求输出的16进制字符串中也不要包含字符字母
     * 码流字符串的最大长度不超过50000个字节
     * <p>
     * 输入描述
     * 第一行为第一个字符串 ，表示待解码信元的tag
     * 输入第二行为一个字符串， 表示待解码的16进制码流
     * 字节之间用空格分割
     * 输出描述
     * 输出一个字符串，表示待解码信元以16进制表示的value
     * <p>
     * 例子：
     * 输入：
     * 31
     * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
     * <p>
     * 输出
     * 32 33
     * <p>
     * 说明：
     * 需要解析的信源的tag是31
     * 从码流的起始处开始匹配，tag为32的信元长度为1(01 00,小端序表示为1)
     * 第二个信元的tag为90 其长度为2
     * 第三个信元的tag为30 其长度为3
     * 第四个信元的tag为31 其长度为2(02 00)
     * 所以返回长度后面的两个字节即可 为 32 33
     */
    private static void test4() {
    }

    /**
     * 一天一只顽猴想要从山脚爬到山顶
     * 途中经过一个有n个台阶的阶梯，但是这个猴子有个习惯，每一次只跳1步或3步
     * 试问？猴子通过这个阶梯有多少种不同的跳跃方式
     * <p>
     * 输入描述：
     * 输入只有一个这个数n    0<n<50
     * 此阶梯有多个台阶
     * 输出描述：
     * 有多少种跳跃方式
     * <p>
     * 实例:
     * 输入
     * 50
     * 输出
     * 122106097
     * <p>
     * 输入
     * 3
     * 输出
     * 2
     */
    private static void test5() {
        int n = scanner.nextInt();
        int f1 = 1;
        int f2 = 1;
        int f3 = 2;
        int f4 = n == 1 || n == 2 ? 1 : 2;
        for (int i = 4; i <= n; i++) {
            f4 = f3 + f1;
            f1 = f2;
            f2 = f3;
            f3 = f4;
        }
        System.out.println(f4);

        System.out.println(getR(n));
    }

    private static int getR(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        return getR(n - 1) + getR(n - 3);
    }

    private static void test() {
        // ab c d e f
        List<String> arr = new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("caxyz");
                add("d");
                add("e");
            }
        };

        int max = Integer.MIN_VALUE;
        for (String str : arr) {
            int r = checkWord(str);
            if (r > max) {
                max = r;
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            List<String> newList = new ArrayList<>(arr);
            String s = newList.remove(i);
            StringBuffer sb = new StringBuffer(s);
            for (int j = 0; j < newList.size(); j++) {
                if (isIn(newList.get(j), sb.toString())) {
                    sb.append(newList.get(j));
                }
            }
            if (sb.length() > max) {
                max = sb.length();
            }
        }

        System.out.println(max);
    }

    private static boolean isIn(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (s2.indexOf(String.valueOf(c)) != -1) {
                return false;
            }
        }
        return true;
    }

    public static int checkWord(String str) {
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for (Character c : chars) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                return 0;
            }
        }
        return str.length();
    }
}
