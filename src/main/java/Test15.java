/**
 * @ProjectName: leetcode01
 * @Package: PACKAGE_NAME
 * @ClassName: Test15
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/13 22:47
 * @Version: 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 *
 */
public class Test15 {
    /**
     * 先对数组排序
     * 选取一个C位，与另外两个数相加，注意去重
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(nums == null || len < 3) {
            return lists;
        }
        Arrays.sort(nums);
        for(int i = 0; i < len - 1; i++) {
            if(nums[i] > 0) {
                break;
            }
            //去重
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = len -1;
            while (left < right) {
                //sum为3数之和
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    left++;
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    right--;
                } else if(sum > 0){
                    right--;
                } else {
                    left++;
                }
            }

        }
        return lists;
    }
}
