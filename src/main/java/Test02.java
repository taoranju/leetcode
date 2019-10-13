/**
 * @ProjectName: leetcode01
 * @Package: PACKAGE_NAME
 * @ClassName: Test02
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/7 23:23
 * @Version: 1.0
 */
public class Test02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0;
        ListNode curr = new ListNode(0);
        ListNode node = curr;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            a = (x+y+a)/10;
            node.next = new ListNode((x+y+a)%10);
            node = node.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(a != 0) {
            node.next = new ListNode(a);
        }
        return curr.next;
    }
}
