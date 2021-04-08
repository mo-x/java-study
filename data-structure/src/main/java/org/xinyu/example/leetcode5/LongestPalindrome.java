package org.xinyu.example.leetcode5;

/**
 * leetcode 5 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 *
 * @author xinyu.zhang
 */
public class LongestPalindrome {


    /**
     * 中心扩散算法
     * 从开始位置分别比对与左字符串和右字符串 还有左右字符串是否相等
     * 例如 abbccba
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        //当前回文字符串最大长度 因为不为空的字符串至少有一个为回文字符串 所以该处为1
        int len = 1;
        //最大长度
        int maxLen = 0;
        //最长回文字符串起始位置
        int maxStart = 0;
        for (int i = 0; i < chars.length; i++) {
            left = i - 1;
            right = i + 1;
            //比较当前字符串与左边字符串是否相等
            //0号位置左边无元素所以不需要比对
            while (left >= 0 && chars[i] == chars[left]) {
                len++;
                //相等则要将左指针左移
                left--;
            }
            //比较当前字符串与右边字符串是否相等
            while (right < chars.length && chars[i] == chars[right]) {
                len++;
                //相等则要将左指针右移
                right++;
            }
            //比较左右字符串是否相等
            while (left >= 0 && right < chars.length && s.charAt(left) == s.charAt(right)) {
                //左右字符串相等这里+2
                len = len + 2;
                left--;
                right++;
            }
            //如果当前回文字符串最大长度大于历史长度 则更新字符长度和最大字符串开始其实字段
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    /**
     * @param left
     * @param right
     * @param chars
     * @return
     */
    public static int isTrue(int left, int right, char[] chars) {
        int maxLength = 0;
        while (left >= 0 && right + 1 > chars.length) {
            if (chars[left] != chars[right]) {
                break;
            }
            left++;
            right++;
            maxLength = Math.max(right - left + 1, maxLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abba"));
//        System.out.println(longestPalindrome("abbcbba"));
//        System.out.println(longestPalindrome("cbddbbbc"));
//        System.out.println(longestPalindrome("a"));
//        System.out.println(longestPalindrome("ac"));
//        System.out.println(longestPalindrome("bb"));
//        System.out.println(longestPalindrome("abbccba"));
//        System.out.println(longestPalindrome("abbcsbba"));
//        System.out.println(longestPalindrome("aacabdkacaa"));
    }
}
