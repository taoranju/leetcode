/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test16
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/17 22:47
 * @Version: 1.0
 */

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
 */
public class Test16 {

    public int threeSumClosest(int[] nums, int target) {
        //排序
        Arrays.sort(nums);
        int len = nums.length;
        int res = 100000;
        int flag = 0;
        for (int i = 0; i < len-1; i++) {
            int j = i+1;
            int k = len - 1;
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            while (j < k) {
                int tmp = nums[i] + nums[j] + nums[k];
                flag = target - tmp;
                if (flag == 0) {
                    res = tmp;
                    return res;
                } else if (flag > 0) {
                    if (Math.abs(target-res) > flag) {
                        res = tmp;
                    }
                    while (j < k && nums[j] == nums[j+1]) {
                        j++;
                    }
                    j++;
                } else {
                    if (Math.abs(target-res) > -flag) {
                        res = tmp;
                    }
                    while (j < k && nums[k]==nums[k-1]) {
                        k--;
                    }
                    k--;
                }
            }
        }
        return res;
    }
}
