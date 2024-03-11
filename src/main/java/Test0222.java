import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Test0222 {

    public static void main(String[] args) {
        Test0222 test0222 = new Test0222();
        String res = test0222.longestPalindrome("ccc");
        System.out.println(res);
    }

    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int len = 0;
        int index = 0;
        int end = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (j == i + 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2;
                } else {
                    // j > i + 1
                    if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] > 0) {
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }
                }
                if (dp[i][j] > len) {
                    len = dp[i][j];
                    index = i;
                    end = j;
                }
            }
        }
        return s.substring(index, end + 1);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();
        ListNode res = head;
        // 进位
        int pre = 0;
        int a = 0;
        int b = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int num = (a + b + pre) % 10;
            head.next = new ListNode(num);
            head = head.next;
            pre = (a + b + pre) / 10;
            a = 0;
            b = 0;
        }
        if (pre > 0) {
            head.next = new ListNode(pre);
        }
        return res.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode pre = new ListNode(0);
        ListNode node = pre;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                node.next = list2;
                break;
            }
            if (list2 == null) {
                node.next = list1;
                break;
            }
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    node.next = list1;
                    node = node.next;
                    list1 = list1.next;
                    node.next = null;
                } else {
                    node.next = list2;
                    node = node.next;
                    list2 = list2.next;
                    node.next = null;
                }
            }
        }
        return pre.next;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        Set<TreeNode> visited = new HashSet<TreeNode>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return res + 1;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res ++;
        }
        return 0;
    }

    List<Integer> list = new ArrayList<Integer>();

    /**
     * 前序遍布二叉树
     * 递归版本
     * @param root
     * @return
     */
    public List<Integer> preOrder1(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preOrder1(root.left);
            preOrder1(root.right);
        }
        return list;
    }

    /**
     * 前序遍布二叉树
     * 非递归版本-队列、栈
     * @param root
     * @return
     */
    public List<Integer> preOrder2(TreeNode root) {
         if (root == null) {
             return list;
         }
         Stack<TreeNode> stack = new Stack<TreeNode>();
         stack.push(root);
         while (! stack.isEmpty()) {
             TreeNode cur = stack.pop();
             list.add(cur.val);
             if (cur.right != null) {
                 stack.push(cur.right);
             }
             if (cur.left != null) {
                 stack.push(cur.left);
             }
         }
         return list;
    }


    /**
     * 中序遍布二叉树
     * @param root
     * @return
     */
    public List<Integer> inOrder1(TreeNode root) {
        if (root != null) {
            inOrder1(root.left);
            list.add(root.val);
            inOrder1(root.right);
        }
        return list;
    }

    /**
     * 中序遍布二叉树
     * 非递归版本-队列、栈
     * @param root
     * @return
     */
    public List<Integer> inOrder2(TreeNode root) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // 寻找最左节点
        TreeNode cur = root;
        while (cur != null || ! stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    /**
     * 后序遍布二叉树
     * @param root
     * @return
     */
    public List<Integer> postOrder1(TreeNode root) {
        if (root != null) {
            postOrder1(root.left);
            postOrder1(root.right);
            list.add(root.val);
        }
        return list;
    }

    /**
     * 后序遍布二叉树
     * 非递归版本-队列、栈
     * @param root
     * @return
     */
    public List<Integer> postOrder2(TreeNode root) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // 寻找最左节点
        TreeNode cur = root;
        // 记录上一个消费的节点
        TreeNode pre = null;
        while (cur != null || ! stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == pre) {
                TreeNode node = stack.pop();
                list.add(node.val);
                pre = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        return list;
    }

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            resList.add(list);
        }
        return resList;
    }

    /**
     * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        return 0;
    }

    /**
     * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称
     * 26进制
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        String[] strings = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "j", "K", "L", "M", "N", "O", "P", "Q",
        "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String res = "";
        while (columnNumber > 0) {
            // 避免0的出现
            int pre = (columnNumber-1) % 26 + 1;
            columnNumber = (columnNumber - pre) / 26;
            res = strings[pre-1] + res;
        }
        return res;
    }

    /**
     * 插入区间
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<int[]>();
        int index = 0;
        for (int[] ints : intervals) {
            if (ints[0] > newInterval[1]) {
                // newInterval 在区间的左侧
                res.add(ints);
            } else if (ints[1] < newInterval[0]) {
                res.add(ints);
                index++;
            } else {
                newInterval[0] = Math.min(newInterval[0], ints[0]);
                newInterval[1] = Math.max(newInterval[1], ints[1]);
            }
        }
        res.add(index, new int[]{newInterval[0], newInterval[1]});
        return res.toArray(new int[0][0]);
    }

    /**
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode pre = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (pre != cur) {
                pre.right = cur;
                pre.left = null;
                pre = cur;
            }
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node pre = null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (pre == null) {
                    pre = cur;
                } else {
                    pre.next = cur;
                    pre = cur;
                }
            }
            pre.next = null;
            pre = null;
        }
        return root;
    }


    public int[] divisibilityArray(String word, int m) {
        int[] res = new int[word.length()];
        long cur = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            cur = (cur * 10 + (ch - '0')) % m;
            if (cur == 0) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }


}
