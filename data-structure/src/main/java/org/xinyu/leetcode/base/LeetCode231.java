package org.xinyu.leetcode.base;


/**
 * leetcode 231. 2的幂
 */
public class LeetCode231 {

    /**
     * 2的幂次方的特性
     * n & (n-1) == 0
     * 例如
     * 2 & (2-1) == 0
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        long v = (long) n & ((long) n - 1);
        return v == 0;
    }

    public static boolean isPowerOfTwo1(int n) {
        if (n == 0) {
            return false;
        }
        int x = n & (-n);
        return x == n;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(16 - 1));

        System.out.println(isPowerOfTwo(-2147483648));


    }
}
