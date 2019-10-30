import java.util.LinkedList;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test112
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/30 22:46
 * @Version: 1.0
 */
public class Test112 {
    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
     * 这条路径上所有节点值相加等于目标和。
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        //递归
        if (root == null) {
            return false;
        }
        sum = sum - root.val;
        //判断是否为叶子节点
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        //迭代
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> integers = new LinkedList<Integer>();
        nodes.add(root);
        integers.add(sum-root.val);
        TreeNode node;
        int num;
        while (!nodes.isEmpty()) {
            node = nodes.pollLast();
            num = integers.pollLast();
            if (node.right == null && node.left == null && num == 0) {
                return true;
            }
            if (node.right != null) {
                nodes.add(node.right);
                integers.add(num-node.right.val);
            }
            if (node.left != null) {
                nodes.add(node.left);
                integers.add(num-node.left.val);
            }
        }
        return false;
    }
}
