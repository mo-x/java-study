package org.xinyu.leetcode.str;

public class LeetCode434 {


    public static int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        String[] s1 = s.split(" ");
//        return Stream.of(s1).filter(n -> n.length() > 0).toArray().length;
        int count = 0;
        for (String str : s1) {
            if (str.length() > 0) {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int i = countSegments(", , , ,        a, eaefa");
        System.out.println(i);
    }
}
