/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: StockProblem
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/12/22 22:20
 * @Version: 1.0
 */

/**
 * 选择：买入、卖出、无操作
 * 状态：天数，交易次数，持有状态
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 *               max(   选择 rest  ,           选择 sell      )
 * 解释：今天我没有持有股票，有两种可能：
 * 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
 * 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
 *
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 *               max(   选择 rest  ,           选择 buy         )
 * 解释：今天我持有着股票，有两种可能：
 * 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
 * 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
 *
 *
 * base case：
 * dp[-1][k][0] = dp[i][0][0] = 0
 * dp[-1][k][1] = dp[i][0][1] = -infinity
 *
 * 状态转移方程：
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 *
 */
public class StockProblem {

    /**
     * 最佳买卖股票时机含冷冻期
     * 分析：k为无穷大，有冷冻期
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
     * dp[i-2][0]：表明冷冻期
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = tmp;
        }
        return dp_i_0;
    }

    /**
     * 买卖股票的最佳时机 III
     * 分析：k=2
     *dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     *dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *
     * 直接把 k = 1 和 2 的情况手动列举出来
     * dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
     * dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
     * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     * dp[i][1][1] = max(dp[i-1][1][1], 0- prices[i])
     * 这样就是4个状态了
     * @param prices
     * @return
     */
    public int maxProfit4(int[] prices) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }
        int dp_i2_0 = 0;
        int dp_i2_1 = Integer.MIN_VALUE;
        int dp_i1_0 = 0;
        int dp_i1_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i2_0 = Math.max(dp_i2_0, dp_i2_1+prices[i]);
            dp_i2_1 = Math.max(dp_i2_1, dp_i1_0-prices[i]);
            dp_i1_0 = Math.max(dp_i1_0, dp_i1_1+prices[i]);
            dp_i1_1 = Math.max(dp_i1_1, -prices[i]);
        }
        return dp_i2_0;
    }

    /**
     * 当k为2-n时，需要对k进行穷举
     * @param prices
     * @return
     */
    public int maxProfit4_2(int[] prices) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }
        int k = 2;
        int[][][] dp = new int[n][k+1][2];
        for (int i = 0; i < n; i++) {
            for (;k > 0; k--) {
                if (i == 0) {
                    /* 处理 base case */
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n-1][2][0];
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n / 2) {
            return maxProfit(n/2, prices);
        }

        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (;k > 0; k--) {
                if (i == 0) {
                    /* 处理 base case */
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}
