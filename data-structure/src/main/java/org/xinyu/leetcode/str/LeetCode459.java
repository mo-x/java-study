package org.xinyu.leetcode.str;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 * 除了以下的解法 还有正则和kmp匹配解法
 *
 */
public class LeetCode459 {

    /**
     * 首尾去除
     * 重复字符串的构成为str = s(字符串) * n(数量)
     * 例如 str = "abcabc"
     * abcabcabcabc
     * 去除首尾  bcabcabcab 若是重复子串肯定包含了abc
     *
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    /**
     * 重复字符串的构成为str = n(字符串) * s(数量)
     * 所以最大字符串的长度为str.length/2
     * 循环从0号位开始判断当前子串*n能和str匹配
     * 例如
     * abcabc
     * a*n= abcabc
     * ab*n = abcabc
     *
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern1(String s) {
        int len = s.length();
        StringBuilder pattern = new StringBuilder();

        for (int i = 0; i < len / 2; i++) {
            pattern.append(s.charAt(i));
            // 当前子串长度是原字符串的整数倍且成功匹配
            if (len % (i + 1) == 0 && s.matches("(" + pattern + ")+")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("abcd".substring(0, 4));
        System.out.println(repeatedSubstringPattern1("abcabc"));
        String str = "abcabcd";
        System.out.println(str.matches("(" + "abc" + ")+"));
    }
}
