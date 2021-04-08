package org.xinyu.example.leetcode67;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 */
public class AddBinary {


    /**
     * 首先通过补位使位置对齐
     * 然后字符串倒序相加 利用进位 来做运算
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        //获取最大长度
        int len = Math.max(a.length(), b.length());
        //对齐字符串
        StringBuilder aBuilder = new StringBuilder(a);
        while (aBuilder.length() < len) {
            aBuilder.insert(0, "0");
        }
        a = aBuilder.toString();
        StringBuilder bBuilder = new StringBuilder(b);
        while (bBuilder.length() < len) {
            bBuilder.insert(0, "0");
        }
        b = bBuilder.toString();

        StringBuilder sq = new StringBuilder();
        int carry = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            int val1 = c1 == '1' ? 1 : 0;
            int val2 = c2 == '1' ? 1 : 0;
            int curr = val1 + val2 + carry;
            //这里判断数字相加的进位情况 二进制运算中只有这4种情况可以判断
            switch (curr) {
                case 3:
                    sq.append("1");
                    carry = 1;
                    break;
                case 2:
                    sq.append("0");
                    carry = 1;
                    break;
                case 1:
                    sq.append("1");
                    carry = 0;
                    break;
                case 0:
                    sq.append("0");
                    break;
                default:
                    break;
            }
        }
        //首位如果还有进位需加一
        if (carry >= 1) {
            sq.append("1");
        }
        //这里需要反转字符串输出
        return sq.reverse().toString();
    }

    public static void main(String[] args) {
//        System.out.println(addBinary("11", "1"));
//        System.out.println(addBinary("1010", "1011"));
        //"11110"
        System.out.println(addBinary("1111", "1111"));
//        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
//        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
//        System.out.println(addBinary(a, b));

        System.out.println('1' + '1');
    }
}
