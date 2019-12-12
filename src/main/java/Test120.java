import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test120
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/12/12 22:35
 * @Version: 1.0
 */

/**
 * 动态规划
 * 1、问题拆解，找出问题之间的关联
 * 2、状态定义
 * 3、递推方程推导
 * 4、编码
 */
public class Test120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        //用一维数组存储值
        int[] dp = new int[n];
        List<Integer> list = triangle.get(n - 1);
        for (int i = 0; i < n; i++) {
            dp[i] = list.get(i);
        }
        for (int j = n-2; j >= 0; j--) {
            List<Integer> list1 = triangle.get(j);
            for (int k = 0; k < list1.size(); k++) {
                dp[k] = list1.get(k) + Math.min(dp[k], dp[k+1]);
            }
        }
        return dp[0];
   }
}
