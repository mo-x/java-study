package org.xinyu.example.leetcode680;

/**
 * leetcode 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 */
public class ValidPalindrome {

    public static boolean validPalindrome(String s) {
        if (s.isEmpty()) return false;
        if (s.length() == 1) return true;
        char[] chars = s.toCharArray();
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (chars[low] == chars[high]) {
                low++;
                high--;
            } else {
                return validPalindrome(low, high - 1, s) || validPalindrome(low + 1, high, s);
            }
        }
        return true;
    }

    /**
     * 判断是否为回文字符串
     *
     * @param low
     * @param high
     * @param s
     * @return
     */
    public static boolean validPalindrome(int low, int high, String s) {
        char[] chars = s.toCharArray();
        for (int i = low, j = high; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abbca"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("eeccccbebaeeabebccceea"));
    }

}
