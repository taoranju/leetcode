/**
 * @ProjectName: leetcode01
 * @Package: PACKAGE_NAME
 * @ClassName: Test237
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/2 23:23
 * @Version: 1.0
 */
public class Test237 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    /**
     * 删除当前节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
