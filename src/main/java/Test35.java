/**
 * @ProjectName: leetcode
 * @Package: cn.ustc
 * @ClassName: Test35
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/9/26 20:39
 * @Version: 1.0
 */

/**
 *给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class Test35 {
    public int searchInsert(int[] nums, int target) {
        //排序数组，用折半查找法
        int j = nums.length - 1;
        int i = 0;
        while(i <= j) {
            int tmp = (i+j)/2;
            if(nums[tmp] < target) {
                i = tmp + 1;
            } else if(nums[tmp] > target) {
                j = tmp - 1;
            } else {
                return tmp;
            }
        }
        return i;
    }

    public int searchInsert2(int[] nums, int target) {
        //直接查询
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
