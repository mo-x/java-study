package org.xinyu.leetcode.leetcode1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * @author zhiqin.zhang
 */
public class TwoSum {
  public static void main(String[] args) {
    int[] nums = {3, 2, 4};
    int[] ints = TwoSum.twoSum(nums, 6);

    System.out.println(Arrays.toString(ints));
    System.out.println(Arrays.toString(twoSumByMap1(nums, 6)));
    System.out.println(Arrays.toString(twoSumByMap2(nums, 6)));
    System.out.println(Arrays.toString(twoSumByMap3(nums, 6)));
  }

  /**
   * 循环数组 求值
   *
   * @param nums
   * @param target
   * @return
   */
  private static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          result[0] = i;
          result[1] = j;
        }
      }
    }
    return result;
  }

  /**
   * 利用
   *
   * @param ints
   * @param taget
   * @return
   */
  private static Integer[] twoSumByMap1(int[] ints, int taget) {
    Map<Integer, Integer[]> map = new HashMap<>(ints.length);
    for (int i = 0; i < ints.length; i++) {
      for (int j = i + 1; j < ints.length; j++) {
        Integer[] sumResult = {i, j};
        map.put(ints[i] + ints[j], sumResult);
      }
    }
    return map.get(taget);
  }

  private static int[] twoSumByMap2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] {i, map.get(complement)};
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  private static int[] twoSumByMap3(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }
}
