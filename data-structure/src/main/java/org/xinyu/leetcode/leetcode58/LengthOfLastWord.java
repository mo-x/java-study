package org.xinyu.leetcode.leetcode58;

/**
 * leetcode 58 最后一个单词长度
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：s = " "
 * 输出：0
 * <p>
 */
public class LengthOfLastWord {


    /**
     * 顺序遍历截取字符串
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = s.lastIndexOf(" ");
        String substring = s.substring(i + 1);
        if (substring.length() == 0) {
            String substring1 = s.substring(0, i);
            return lengthOfLastWord(substring1);
        }
        return substring.length();
    }


    public static void main(String[] args) {
        String str = "hello world";
        int i = str.lastIndexOf(" ");
        System.out.println(i);
        System.out.println(str.substring(i + 1, str.length()));

        System.out.println("==========");
        System.out.println(lengthOfLastWord("hello world"));
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord("a "));
        System.out.println(lengthOfLastWord("b a "));
    }
}
