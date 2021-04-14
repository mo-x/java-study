package org.xinyu.leetcode.str;

import java.util.*;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 */
public class LeetCode387 {

    /**
     * 利用map集合存储
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        Map<Character, Integer> result = new HashMap<>(s.length());
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            result.put(aChar, result.getOrDefault(aChar, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (result.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 只出现一次的字符首次出现和最后出现的位置相等
     *
     * @param s
     * @return
     */
    public static int firstUniqChar1(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (s.indexOf(chars[i]) == s.lastIndexOf(chars[i])) {
                return i;
            }
        }
        return -1;
    }

    //todo 此处没懂
    public static int firstUniqChar2(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        //先统计每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            count[chars[i] - 'a']++;
        }
        //然后在遍历字符串s中的字符，如果出现次数是1就直接返回
        for (int i = 0; i < s.length(); i++) {
            if (count[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        System.out.println(firstUniqChar2("leetcodeloveleetcodeloveleetcodes"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println('l' - 'a');
        int[] count = new int[26];
        count['l' - 'a']++;
        System.out.println("");


    }
}
