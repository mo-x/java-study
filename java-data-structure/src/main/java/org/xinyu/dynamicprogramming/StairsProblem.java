package org.xinyu.dynamicprogramming;


import java.util.HashMap;
import java.util.Map;

/**
 * 一个阶梯为N 从一阶梯走到N 有多少种走法
 * 一个3阶楼梯的走法
 * f1= 1
 * f2= 2
 * f3 = f1+f2
 * f4 = f3+f2
 * .
 * .
 * .
 * fn = f(n-1)+f(fn-2)
 */
public class StairsProblem {

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int count(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }
        //上一次迭代的结果
        int a = 1;
        //上上一次迭代的结果
        int b = 2;
        //当前迭代的结果
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    /**
     * 递归解法
     * f(n) = f(n-1)+f(n-2)
     * f(n-1) = f(n-2)
     *
     * @param n
     * @return
     */
    public static int getClimbingWays(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return getClimbingWays(n - 1) + getClimbingWays(n - 2);
    }


    public static int getClimbingWays(int n, Map<Integer, Integer> map) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int v = getClimbingWays(n - 1) + getClimbingWays(n - 2);
            map.put(n, v);
            return v;
        }

    }


    public static void main(String[] args) {
        System.out.println(count(10));
        System.out.println(getClimbingWays(10));
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(getClimbingWays(10, map));
    }
}
