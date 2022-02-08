package com.huwei.dailytest.niuke;

import java.util.Scanner;

public class Day0207 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    /**
     * TODO 输出打印不连续的数组
     * VLAN资源池
     * <p>
     * 20-21,15,18,20-30,5-10
     * 30
     * 输出:
     * 5-10,18,20-21,30
     */
    private static void test4() {
        while (scanner.hasNext()) {
            String resource = scanner.nextLine();
            int target = Integer.parseInt(scanner.nextLine());
            String[] split = resource.split(",");
            int[] arr = new int[31];
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains("-")) {
                    int start = Integer.parseInt(split[i].split("-")[0]);
                    int end = Integer.parseInt(split[i].split("-")[1]);
                    for (int j = start; j <= end; j++) {
                        arr[j] = j;
                    }
                } else {
                    arr[Integer.parseInt(split[i])] = Integer.parseInt(split[i]);
                }
            }
            arr[target] = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                int first = 0;
                int last = 0;
                int temp = 0;
                if (arr[i] != 0) {
                    first = arr[i];
                    if (i == arr.length - 1) {
                        last = arr[i];
                    } else {
                        for (int j = i + 1; j < arr.length; j++) {
                            if (arr[j] == 0) {
                                last = arr[j - 1];
                                break;
                            } else {
                                temp++;
                                continue;
                            }
                        }
                    }
                    if (first == last) {
                        sb.append(first + ",");
                    } else {
                        sb.append(first + "-" + last + ",");
                    }
                }

                i += temp;
            }
            System.out.println(sb.toString().substring(0, sb.length() - 1));

        }
    }

    /**
     * TLV解码
     */
    private static void test3() {
        while (scanner.hasNext()) {
            String key = scanner.nextLine();
            String[] arr = scanner.nextLine().replaceAll("[a-z]", "").split("[ ]");
            String tag = "";
            int length;
            String value = "";
            for (int i = 0; i < arr.length; ) {
                tag = "";
                length = 0;
                value = "";
                tag = arr[i];
                length = Integer.valueOf(arr[i + 2] + arr[i + 1], 16);
                for (int j = 1; j <= length; j++) {
                    value += arr[i + 2 + j] + " ";
                }
                if (key.equals(tag)) {
                    System.out.println(value.trim());
                }
//				System.out.println(tag+" "+length+" "+value.trim());
                i = i + 2 + length + 1;
            }
        }
    }

    /**
     * 自编码的 N进制减法
     *
     * @param a
     * @param b
     * @param jizhi
     * @return
     */
    static String addByJinzhi(String a, String b, int jizhi) {
        StringBuffer ans = new StringBuffer();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % jizhi + '0'));
            carry /= jizhi;
        }
        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }

    /**
     * N进制减法
     */
    private static void test2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            if (s[1].startsWith("0") || s[2].startsWith("0")) {
                System.out.println("-1");
                break;
            }
            int n = Integer.parseInt(s[0]);
            String n1 = s[1];
            String n2 = s[2];

            int i1 = Integer.parseInt(n1, n);
            int i2 = Integer.parseInt(n2, n);

            int result = i1 - i2;
            String[] res = new String[2];
            if (result > 0) {
                res[0] = "0";
            } else {
                res[0] = "1";
            }
            String string = Integer.toString(result, n);
            res[1] = string;
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
        }
    }

    /**
     * 5键键盘的输出
     * <p>
     * 用数字1 2 3 4 5代表a，ctrl-c，ctrl-x，ctrl-v，ctrl-a五个键的输入，数字用空格分隔
     * 示例1：
     * 输入
     * 1 1 5 1 5 2 4 4
     * 输出
     * 2
     */
    private static void test1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] sp = line.split(" ");
            int count = 0; // 字面长度
            int copyCount = 0; // 粘贴板长度
            int selCount = 0; // 选择的长度
            for (int i = 0; i < sp.length; i++) {
                int n = Integer.parseInt(sp[i]);
                if (n == 1) {
                    if (selCount > 0) {
                        count = 1;
                    } else {
                        count++;
                    }
                    selCount = 0;
                } else if (n == 2) {
                    if (selCount > 0) {
                        copyCount = selCount;
                    }
                } else if (n == 3) {
                    if (selCount > 0) {
                        count = 0;
                        copyCount = selCount;
                        selCount = 0;
                    }
                } else if (n == 4) {
                    if (selCount > 0) {
                        count = copyCount;
                        selCount = 0;
                    } else {
                        count += copyCount;
                    }
                } else {
                    selCount = count;
                }
            }
            System.out.println(count);
        }
    }
}
