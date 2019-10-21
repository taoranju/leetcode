import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test19
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/21 23:23
 * @Version: 1.0
 */
public class Test19 {
    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
     * 1、两次遍历
     * 2、双指针法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        //添加一个空节点，处理特殊情况
        ListNode h = new ListNode(0);
        h.next = head;
        int num = 0;
        ListNode node = head;
        while (node != null) {
            num++;
            node = node.next;
        }
        node = h;
        num= num - n;
        while (num > 0) {
            num--;
            node = node.next;
        }
        node.next = node.next.next;
        return h.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        //第一个节点比第二个节点早走n-1步，当p.next == null ，q为目标节点
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode p, q;
        p = dum;
        q = dum;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return dum.next;
    }
}
