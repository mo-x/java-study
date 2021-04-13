package org.xinyu.leetcode.leetcode88;

import java.util.Arrays;
public class Merge {

    /**
     * System.arraycopy()
     * Object src : 原数组
     * int srcPos : 从元数据的起始位置开始
     * Object dest : 目标数组
     * int destPos : 目标数组的开始起始位置
     * int length  : 要copy的数组的长度
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }


}
