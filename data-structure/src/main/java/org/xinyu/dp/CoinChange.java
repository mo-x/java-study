package org.xinyu.dp;

/**
 * 假设有 1 元，3 元，5 元的硬币若干（无限），现在需要凑出 11 元，问如何组合才能使硬币的数量最少？
 */
public class CoinChange {

    //硬币组合
    public static int[] coins = {1, 2, 5};

    /**
     * 最后一步:
     * dp[11] = dp[11-1]+1
     * dp[11] = dp[11-3]+1
     * dp[11] = dp[11-5]+1
     * <p>
     * <p>
     * dp[0] = 0
     * dp[1] = 1
     * dp[2] = 2
     * dp[3] = 2
     * dp[4] = 2
     * dp[5] = 1
     * dp[6] = 2
     * dp[7] = 1
     * <p>
     * dp[8]= dp[8-1]+1 = 2
     * dp[8]= dp[8-3]+1 = 2
     * dp[8]= dp[8-5]+1 = 3
     * <p>
     * dp[i]=dp[i-1]+1
     *
     * @param amount
     * @return
     */
    private static int coinChange(int amount) {
        if (amount == 0) {
            return 0;
        }
        //初始化数组 表示每个金额的最优解
        int[] dp = new int[amount + 1];
        //0元的最优解为0
        dp[0] = 0;
        //
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j : coins) {
                //1.首先计算的金额要大于输入的金额
                //2.dp[i-j]表示剩余的金额不能是无解的
                //3.dp[i-j]+1
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
        System.out.println(coinChange(11));

    }
}
