/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test62
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/11/24 21:05
 * @Version: 1.0
 */

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
 * 问总共有多少条不同的路径？
 */
public class Test62 {

    /**
     * 1 排列组合，向下和向右的步数是固定的
     * 2 动态规划 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePaths2(int m, int n) {
        /**
         * 一维数组实现
         * 初始化数组值为1
         * 根据行数进行迭代
         * 每个数组值为上一轮当前值加当前轮上一个数组值
         */
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[]dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
}
