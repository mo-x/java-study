package org.xinyu.leetcode.str;

import java.util.HashSet;
import java.util.Set;

/**
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * <p>
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * <p>
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * 示例 2：
 * <p>
 * 输入：sentence = "leetcode"
 * 输出：false
 * <p>
 */
public class LeetCode1832 {

    /**
     * set 解法
     *
     * @param sentence
     * @return
     */
    public static boolean checkIfPangram(String sentence) {
        char[] chars = sentence.toCharArray();
        if (sentence.length() < 26) {
            return false;
        }

        Set<Character> set = new HashSet<>(20);
        for (char aChar : chars) {
            if (aChar >= 'a' && aChar <= 'z') {
                set.add(aChar);
            }
        }
        return set.size() == 26;
    }


    /**
     * 字母统计法
     *
     * @param sentence
     * @return
     */
    public static boolean checkIfPangram1(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }
        char[] chars = sentence.toCharArray();
        int[] ints = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            ints[chars[i] - 'a'] = 1;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += ints[i];
        }
        return sum == 26;
    }


    public static void main(String[] args) {
        System.out.println(checkIfPangram1("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("aaaaa"));
        System.out.println('h' - 'a');
    }
}
