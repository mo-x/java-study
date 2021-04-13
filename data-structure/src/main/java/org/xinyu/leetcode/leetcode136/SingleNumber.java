package org.xinyu.leetcode.leetcode136;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 */
public class SingleNumber {

    /**
     * 通过位运算异或
     * 异或运算特点
     * 一个数和 0 做 XOR 运算等于本身：a⊕0 = a
     * 一个数和其本身做 XOR 运算等于 0：a⊕a = 0
     * XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
     * 题中有个重点为除了某个元素只出现一次以外，其余每个元素均出现两次
     * 所以相同的数字会抵消 如 1 ^ 2 ^4^ 1 ^ 2 =4 1和2都会抵消
     * <p>
     * 该题还有排序和利用set集合求解
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int num = 0;
        for (int j : nums) {
            num = num ^ j;
        }
        return num;
    }


    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(arr));
        arr = new int[]{2, 2, 1};
        System.out.println(singleNumber(arr));
        System.out.println(1 ^ 2 ^ 4 ^ 1 ^ 2);
    }
}
