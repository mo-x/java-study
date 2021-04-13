package org.xinyu.leetcode.leetcode3;

import java.util.*;

/**
 *
 * leetcode 3 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 */
public class LengthOfLongestSubstring {


    /***
     * 暴力解法
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        //长度为2直接返回
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (isTrue(i, j, s)) {
                    max = Math.max((j - i) + 1, max);
                }
            }
        }
        if (max == 0) {
            return 1;
        }

        return max;

    }

    public static boolean isTrue(int start, int end, String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = start; i < (end + 1); i++) {
            set.add(chars[i]);
        }
        return set.size() == (end - start + 1);
    }

    /**
     * 滑动窗口算法
     * 利用快慢指针
     *
     * @param s
     * @return
     */
    public static int longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int max = 0;
        Map<Character, Integer> set = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int right = 0; right < chars.length; right++) {
            if (set.containsKey(chars[right])) {
                //左指针右移 因为遍历肯定是向后移动 所以要左指针要调到最后出现重复的位置位置
                left = Math.max(left, set.get(chars[right]));
            }
            //这里加+1是为了跳转到指定位置
            set.put(chars[right], right + 1);
            max = Math.max(right - left + 1, max);
        }
        return max;
    }


    /**
     * @param s
     * @return
     */
    public static int longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>(1);
        String subString = "";
        Map<Character, Integer> set = new HashMap<>();
        int max = 0;
        for (int r = 0, l = 0; r < chars.length; r++) {
            if (!set.containsKey(chars[r])) {
                set.put(chars[r], r);
            } else {
                max = Math.max(max, set.size());
                set.put(chars[r], r);
            }
        }
        return max;
    }


    public static int longestPalindrome3(String s) {
        char substr;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int findIndex = s.indexOf(chars[i]);

        }
        return 0;

    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome2("abcabcbb"));
        System.out.println(longestPalindrome2("  "));
//        System.out.println(longestPalindrome2("abba"));
//        System.out.println(longestPalindrome2("bbbbb"));
//        System.out.println(longestPalindrome("pwwkew"));
//        System.out.println(longestPalindrome2("abcabcbb"));
        System.out.println(longestPalindrome2("dvdf"));
//        System.out.println(longestPalindrome(""));
//        System.out.println(longestPalindrome("auc"));
    }
}