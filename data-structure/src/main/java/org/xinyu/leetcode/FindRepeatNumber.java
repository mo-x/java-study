package org.xinyu.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 */
public class FindRepeatNumber {


    /**
     * 利用set 集合
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        int r = -1;
        for (int n : nums) {
            if (!sets.add(n)) {
                r = n;
                break;
            }
        }
        return r;
    }

    /**
     * 利用list集合
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            if (list.contains(n)) {
                return n;
            }
            list.add(n);
        }
        return -1;
    }


    public int findRepeatNumber3(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] n = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int repeatNumber2 = new FindRepeatNumber().findRepeatNumber2(n);
        System.out.println(repeatNumber2);

        Set<String> sets = new HashSet<>();
        System.out.println(sets.add("hello"));
        System.out.println(sets.add("hello"));
    }
}
