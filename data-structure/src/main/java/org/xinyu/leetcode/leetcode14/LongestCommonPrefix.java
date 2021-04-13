package org.xinyu.leetcode.leetcode14;


/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class LongestCommonPrefix {


    /**
     * 横向扫描算法
     * 将第一个元素取出 和每个对比 取出最长的前缀
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
        }
        return prefix;
    }

    public static String longestCommonPrefix(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return "";
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int len = Math.min(s1.length(), s2.length());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (chars1[i] == chars2[i]) {
                stringBuilder.append(chars1[i]);
            } else {
                break;
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"flower", "flowLK", "flight"};
//
//        System.out.println(longestCommonPrefix(strings));
//
//        Arrays.sort(strings);
//        strings = new String[]{"dog", "racecar", "car"};
        strings = new String[]{"a"};
        strings = new String[]{"aaa", "aa", "aaa"};
        System.out.println(longestCommonPrefix(strings));
    }


}
