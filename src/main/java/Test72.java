/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test72
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/12/22 20:28
 * @Version: 1.0
 */

/**
 * 解决两个字符串的动态规划问题，
 * 一般都是用两个指针 i,j 分别指向两个字符串的最后，然后一步步往前走，缩小问题的规模。
 *
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class Test72 {
    /**
     * dp[][]存储中间变量
     * dp[i][j-1]:插入操作
     * dp[i-1][j]:删除操作
     * dp[i-1][j-1]:替换操作
     * if s1[i]==s2[j]
     *      dp[i][j] = dp[i-1][j-1]
     * else
     *      dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //当至少有一个字符串为空时
        if (m*n == 0) {
            return m+n;
        }
        //初始化dp[][]
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n+1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
