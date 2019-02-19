package org.goskyer.letcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * <p>有效字符串需满足：
 *
 * <p>左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 *
 * <p>示例 1:
 *
 * <p>输入: "()" 输出: true 示例 2:
 *
 * <p>输入: "()[]{}" 输出: true 示例 3:
 *
 * <p>输入: "(]" 输出: false 示例 4:
 *
 * <p>输入: "([)]" 输出: false 示例 5:
 *
 * <p>输入: "{[]}" 输出: true
 */
public class IsValid {

  public static boolean isValid(String s) {
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');
    Stack<Character> stringStack = new Stack<>();
    if ("".equals(s)) {
      return true;
    }
    if (s == null || s.length() == 1) {
      return false;
    }
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (map.get(c) == null) {
        stringStack.push(c);
      } else if (stringStack.size() > 0 && map.get(c).equals(stringStack.peek())) {
        stringStack.pop();
      } else {
        return false;
      }
    }
    return stringStack.size() == 0;
  }

  public static void main(String[] args) {
    System.out.println(isValid("]"));
    System.out.println(isValid(""));
    System.out.println(isValid("]["));
    System.out.println(isValid("([)]"));
    System.out.println(isValid("{[]}"));
    System.out.println(isValid("(]"));
    System.out.println(isValid("()[]{}"));
  }
}
