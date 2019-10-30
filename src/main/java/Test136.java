/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test136
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/24 23:27
 * @Version: 1.0
 */

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * 出现一次的数字
 */
public class Test136 {
    /**
     * 1,哈希表
     * 2、数学
     * 3、位操作
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer i : nums) {
            if (map.containsKey(i)) {
                map.remove(i);
            } else {
                map.put(i, 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        //此处哈希表中只有一个目标值
        return 1;
    }

}
