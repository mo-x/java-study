package org.xinyu.leetcode.array.leetcode349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * <p>
 */
public class Intersection {

    /**
     * 利用set集合
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(nums1.length);
        for (int j : nums1) {
            set.add(j);
        }
        Set<Integer> list = new HashSet<>();
        for (int j : nums2) {
            if (set.contains(j)) {
                list.add(j);
            }
        }
        if (list.isEmpty()) {
            return new int[]{};
        }
        int[] ints = new int[list.size()];
        int len = 0;
        for (int i : list) {
            ints[len] = i;
            len++;
        }
        return ints;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
