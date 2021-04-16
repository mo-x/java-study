package org.xinyu.leetcode.str;

public class LeetCode1816 {

    public static String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        String r = "";
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                r = r + s1[i];
            }
            r = r + s1[i] + " ";
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(truncateSentence("Hello how are you Contestant", 4));
    }
}
