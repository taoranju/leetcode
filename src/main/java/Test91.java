/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test91
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/12/15 20:26
 * @Version: 1.0
 */
public class Test91 {
    /**
     * 1、递归
     * 2、动态规划
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        return getAns(s, 0);
    }

    private int getAns(String s, int start) {
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        int ans1 = getAns(s, start+1);
        int ans2 = 0;
        if (start < s.length()-1) {
            int a = (s.charAt(start) - '0')*10;
            int b = s.charAt(start+1) - '0';
            if (a+b <= 26) {
                ans2 = getAns(s, start+2);
            }
        }
        return ans1+ans2;
    }
}
