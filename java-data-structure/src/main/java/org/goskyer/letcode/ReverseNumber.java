package org.goskyer.letcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * <p>示例 1:
 *
 * <p>输入: 123 输出: 321 示例 2:
 *
 * <p>输入: -123 输出: -321 示例 3:
 *
 * <p>输入: 120 输出: 21 注意:
 *
 * <p>假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseNumber {

  public static int reverse1(int x) {
    int rev = 0;
    while (x != 0) {
      int pop = x % 10;
      x /= 10;
      rev = rev * 10 + pop;
    }
    return rev;
  }

  public static void main(String[] args) {
    //
    System.out.println(reverse1(124));
//    System.out.println(124 % 10);
//    System.out.println(124 / 10);
//    reverse(124);
//    System.out.println();
  }

  public static int reverse(int x) {
    int rev = 0;
    while (x != 0) {
      int pop = x % 10;
      x /= 10;
      if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
      if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
      rev = rev * 10 + pop;
    }
    return rev;
  }
}
