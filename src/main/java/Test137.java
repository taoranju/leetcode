import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test137
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/30 22:17
 * @Version: 1.0
 */
public class Test137 {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        /**
         * 会有溢出
         */
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            num1 = num1 + nums[i];
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], nums[i]);
                num2 = num2 + nums[i];
            }
        }
        return (num2*3 - num1)/2;
    }
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            if (map.containsKey(num)) {
                map.put(num, 3);
            } else {
                map.put(num, 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 1;
    }
}
