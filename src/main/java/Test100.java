import java.util.Stack;

/**
 * @ProjectName: leetcode01
 * @Package: PACKAGE_NAME
 * @ClassName: Test100
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/2 23:39
 * @Version: 1.0
 */
public class Test100 {
    /**
     * 遍历
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null) {
            return false;
        }
        if(q == null) {
            return  false;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(p);
        stack2.push(q);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if(node1 == null && node2 == null) {
                continue;
            }
            if(node1 == null) {
                return false;
            }
            if(node2 == null) {
                return false;
            }
            if(node1.val != node2.val) {
                return false;
            } else {
                stack1.push(node1.right);
                stack2.push(node2.right);
                stack1.push(node1.left);
                stack2.push(node2.left);
            }
        }
        return true;
    }

    /**
     * 递归
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null) {
            return false;
        }
        if(q == null) {
            return  false;
        }
        if(p.val == q.val) {
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        } else {
            return false;
        }
    }
}
