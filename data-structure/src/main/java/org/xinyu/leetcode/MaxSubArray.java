package org.xinyu.leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * <p>示例:
 *
 * <p>输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
  public static void main(String[] args) {
    //
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    maxSubArray1(nums);
    maxSubArray2(nums);
  }

  /**
   * 穷举法
   *
   * @param nums
   * @return
   */
  public static int maxSubArray1(int[] nums) {
    // 记录没一轮的最大值
    int max = nums[0];
    for (int i = 0; i < nums.length; i++) {
      // sum 为每一轮的累加的值
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        max = sum > max ? sum : max;
      }
    }
    System.out.println(max);
    return max;
  }

  /**
   * 动态规划
   *
   * @param nums
   * @return
   */
  public static int maxSubArray2(int[] nums) {
    // sums[]存数组累加的值
    int[] sum = new int[nums.length];
    //max 记录最大值
    int max = nums[0];
    sum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      // sum数组记录记录最大值 是相加的还是本身值比较大
      sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
      //
      max = Math.max(max, sum[i]);
    }
    System.out.println(max);
    return max;
  }
}
