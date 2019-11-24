/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test63
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/11/24 22:02
 * @Version: 1.0
 */
public class Test63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //行和列
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //初始化第一行和第一列
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1)?1:0;
        }
        for (int j = 1; j < n; j++) {
            obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 && obstacleGrid[0][j-1] == 1)?1:0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
