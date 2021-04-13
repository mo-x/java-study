package org.xinyu.leetcode.str;

public class LeetCode541 {

    /**
     * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
     * <p>
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *  
     * <p>
     * 示例:
     * <p>
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     *  
     * <p>
     * 提示：
     * <p>
     * 该字符串只包含小写英文字母。
     * 给定字符串的长度和 k 在 [1, 10000] 范围内
     * <p>
     *
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        if (s.length() < k) {
            return new StringBuilder(s).reverse().toString();
        }
        char[] chars = s.toCharArray();
        //每次循环的步数改为2*k 2 4 6
        for (int start = 0; start < chars.length; start += 2 * k) {
            int i = start;
            //如果剩余字符少于 k 个，则将剩余字符全部反转。
            int j = Math.min(start + k - 1, chars.length - 1);
            //进行字符交换
            while (i < j) {
                char tmp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = tmp;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String result = reverseStr("abcdefg", 2);
        System.out.println("bacdfeg".equals(result));
    }
}
