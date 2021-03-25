package org.goskyer.example.leetcode7;

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
            x = x / 10;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        //
        System.out.println(reverse(213));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
//    System.out.println(124 % 10);
//    System.out.println(124 / 10);
//    reverse(124);
//    System.out.println();
    }

    /**
     * 利用取模运算取最后一位
     * 然后利用除法运算去掉最后一位
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        //记录反转后的值
        int rev = 0;
        while (x != 0) {
            //取模运算取数字的最后一位 例如2147483647%10 取 7
            int pop = x % 10;
            //除法运算去掉最后一位 例如2147483647%10 得 214748364
            x = x / 10;
            //int 类型最大值为 2147483647 最小值为 -2147483648 所以翻转数字的时候要考虑是否溢出
            //2147483647取反的时第一位为7 -2147483648 如果按照题目规则取反时为 -8
            //所以该2处的判断条件是为了判断是否数字反转后溢出
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            /**
             *乘10来做反转后的进位 例如 124 反转后为421
             *      第一次循环       0*10+4=4
             *      第二次循环      4*10+2=42
             *      第三次循环      42*10+1=421
             */

            rev = rev * 10 + pop;
        }
        return rev;
    }
}
