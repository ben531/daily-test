package com.huwei.dailytest.niuke;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;

public class Day0201 {
    static Map<String, String> map = new HashMap<String, String>() {
        {
            put("reset", "reset what");
            put("reset board", "board fault");
            put("board add", "where to add");
            put("board delete", "no board at all");
            put("reboot backplane", "impossible");
            put("backplane abort", "install first");
        }
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String cmd = sc.nextLine();
            calculate(cmd);
        }
    }

    public static void calculate(String cmd) {
        String[] cmdArr = cmd.split(" ");
        if (cmdArr.length == 1) {
            if ("reset".contains(cmd)) {
                System.out.println(map.get("reset"));
            } else {
                System.out.println("unknown command");
            }
        } else {
            String result = "unknown command";
            int count = 0;
            for (String key : map.keySet()) {
                if (key.equals(cmd)) {
                    result = map.get(key);
                    break;
                } else {
                    String[] keyArr = key.split(" ");
                    if (keyArr.length > 1
                            && keyArr[0].indexOf(cmdArr[0]) == 0
                            && keyArr[1].indexOf(cmdArr[1]) == 0) {
                        result = map.get(key);
                        count++;
                    }
                }
            }
            System.out.println(count > 1 ? "unknown command" : result);
        }
    }


    /**
     * 得到数字二进制的 1 的个数
     */
    private static void sss() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            String s = Integer.toBinaryString(i);
            int t = 0;
            for (int j = 0; j < s.length(); j++) {
                if ("1".equalsIgnoreCase(String.valueOf(s.charAt(j)))) {
                    t++;
                }
            }
            System.out.println(t);
        }
    }

    /**
     * 获取一个数的公约数 20 = 2*2*5
     *
     * @param num
     */
    private static void getPrimer(long num) {
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                System.out.println(i + " ");
                getPrimer(num / i);
                break;
            }

            if (i == sqrt) {
                System.out.println(num + " ");
            }
        }
    }

    /**
     * 查找组成一个偶数最接近的两个素数
     */
    private static void sushu() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 2; i <= input; i++) {
                boolean flag = false;
                for (int j = 2; j <= i / 2; j++) {
                    if (i % j == 0) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    list.add(i);
                }
            }
            list.add(0, 1);
            int min = input;
            int[] arr = new int[2];
            for (int i = 0; i < list.size(); i++) {
                int other = input - list.get(i);
                if (list.contains(other)) {
                    if (Math.abs(other - list.get(i)) < min) {
                        min = Math.abs(other - list.get(i));
                        arr[0] = list.get(i);
                        arr[1] = other;
                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }


    private static void yueshu() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            yueshu(i);
        }
    }

    /**
     * 完全数
     */
    private static void 完全数() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            yueshu(i);
        }
    }

    private static void yueshu(int i) {
        int t = 0;
        for (int j = 1; j <= i; j++) {
            int sum = 0;
            for (int k = 1; k <= j / 2; k++) {
                if (j % k == 0) {
                    sum += k;
                }
                if (sum == j) {
                    t++;
                }
            }
        }
        System.out.println(t);
    }


    /**
     * 四则运算
     */
    private static void 四则运算() throws ScriptException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replace("[", "(");
        input = input.replace("{", "(");
        input = input.replace("}", ")");
        input = input.replace("]", ")");
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        Object eval = scriptEngine.eval(input);
        System.out.println(eval);
    }
}
