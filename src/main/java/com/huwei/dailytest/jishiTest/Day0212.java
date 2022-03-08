package com.huwei.dailytest.jishiTest;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Day0212 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        test73();
//        test72();
//        test71();
//        test70();
//        test70_1();
//        test69();
//        test69_1();
//        test68();
//        test68_1();
        test67();
//        test66();
//        test66_1();
//        test65();
//        test64();
//        test63();
//        test62();
//        test61();
//        test60();
    }

    /**
     * 游戏规则：
     * 输入一个只包含英文字母的字符串,
     * 字符串中的两个字母如果相邻且相同,就可以消除。
     * 在字符串上反复执行消除的动作,
     * 直到无法继续消除为止,此时游戏结束。
     * 输出最终得到的字符串长度.
     * <p>
     * 输入描述：
     * 输入原始字符串str
     * 只能包含大小写英文字母,字母的大小写敏感,
     * str长度不超过100
     * <p>
     * 输出描述
     * 输出游戏结束后,最终得到的字符串长度
     * <p>
     * 示例一：
     * 输入
     * gg
     * <p>
     * 输出
     * 0
     * 说明 gg可以直接消除 得到空串 长度为0
     * <p>
     * 示例2
     * 输入：
     * mMbccbc
     * 0123456
     * 输出
     * 3
     * 说明mMbccbc中 可以先消除cc 此时变为mMbbc
     * 再消除 bb 此时变成mMc
     * 此时没有相同且相邻的字符 无法继续消除
     * 最终得到字符串mMc  长度为3
     * <p>
     * 备注：
     * 输入中包含非大小写英文字母时
     * 均为异常输入
     * 直接返回0
     */
    private static void test60() {
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String s1 = s.replaceAll("[a-zA-Z]", "");
            if (s1.length() > 0) {
                System.out.println(0);
                return;
            }
            List<Character> list = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                list.add(s.charAt(i));

            }
            // mMbccbc
            for (int i = 0; i < list.size() - 1; i++) {
                Character c = list.get(i);
                if (c == list.get(i + 1)) {
                    list.remove(i);
                    list.remove(i);
//                    i -= 2 <= 0 ? -1 : i;
                    i = i - 2 <= 0 ? -1 : i - 2;
//                    i = i - 2;
//                    if (i <= 0) {
//                        i = -1;
//                    }
                }
            }
            System.out.println(list.size());
        }

    }

    /**
     * 给你两个字符串t和p
     * 要求从t中找到一个和p相同的连续子串
     * 并输出该子串第一个字符的下标
     * 输入描述
     * 输入文件包括两行 分别表示字符串t和p
     * 保证t的长度不小于p
     * 且t的长度不超过1000000
     * p的长度不超过10000
     * 输出描述
     * 如果能从t中找到一个和p相等的连续子串,
     * 则输出该子串第一个字符在t中的下标
     * 下标从左到右依次为1,2,3,...；
     * 如果不能则输出 "No"
     * 如果含有多个这样的子串
     * 则输出第一个字符下标最小的
     * <p>
     * 示例一：
     * 输入：
     * AVERDXIVYERDIAN
     * RDXI
     * 输出
     * 4
     */
    private static void test61() {
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            // AVERDXIVYERDIAN
            for (int i = 0; i < str1.length(); i++) {
                if (str2.charAt(0) == str1.charAt(i)) {
                    String substring = str1.substring(i, i + str2.length());
                    if (substring.length() < str2.length()) {
                        System.out.println("No");
                        return;
                    }
                    if (substring.equals(str2)) {
                        System.out.println(i + 1);
                        return;
                    }
                }
            }
            System.out.println("No");
        }
    }

    /**
     * 有一种简易压缩算法：针对全部为小写英文字母组成的字符串，
     * 将其中连续超过两个相同字母的部分压缩为连续个数加该字母
     * 其他部分保持原样不变.
     * 例如字符串aaabbccccd  经过压缩变成字符串 3abb4cd
     * 请您编写解压函数,根据输入的字符串,
     * 判断其是否为合法压缩过的字符串
     * 若输入合法则输出解压缩后的字符串
     * 否则输出字符串"!error"来报告错误
     * <p>
     * 输入描述
     * 输入一行，为一个ASCII字符串
     * 长度不超过100字符
     * 用例保证输出的字符串长度也不会超过100字符串
     * <p>
     * 输出描述
     * 若判断输入为合法的经过压缩后的字符串
     * 则输出压缩前的字符串
     * 若输入不合法 则输出字符串"!error"
     * <p>
     * 示例一：
     * 输入
     * 4dff
     * 输出
     * ddddff
     * 说明
     * 4d扩展为4个d ，故解压后的字符串为ddddff
     * <p>
     * 示例二
     * 输入
     * 2dff
     * 输出
     * !error
     * 说明
     * 2个d不需要压缩 故输入不合法
     * <p>
     * 示例三
     * 输入
     * 4d@A
     * 输出
     * !error
     * 说明
     * 全部由小写英文字母做成的字符串，压缩后不会出现特殊字符@和大写字母A
     * 故输入不合法
     */
    private static void test62() {
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String s1 = s.replaceAll("[0-9][a-z]", "");
            if (s1.length() > 0) {
                System.out.println("!error");
                return;
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    int begin = i;
                    int end = i + 1;
                    while (end < s.length() && Character.isDigit(s.charAt(end))) {
                        end++;
                    }
                    int n = Integer.parseInt(s.substring(begin, end));
                    if (n < 3) {
                        System.out.println("!error");
                        return;
                    }
                    for (int j = 0; j < n; j++) {
                        sb.append(s.charAt(end));
                    }
                    i = end + 1;

                } else {
                    sb.append(s.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }

    /**
     * 给定两个字符集合
     * 一个是全量字符集
     * 一个是已占用字符集
     * 已占用字符集中的字符不能再使用
     * 要求输出剩余可用字符集
     * <p>
     * 输入描述
     * 1. 输入一个字符串 一定包含@
     *
     * @前为全量字符集 @后的为已占用字符集
     * 2. 已占用字符集中的字符
     * 一定是全量字符集中的字符
     * 字符集中的字符跟字符之间使用英文逗号隔开
     * 3. 每个字符都表示为字符+数字的形式
     * 用英文冒号分隔
     * 比如a:1标识一个a字符
     * 4. 字符只考虑英文字母，区分大小写
     * 数字只考虑正整型 不超过100
     * 5. 如果一个字符都没被占用 @标识仍存在
     * 例如 a:3,b:5,c:2@
     * <p>
     * 输出描述：
     * 输出可用字符集
     * 不同的输出字符集之间用回车换行
     * 注意 输出的字符顺序要跟输入的一致
     * 不能输出b:3,a:2,c:2
     * 如果某个字符已全部占用 则不需要再输出
     * <p>
     * 示例一：
     * 输入
     * a:3,b:5,c:2@a:1,b:2
     * 输出
     * a:2,b:3,c:2
     * 说明：
     * 全量字符集为三个a，5个b，2个c
     * 已占用字符集为1个a，2个b
     * 由于已占用字符不能再使用
     * 因此剩余可用字符为2个a，3个b，2个c
     * 因此输出a:2,b:3,c:2
     */
    private static void test63() {
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            // a:3,b:5,c:2@a:1,b:2
            String[] split = s.split("@");
            String s1 = split[0]; // 全量
            if (split.length < 2) {
                System.out.println(s1);
                return;
            }
            String s2 = split[1]; // 已占用
            // a:3,b:5,c:2
            String[] split1 = s1.split(",");
            List<Test63Class> list = new ArrayList<>();
            Map<Character, Test63Class> map = new HashMap<>();
            for (int i = 0; i < split1.length; i++) {
                String[] split2 = split1[i].split(":");
                char c = split2[0].charAt(0);
                map.put(c, new Test63Class(i, split2[0].charAt(0), Integer.parseInt(split2[1])));
            }

            //a:1,b:2
            String[] split2 = s2.split(",");
            for (int i = 0; i < split2.length; i++) {
                String[] split3 = split2[i].split(":");
                char c = split3[0].charAt(0);
                int n = Integer.parseInt(split3[1]);
                Test63Class test63Class = map.get(c);
                test63Class.count -= n;
                map.put(c, test63Class);
            }
            map.forEach((k, v) -> {
                list.add(v);
            });

            list.sort(new Comparator<Test63Class>() {
                @Override
                public int compare(Test63Class o1, Test63Class o2) {
                    return o1.index < o2.index ? -1 : 1;
                }
            });
//            List<Test63Class> collect = list.stream().sorted().collect(Collectors.toList());
            StringBuffer sb = new StringBuffer();
            list.forEach(e -> {
                if (e.count != 0) {
                    sb.append(e.c).append(":").append(e.count).append(",");
                }
            });
            if (sb.toString().length() > 0) {
                System.out.println(sb.toString().substring(0, sb.length() - 1));
            } else {
                System.out.println("");
            }
        }
    }

    //    static class Test63Class implements Comparable<Test63Class> {
    static class Test63Class {
        int index;
        char c;
        int count;

        public Test63Class(int index, char c, int count) {
            this.index = index;
            this.c = c;
            this.count = count;
        }

//        @Override
//        public int compareTo(Test63Class o) {
//            return this.index < o.index ? -1 : 1;
//        }
    }

    /**
     * 绘图机器的绘图笔初始位置在原点(0,0)
     * 机器启动后按照以下规则来进行绘制直线
     * 1. 尝试沿着横线坐标正向绘制直线
     * 直到给定的终点E
     * 2. 期间可以通过指令在纵坐标轴方向进行偏移
     * offsetY为正数表示正向偏移,为负数表示负向偏移
     * <p>
     * 给定的横坐标终点值E 以及若干条绘制指令
     * 请计算绘制的直线和横坐标轴以及x=E的直线组成的图形面积
     * 输入描述:
     * 首行为两个整数N 和 E
     * 表示有N条指令,机器运行的横坐标终点值E
     * 接下来N行 每行两个整数表示一条绘制指令x offsetY
     * 用例保证横坐标x以递增排序的方式出现
     * 且不会出现相同横坐标x
     * 取值范围:
     * 0<N<=10000
     * 0<=x<=E<=20000
     * -10000<=offsetY<=10000
     * <p>
     * 输出描述:
     * 一个整数表示计算得到的面积 用例保证结果范围在0到4294967295之内
     * 示例1:
     * 输入:
     * 4 10
     * 1 1
     * 2 1
     * 3 1
     * 4 -2
     * 输出:
     * 12
     * <p>
     * 示例2:
     * 输入:
     * 2 4
     * 0 1
     * 2 -2
     * 输出:
     * 4
     */
    private static void test64() {
        while (scanner.hasNext()) {
            List<Integer> collect = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            Integer n = collect.get(0);
            Integer e = collect.get(1);
            int mianji = 0;
            int curX = 0;
            int curY = 0;
            for (int i = 0; i < n; i++) {
                List<Integer> collect1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                Integer x = collect1.get(0);
                Integer y = collect1.get(1);

                mianji += (x - curX) * Math.abs(curY);

                curX = x;
                curY += y;
            }
            if (curX < e) {
                mianji += (e - curX) * Math.abs(curY);
            }
            System.out.println(mianji);
        }

    }

    /**
     * 输入一个由N个大小写字母组成的字符串
     * 按照ASCII码值从小到大进行排序
     * 查找字符串中第K个最小ASCII码值的字母(k>=1)
     * 输出该字母所在字符串中的位置索引(字符串的第一个位置索引为0)
     * k如果大于字符串长度则输出最大ASCII码值的字母所在字符串的位置索引
     * 如果有重复字母则输出字母的最小位置索引
     * <p>
     * 输入描述
     * 第一行输入一个由大小写字母组成的字符串
     * 第二行输入k k必须大于0 k可以大于输入字符串的长度
     * <p>
     * 输出描述
     * 输出字符串中第k个最小ASCII码值的字母所在字符串的位置索引
     * k如果大于字符串长度则输出最大ASCII码值的字母所在字符串的位置索引
     * 如果第k个最小ASCII码值的字母存在重复  则输出该字母的最小位置索引
     * <p>
     * 示例一
     * 输入
     * AbCdeFG
     * 3
     * 输出
     * 5
     * 说明
     * 根据ASCII码值排序，第三个ASCII码值的字母为F
     * F在字符串中位置索引为5(0为字符串的第一个字母位置索引)
     * <p>
     * 示例二
     * 输入
     * fAdDAkBbBq
     * 4
     * 输出
     * 6
     * 说明
     * 根据ASCII码值排序前4个字母为AABB由于B重复则只取B的第一个最小位置索引6
     * 而不是第二个B的位置索引8
     */
    private static void test65() {
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            int k = Integer.parseInt(scanner.nextLine());
            if (k > input.length()) {
                k = input.length();
            }
            List<Character> list = input.chars().mapToObj(e -> (char) e).sorted().collect(Collectors.toList());
            Character c = list.get(k - 1);
            for (int i = 0; i < input.length(); i++) {
                if (c == input.charAt(i)) {
                    System.out.println(i);
                    return;
                }
            }

//            char[] chars = scanner.nextLine().toCharArray();
//            int i = Integer.parseInt(scanner.nextLine());
//            if (i > chars.length) {
//                i = chars.length;
//            }
//            char[] chars1 = new char[chars.length];
//            for (int j = 0; j < chars1.length; j++) {
//                chars1[j] = chars[j];
//            }
//            Arrays.sort(chars1);
//            char c = chars1[i - 1];
//            for (int j = 0; j < chars.length; j++) {
//                if (chars[j] == c) {
//                    System.out.println(j);
//                    break;
//                }
//            }
        }
    }

    private static void test66_1() {
        String s = scanner.nextLine();
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isOk(s.charAt(i))) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }

        System.out.println(max);
    }

    /**
     * 定义当一个字符串只有元音字母(a,e,i,o,u,A,E,I,O,U)组成,
     * 称为元音字符串，现给定一个字符串，请找出其中最长的元音字符串，
     * 并返回其长度，如果找不到请返回0，
     * 字符串中任意一个连续字符组成的子序列称为该字符串的子串
     * <p>
     * 输入描述：
     * 一个字符串其长度 0<length ,字符串仅由字符a-z或A-Z组成
     * 输出描述：
     * 一个整数，表示最长的元音字符子串的长度
     * <p>
     * 示例1：
     * 输入
     * asdbuiodevauufgh
     * 输出
     * 3
     * 说明：
     * 最长的元音字符子串为uio和auu长度都为3，因此输出3
     */
    private static void test66() {
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            int sum = 0;
            for (int i = 0; i < chars.length; i++) {
                if (isOk(chars[i])) {
                    int count = 1;
                    int j = i + 1;
                    while (j < chars.length && isOk(chars[j])) {
                        j++;
                        count++;
                    }
                    if (count > sum) {
                        sum = count;
                    }
                }
            }
            System.out.println(sum);
        }
    }

    private static boolean isOk(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

    /**
     * 给定一个字符串S
     * <p>
     * 变化规则:
     * 交换字符串中任意两个不同位置的字符
     * <p>
     * 输入描述：
     * 一串小写字母组成的字符串
     * 输出描述：
     * 按照要求变换得到最小字符串
     * <p>
     * 实例1：
     * 输入：
     * abcdef
     * 输出
     * abcdef
     * <p>
     * 实例2：
     * 输入
     * bcdefa
     * 输出
     * acdefb
     * <p>
     * s都是小写字符组成
     * 1<=s.length<=1000
     */
    private static void test67() {
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            List<Character> list = s.chars().mapToObj(e -> (char) e).sorted().collect(Collectors.toList());
            StringBuffer sb = new StringBuffer();
            list.forEach(e -> sb.append(e));
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != sb.charAt(i)) {
                    int i1 = s.lastIndexOf(sb.charAt(i));
                    char temp = chars[i1];
                    chars[i1] = chars[i];
                    chars[i] = temp;
                    break;
                }
            }
            sb.setLength(0);
            for (Character c : chars) {
                sb.append(c);
            }

            System.out.println(sb);
        }
    }

    @Test
    public static void test68_1() {
        Scanner in = new Scanner(System.in);
        String[] nums = in.nextLine().split(" ");

        in.close();

        ArrayList<Integer> list = Arrays.stream(nums)
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));

        int min = Integer.MAX_VALUE;

        TreeSet<Integer> resSet = new TreeSet<>();

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i; j < list.size(); j++) {
                Integer a = list.get(i);
                Integer b = list.get(j);
                int sum = Math.abs(a + b);
                if (sum < min && a != b) {
                    min = sum;
                    resSet.clear();
                    resSet.add(a);
                    resSet.add(b);
                }
            }
        }

        if (resSet.size() != 0) {
            for (Integer integer : resSet) {
                System.out.print(integer + " ");
            }
            System.out.println(min);
        }
    }

    /**
     * 给定一个随机的整数数组(可能存在正整数和负整数)nums,
     * 请你在该数组中找出两个数，其和的绝对值(|nums[x]+nums[y]|)为最小值
     * 并返回这两个数(按从小到大返回)以及绝对值。
     * 每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * <p>
     * 输入描述：
     * 一个通过空格空格分割的有序整数序列字符串，最多1000个整数，
     * 且整数数值范围是[-65535,65535]
     * <p>
     * 输出描述：
     * 两个数和两数之和绝对值
     * <p>
     * 示例一：
     * 输入
     * -1 -3 7 5 11 15
     * 输出
     * -3 5 2
     * <p>
     * 说明：
     * 因为|nums[0]+nums[2]|=|-3+5|=2最小，
     * 所以返回-3 5 2
     */
    private static void test68() {
        while (scanner.hasNext()) {
            List<Integer> collect = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).distinct().collect(Collectors.toList());
            int min = Integer.MAX_VALUE;
            int[] result = new int[3];
            for (int i = 0; i < collect.size(); i++) {
                for (int j = i + 1; j < collect.size(); j++) {
//                    if (i != j) {
                    int sum = Math.abs(collect.get(i) + collect.get(j));
                    if (sum < min) {
                        min = sum;
                        result[0] = Math.min(collect.get(i), collect.get(j));
                        result[1] = Math.max(collect.get(i), collect.get(j));
                        result[2] = min;
                    }
//                    }
                }
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i] + " ");
            }
            System.out.println(sb.toString().substring(0, sb.length() - 1));
        }

    }

    /**
     * 游戏规则：输入一个只包含英文字母的字符串，
     * 字符串中的俩个字母如果相邻且相同，就可以消除。
     * 在字符串上反复执行消除的动作，
     * 直到无法继续消除为止，
     * 此时游戏结束。
     * 输出最终得到的字符串长度。
     * <p>
     * 输出：原始字符串str只能包含大小写英文字母，字母的大小写敏感，长度不超过100，
     * 输出游戏结束后字符串的长度
     * <p>
     * 备注：输入中包含非大小写英文字母是均为异常输入，直接返回0。
     * <p>
     * 事例：mMbccbc输出为3
     */
    private static void test69() {
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String s1 = s.replaceAll("[a-z]|[A-Z]", "");
            if (s1.length() > 0) {
                System.out.println(0);
                return;
            }

            char[] chars = s.toCharArray();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                list.add(chars[i]);
            }
            // mMbcccbc
            for (int i = 0; i < list.size() - 1; i++) {
                Character c = list.get(i);
                int j = i + 1;
                boolean flag = false;
                // 只是 两个两个的消除
                if (j < list.size() && list.get(j) == c) {
                    flag = true;
                    list.remove(j);
                }
                // 不管有多少个相邻, 都消除
//                while (j < list.size() && list.get(j) == c) {
//                    flag = true;
//                    list.remove(j);
//                }
                if (flag) {
                    i = -1;
                    list.remove(c);
                }
            }
            System.out.println(list.size());
        }
    }

    private static void test69_1() {
        String str = scanner.nextLine();
        int len = str.replaceAll("[A-Z]", "")
                .replaceAll("[a-z]", "")
                .length();
        if (len != 0) {
            System.out.println(0);
            return;
        }

        LinkedList<Character> characters = new LinkedList<>();
        for (char c : str.toCharArray()) {
            characters.add(c);
        }

        int count = 0;
        while (characters.size() != count) {
            count = characters.size();
            // mMbccbc
            for (int i = 0; i < characters.size() - 1; i++) {
                if (characters.get(i) == characters.get(i + 1)) {
                    characters.remove(i);
                    characters.remove(i);
                    i--;
                }
            }
        }
        System.out.println(characters.size());
    }

    /**
     * 所谓的水仙花数是指一个n位的正整数其各位数字的n次方的和等于该数本身，
     * 例如153=1^3+5^3+3^3,153是一个三位数
     * 输入描述
     * 第一行输入一个整数N，
     * 表示N位的正整数N在3-7之间包含3,7
     * 第二行输入一个正整数M，
     * 表示需要返回第M个水仙花数
     * 输出描述
     * 返回长度是N的第M个水仙花数，
     * 个数从0开始编号，
     * 若M大于水仙花数的个数返回最后一个水仙花数和M的乘积，
     * 若输入不合法返回-1
     * <p>
     * 示例一：
     * <p>
     * 输入
     * 3
     * 0
     * 输出
     * 153
     * 说明：153是第一个水仙花数
     * 示例二：
     * 输入
     * 9
     * 1
     * 输出
     * -1
     */
    private static void test70() {
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n < 3 || n > 7) {
                System.out.println(-1);
                return;
            }
            int i = scanner.nextInt();
            int begin = (int) Math.pow(10, n - 1);
            int end = (int) Math.pow(10, n);
            List<Integer> list = new ArrayList<>();
            for (int j = begin; j <= end; j++) {
                int sum = 0;
                int num = j;
                // 101
                while (num != 0) {
                    int i1 = num % 10;
                    sum += (int) Math.pow(i1, n);
                    num /= 10;
                }
                if (sum == j) {
                    list.add(j);
                }
            }
            if (i < list.size()) {
                System.out.println(list.get(i));
            } else {
                System.out.println(i * list.get(list.size() - 1));
            }

        }
    }

    private static void test70_1() {
        while (scanner.hasNext()) {
            int N = Integer.parseInt(scanner.nextLine());
            int M = Integer.parseInt(scanner.nextLine());
            if (N < 3 || N > 7) {
                System.out.println(-1);
                return;
            }

            LinkedList<Integer> res = new LinkedList<>();

            int start = (int) Math.pow(10, N - 1);
            int end = (int) Math.pow(10, N);

            for (int i = start; i < end; i++) {
                int sum = 0;
                int bit = start;
                while (bit != 1) {
                    sum += Math.pow(i / bit % 10, N);
                    bit /= 10;
                }
                sum += Math.pow(i % 10, N);
                if (sum == i) {
                    res.add(i);
                }
                if (res.size() == M + 1) {
                    System.out.println(i);
                    return;
                }
            }

            if (M > res.size()) {
                System.out.println(M * res.getLast());
            }
        }
    }

    /**
     * 现在有一队小朋友，他们高矮不同，
     * 我们以正整数数组表示这一队小朋友的身高，如数组{5,3,1,2,3}。
     * 我们现在希望小朋友排队，以“高”“矮”“高”“矮”顺序排列，
     * 每一个“高”位置的小朋友要比相邻的位置高或者相等；
     * 每一个“矮”位置的小朋友要比相邻的位置矮或者相等；
     * 要求小朋友们移动的距离和最小，第一个从“高”位开始排，输出最小移动距离即可。
     * 例如，在示范小队{5,3,1,2,3}中，{5, 1, 3, 2, 3}是排序结果。
     * {5, 2, 3, 1, 3} 虽然也满足“高”“矮”“高”“矮”顺序排列，
     * 但小朋友们的移动距离大，所以不是最优结果。
     * 移动距离的定义如下所示：
     * 第二位小朋友移到第三位小朋友后面，移动距离为1，
     * 若移动到第四位小朋友后面，移动距离为2；
     * <p>
     * 输入描述:
     * 排序前的小朋友，以英文空格的正整数：
     * 4 3 5 7 8
     * 注：小朋友<100个
     * 输出描述:
     * 排序后的小朋友，以英文空格分割的正整数：
     * 4 3 7 5 8
     * 备注：4（高）3（矮）7（高）5（矮）8（高），
     * 输出结果为最小移动距离，只有5和7交换了位置，移动距离都是1.
     * <p>
     * 示例一：
     * 输入
     * 4 1 3 5 2
     * 输出
     * 4 1 5 2 3
     * <p>
     * 示例二：
     * 输入
     * 1 1 1 1 1
     * 输出
     * 1 1 1 1 1
     * 说明：相邻位置可以相等
     * <p>
     * 示例三：
     * 输入：
     * xxx
     * 输出
     * []
     * 说明：出现非法参数情况，返回空数组
     */
    private static void test71() {
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            List<Integer> collect;
            try {
                collect = Arrays.stream(s.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            } catch (Exception e) {
                System.out.println("[]");
                return;
            } finally {
            }
            for (int i = 0; i < collect.size() - 1; i++) {
                if (i % 2 == 0 && collect.get(i) < collect.get(i + 1)) {
                    swap(collect, i, i + 1);
                }
                if (i % 2 != 0 && collect.get(i) > collect.get(i + 1)) {
                    swap(collect, i, i + 1);
                }
            }

            StringBuffer sb = new StringBuffer();
            collect.forEach(e -> sb.append(e).append(" "));
            System.out.println(sb.toString().substring(0, sb.length() - 1));
        }
    }

    private static void swap(List<Integer> collect, Integer integer, Integer integer1) {
        Integer integer2 = collect.get(integer);
        Integer integer3 = collect.get(integer1);
        collect.set(integer, integer3);
        collect.set(integer1, integer2);
    }

    /**
     * 输入描述：
     * 第一行输入N：N表示有N个小朋友
     * 第二行输入N个小朋友的身高height[i]，都是整数
     * 输出描述：
     * 输出N个小朋友的好朋友的位置
     * <p>
     * 示例一：
     * 输入：
     * 2
     * 100 95
     * 输出：
     * 0 0
     * <p>
     * 说明：
     * 第一个小朋友身高100，站在队尾位置，向队首看，
     * 没有比他身高高的小朋友，所以输出第一个值为0.
     * 第二个小朋友站在队首，前面也没有比他身高高的小朋友，
     * 所以输出第二个值为0.
     * <p>
     * 示例二：
     * 输入
     * 8
     * 123 124 125 121 119 122 126 123
     * 输出
     * 1 2 6 5 5 6 0 0
     * <p>
     * 说明：
     * 123的好朋友是1位置上的124
     * 124的好朋友是2位置上的125
     * 125的好朋友是6位置上的126
     * 以此类推
     */
    private static void test72() {
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Integer> collect = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < collect.size(); i++) {
                Integer integer = collect.get(i);
//                int j;
                int pos = 0;
                for (int j = i; j < collect.size(); j++) {
                    if (collect.get(j) > integer) {
//                        sb.append(j).append(" ");
                        pos = j;
                        break;
                    }
                }
                sb.append(pos).append(" ");
            }
            System.out.println(sb.toString().substring(0, sb.length() - 1));
        }

    }

    /**
     * 给出一个只包含字母的字符串,
     * 不包含空格,统计字符串中各个子字母(区分大小写)出现的次数,
     * 并按照字母出现次数从大到小的顺序输出各个字母及其出现次数
     * 如果次数相同,按照自然顺序排序,且小写字母在大写字母之前
     * <p>
     * 输入描述:
     * 输入一行仅包含字母的字符串
     * <p>
     * 输出描述:
     * 按照字母出现次数从大到小的顺序输出各个字母和字母次数,
     * 用英文分号分割,
     * 注意末尾的分号
     * 字母和次数中间用英文冒号分隔
     * <p>
     * 示例:
     * 输入: xyxyXX
     * 输出:x:2;y:2;X:2;
     * 说明:每个字符出现的次数为2 故x排在y之前
     * 而小写字母x在大写X之前
     * <p>
     * 示例2:
     * 输入:
     * abababb
     * 输出:
     * b:4;a:3
     * 说明:b的出现个数比a多 故排在a前
     */
    private static void test73() {
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            Map<Character, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                Integer orDefault = treeMap.getOrDefault(c, 0);
                treeMap.put(c, orDefault + 1);
            }
            List<Test73Use> list = new ArrayList<>();
            treeMap.forEach((k, v) -> {
                Test73Use test73Use = new Test73Use(k, v);
                list.add(test73Use);
            });

            List<Test73Use> collect = list.stream().sorted().collect(Collectors.toList());
            StringBuffer sb = new StringBuffer();
            collect.forEach(e -> {
                sb.append(e.c).append(":").append(e.n).append(";");
            });

            System.out.println(sb.toString().substring(0, sb.length() - 1));
        }
    }

    static class Test73Use implements Comparable<Test73Use> {
        char c;
        int n;

        public Test73Use(char c, int n) {
            this.c = c;
            this.n = n;
        }

        @Override
        public int compareTo(Test73Use o) {
            if (this.n != o.n) {
                return this.n < o.n ? 1 : -1;
            }
            if (Character.isUpperCase(this.c)) {
                return this.c - o.c < 0 ? -1 : 1;
            }
            if (Character.isUpperCase(o.c)) {
                return this.c - o.c < 0 ? 1 : -1;
            }
            return this.c < o.c ? -1 : 1;
        }
    }
}
