/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test64
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/12/15 19:04
 * @Version: 1.0
 */
public class Test64 {
    /**
     * 直接遍历 grid[i][j]grid[i][j] 修改即可
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //考虑边界情况
        for (int i = 0; i < m; i++) {
            for (int j = 0; j< n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                } else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[m-1][n-1];
    }
}
