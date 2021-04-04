package org.xinyu.dynamicprogramming;

public class Test {

    public static void main(String[] args) {
        int f = f(27);
        System.out.println(f);
        int x = count(11);
        System.out.println(x);
    }


    public static int f(int x) {
        if (x == 0) {
            return 0;
        }
        int res = x;
        if (x >= 2) {
            res = Math.min(f(x - 2) + 1, res);
        }

        if (x >= 5) {
            res = Math.min(f(x - 5) + 1, res);
        }
        if (x >= 7) {
            res = Math.min(f(x - 7) + 1, res);
        }
        return res;
    }

    /**
     * 说有三种重量1，2，5的球，个数不限，输出重量和为11的最少球个数的组合
     *
     * @param x
     * @return
     */
    public static int count(int x) {

        StringBuilder sb = new StringBuilder();
        if (x == 0) {
            return 0;
        }
        int res = x;
        if (x >= 1) {
            res = Math.min(count(x - 1) + 1, res);
        }
        if (x >= 2) {
            res = Math.min(count(x - 2) + 1, res);
        }
        if (x >= 5) {
            res = Math.min(count(x - 5) + 1, res);
        }
        return res;
    }
}
