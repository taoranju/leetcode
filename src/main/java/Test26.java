/**
 * @ProjectName: leetcode
 * @Package: cn.ustc
 * @ClassName: Test26
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/9/25 19:40
 * @Version: 1.0
 */
public class Test26 {
    public int removeDuplicates(int[] nums) {

        int len = nums.length;
        int k = 1;
        if(len < 2) {
            return len;
        }
        for(int i = 0; i < len-1; i++) {
                if(nums[i] == nums[i+1]) {

                } else {
                    nums[k] = nums[i+1];
                    k++;
                }
            }
        return k;
    }
}
