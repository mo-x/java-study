package org.xinyu.leetcode.str;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * * <p>
 * *  
 * * <p>
 * * 提示：
 * * <p>
 * * num1 和num2 的长度都小于 5100
 * * num1 和num2 都只包含数字 0-9
 * * num1 和num2 都不包含任何前导零
 * * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * * <p>
 * *
 * * @param num1
 * * @param num2
 * * @return
 */

//Todo 双指针写法
public class LeetCode415 {

    /**
     * 对位补齐 相加策略
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        int max = Math.max(num1.length(), num2.length());
        //对齐补0
        num2 = getString(num2, max);
        num1 = getString(num1, max);
        char[] c2 = num2.toCharArray();
        char[] c1 = num1.toCharArray();
        //进位
        int carry = 0;
        StringBuilder result = new StringBuilder(max + 1);
        for (int i = num1.length() - 1; i >= 0; i--) {
            int curr = (int) c2[i] - '0' + (int) c1[i] - '0' + carry;
            if (curr >= 10) {
                //获取余数
                result.append(curr % 10);
                carry = 1;
            } else {
                result.append(curr);
                carry = 0;
            }
        }
        if (carry > 0) {
            result.append("1");
        }
        return result.reverse().toString();
    }

    /**
     * 如果两个字符串长度不相等补齐字符串 补齐规则前面+0
     * 例如 11 134 补齐为011 134
     *
     * @param num2
     * @param max
     * @return
     */
    private static String getString(String num2, int max) {
        if (num2.length() < max) {
            int r = max - num2.length();
            StringBuilder num2Builder = new StringBuilder(num2);
            for (int i = 0; i < r; i++) {
                num2Builder.insert(0, "0");
            }
            num2 = num2Builder.toString();
        }
        return num2;
    }

    public static void main(String[] args) {
//        System.out.println((int) '1' - '0' + (int) '2' - '0');
//        System.out.println(addStrings("29", "1"));
//        System.out.println(addStrings("11", "123"));
        System.out.println(addStrings("456", "077"));
    }

}
