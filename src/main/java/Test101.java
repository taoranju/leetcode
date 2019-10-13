import java.util.Stack;

/**
 * @ProjectName: leetcode01
 * @Package: PACKAGE_NAME
 * @ClassName: Test101
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/4 11:59
 * @Version: 1.0
 */
public class Test101 {
    /**
     * 递归
     * 镜像对比
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }


    public boolean isMirror(TreeNode p,TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return p.val==q.val && isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if(root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            TreeNode q = stack.pop();
            if(p == null && q == null) {
                continue;
            }
            if(p == null || q == null) {
                return false;
            }
            if(p.val != q.val) {
                return false;
            } else {
                stack.push(p.right);
                stack.push(q.left);
                stack.push(p.left);
                stack.push(q.right);

            }
        }
        return true;
    }
}
