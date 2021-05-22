package org.xinyu.leetcode.leetcode322;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * <p>你可以认为每种硬币的数量是无限的。
 *
 * <p>示例 1：
 *
 * <p>输入：coins = [1, 2, 5], amount = 11 输出：3 解释：11 = 5 + 5 + 1 示例 2：
 *
 * <p>输入：coins = [2], amount = 3 输出：-1 示例 3：
 *
 * <p>输入：coins = [1], amount = 0 输出：0 示例 4：
 *
 * <p>输入：coins = [1], amount = 1 输出：1 示例 5：
 *
 * <p>输入：coins = [1], amount = 2 输出：2
 *
 * <p>
 */
public class CoinChange {

  public static int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    // 初始化数组 表示每个金额的最优解
    int[] dp = new int[amount + 1];
    // 0元的最优解为0
    dp[0] = 0;
    //
    for (int i = 1; i <= amount; i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int j : coins) {
        // 1.首先计算的金额要大于输入的金额
        // 2.dp[i-j]表示最后剩余的金额最优解不能是无解的
        // 3.dp[i-j]+1 表示剩余当前的最优解不能是无解的
        if (i >= j && dp[i - j] != Integer.MAX_VALUE && dp[i - j] + 1 < dp[i]) {
          dp[i] = dp[i - j] + 1;
        }
      }
    }
    if (dp[amount] == Integer.MAX_VALUE) {
      return -1;
    }
    return dp[amount];
  }

  public static void main(String[] args) {
    System.out.println(coinChange(new int[] {1, 2, 5}, 11));
  }
}
