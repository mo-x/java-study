package org.xinyu.leetcode.base;


public class Leetcode307 {


    public static boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    public static boolean isPowerOfThree1(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(9 % 3);
        System.out.println(2 % 3);
        System.out.println(27 % 3);
        System.out.println(729 % 3);
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(45));
        System.out.println(Integer.MAX_VALUE / 3);
    }

}
