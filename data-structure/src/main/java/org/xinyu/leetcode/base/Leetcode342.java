package org.xinyu.leetcode.base;

public class Leetcode342 {

    public boolean isPowerOfFour(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 4 == 0) {
            n = n / 4;
        }
        return n == 1;
    }
}
