/**
 * @ProjectName: leetcode01
 * @Package: PACKAGE_NAME
 * @ClassName: Test104
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/4 14:19
 * @Version: 1.0
 */
public class Test104 {
    /**
     * 二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }
}
