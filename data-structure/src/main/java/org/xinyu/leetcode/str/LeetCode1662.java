package org.xinyu.leetcode.str;

public class LeetCode1662 {

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "";
        for (String str : word1) {
            s1 = s1 + str;
        }
        String s2 = "";
        for (String str : word2) {
            s2 = s2 + str;
        }

        return s1.equals(s2);

    }
}
