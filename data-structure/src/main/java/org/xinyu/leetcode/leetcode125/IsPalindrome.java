package org.xinyu.leetcode.leetcode125;

/**
 * leetcode 125 验证是回文字符串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome {


    /**
     * 利用首位指针来判断 如果不是数字或者数字 左移 或者右移
     * 还有一种解法为先对字符串进行处理 保留数字和字母并进行大写或者小写转换
     * 然后利用首尾指针进行比对
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            //isLetterOrDigit 判断是否为字符或者是数字
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;

    }


    public static void main(String[] args) {
        boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
        palindrome = isPalindrome("race a car");
        System.out.println(palindrome);
    }


}
