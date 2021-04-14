package org.xinyu.leetcode.str;

public class LeetCode520 {

    /**
     * char 是可以用整数来计算的 大写字母的范围是在65和90之间
     * 如果用Character来判断字符的大小写执行速度和所占的内存会高
     *
     * @param word
     * @return
     */

    public static boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                count++;
            }
        }
        //全大写
        if (count == word.length()) {
            return true;
        }
        //全小写
        if (count == 0) {
            return true;
        }
        if (chars[0] >= 65 && chars[0] <= 90) {
            return count == 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("ffffffffffffffffffffF"));
    }
}
