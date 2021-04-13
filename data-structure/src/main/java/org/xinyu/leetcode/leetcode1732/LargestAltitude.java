package org.xinyu.leetcode.leetcode1732;

public class LargestAltitude {


    public int largestAltitude(int[] gain) {

        int max = 0;
        int temp = 0;
        for (int i : gain) {
            temp = i + temp;
            max = Math.max(max, temp);
        }

        return max;
    }
}
