/**
 * @ProjectName: leetcode
 * @Package: cn.ustc
 * @ClassName: Test21
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/9/25 19:32
 * @Version: 1.0
 */

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *  * Definition for singly-linked list.
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode(int x) { val = x; }
 *  * }
 */

public class Test21 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 将链表l2往链表l1插入
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode pre = null;
        ListNode res = l1;
        while(l1 != null && l2 != null) {
            if(l2.val < l1.val) {
                ListNode newNode = new ListNode(l2.val);
                if(pre == null) {
                    newNode.next = l1;
                    res = newNode;
                } else {
                    newNode.next = l1;
                    pre.next = newNode;
                }
                pre = newNode;
                l2 = l2.next;
            } else {
                pre = l1;
                l1 = l1.next;
            }
        }
        if(l2 != null) {
            pre.next = l2;
        }
        return res;
    }
}
