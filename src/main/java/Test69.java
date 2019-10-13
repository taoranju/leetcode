/**
 * @ProjectName: leetcode01
 * @Package: PACKAGE_NAME
 * @ClassName: Test69
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/9/30 23:25
 * @Version: 1.0
 */
public class Test69 {
    /**
     * 实现 int sqrt(int x) 函数。
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int res = 0;
        int i = 0;
        int j = x;
        while(i <= j) {
            res = (i + j)/2;
            if(res*res == x) {
                return res;
            } else if(res*res < x) {
                i = res + 1;
            } else {
                j = res - 1;
            }
        }
        if(res*res <= x) {
            return res;
        } else {
            return res-1;
        }
    }
}
