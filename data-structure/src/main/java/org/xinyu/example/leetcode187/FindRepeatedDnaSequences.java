package org.xinyu.example.leetcode187;

import java.util.*;

/**
 * 187. 重复的DNA序列
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * <p>
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * <p>
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 * <p>
 */
public class FindRepeatedDnaSequences {


    public static List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>(0);
        Set<String> sets = new HashSet<>();
        Set<String> out = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (sets.contains(substring)) {
                out.add(substring);
            } else {
                sets.add(substring);
            }
        }
        return new ArrayList<>(out);
    }

    public static void main(String[] args) {
        List<String> r = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
//        r.forEach(System.out::println);
        r = findRepeatedDnaSequences("AAAAAAAAAA");
//        r.forEach(System.out::println);
        r = findRepeatedDnaSequences("AAAAAAAAAAA");
        r.forEach(System.out::println);
    }


}
