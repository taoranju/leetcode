/**
 * @ProjectName: leetcode
 * @Package: cn.ustc
 * @ClassName: Test53
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/9/28 19:22
 * @Version: 1.0
 */
public class Test53 {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
     * 返回其最大和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        /**
         * 暴力破解，一个变量存储当前最大值，一个存储当前值
         */
        int sum = 0;
        int res = nums[0];
        for(int num : nums) {
            if(sum > 0) {
                sum = sum + num;
            } else {
                sum = num;
            }
            res = Math.max(res,sum);
        }
        return res;
    }
}
