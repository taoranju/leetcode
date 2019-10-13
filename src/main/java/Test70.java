/**
 * @ProjectName: leetcode01
 * @Package: PACKAGE_NAME
 * @ClassName: Test70
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/9/29 23:07
 * @Version: 1.0
 */

/**
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * f(1) = 1 ; f(2) = 2 ;n>=3 f(n) = f(n-1) + f(n-2);
 * 只有两种类型出行方案，一种第一次跳1步，第二种第一次跳2步
 */
public class Test70 {
    public int climbStairs(int n) {
//        //用递归，当n = 45 超时
//        if(n < 3 || n > 45) {
//            return n;
//        } else {
//            return climbStairs(n-1) + climbStairs(n-2);
//        }
        int a = 1;
        int b = 2;
        if(n < 3) {
            return n;
        } else {
            for(int i = 3;i <= n;i++) {
                int tmp = a + b;
                a = b;
                b = tmp;
            }
            return b;
        }
    }
}
