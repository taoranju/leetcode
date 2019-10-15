/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test05
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/15 23:27
 * @Version: 1.0
 */

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串
 */
public class Test05 {
    /**
     * 1、动态规划
     * 2、中心扩展法
     * 3、马拉车算法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        if(n < 1 || s == null) {
            return res;
        }
        boolean[][] p = new boolean[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                //2个字符以内直接判断是否相等即可 (j -i < 2)
                p[i][j] = (s.charAt(i) == s.charAt(j)) && ((j -i < 2) || p[i+1][j-1]);
                if(p[i][j] && j-i+1 > res.length()) {
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }
}
