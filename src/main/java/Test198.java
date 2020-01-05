/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test198
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/12/29 21:58
 * @Version: 1.0
 */

import java.util.Arrays;

/**
 * 打家劫舍
 *      如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 */
public class Test198 {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(cur, pre+num);
            pre = tmp;
        }
        return cur;
    }

    public int rob2(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] ints = Arrays.copyOfRange(nums, 0, n - 1);
        int[] ints1 = Arrays.copyOfRange(nums, 1, n);
        return Math.max(rob(ints), rob(ints1));
    }

    /**
     * 当前节点选择不偷: 当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
     * 当前节点选择偷: 当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 +
     *                                      右孩子选择不偷时能得到的钱 + 当前节点的钱数
     *
     * root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
     * root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
     *
     * @param root
     * @return
     */
    public int rob3(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }
}
