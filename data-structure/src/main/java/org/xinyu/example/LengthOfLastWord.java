package org.xinyu.example;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * <p>如果不存在最后一个单词，请返回 0 。
 *
 * <p>说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * <p>示例:
 *
 * <p>输入: "Hello World" 输出: 5
 */
public class LengthOfLastWord {

  /**
   * @param s
   * @return
   */
  public int lengthOfLastWord(String s) {
    if (s == null) {
      return 0;
    }
    String[] s1 = s.split(" ");
    return s1.length == 0 ? 0 : s1[s1.length - 1].length();
  }
}
