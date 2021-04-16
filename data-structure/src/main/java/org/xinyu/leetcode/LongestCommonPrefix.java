package org.xinyu.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * <p>如果不存在公共前缀，返回空字符串 ""。
 *
 * <p>示例 1:
 *
 * <p>输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
 *
 * <p>输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:
 *
 * <p>所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    /**
     * 水平扫描法
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strings = {"dog", "racecar", "car"};
        String[] strings1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strings));
        System.out.println(longestCommonPrefix(strings1));
        StringBuilder stringBuilder = new StringBuilder();
    }
}
