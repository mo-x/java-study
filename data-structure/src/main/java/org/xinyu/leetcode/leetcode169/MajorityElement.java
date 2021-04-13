package org.xinyu.leetcode.leetcode169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 * <p>
 * 进阶：
 * <p>
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class MajorityElement {


    /**
     * 利用map存储次数
     *
     * @param nums
     * @return
     */
    public static int majorityElementByMap(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(nums.length);
        for (int num : nums) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > nums.length >> 1) {

                return entry.getKey();
            }
        }
        //return -1
        int[] res = new int[1];
        count.forEach((k, v) -> {
            if (v > nums.length >> 1) {
                res[0] = k;
            }
        });
        return res[0];
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }


    /**
     * 摩尔投票法思路
     * 题目给出数组中必定存在nums即存在多数元素
     * 所以采用投票发来进行数字不同来抵消原则
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        int temp = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (temp == nums[i]) {
                count++;
            } else if (count-- == 0) {
                temp = nums[i];
                count = 1;
            }
        }
        return temp;
    }


    public static void main(String[] args) {
        System.out.println(3 >> 1);
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement1(new int[]{3, 3, 1, 1, 1, 1, 2, 2, 3}));
    }
}
