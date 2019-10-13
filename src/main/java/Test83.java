import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode01
 * @Package: PACKAGE_NAME
 * @ClassName: Test83
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/9/30 23:57
 * @Version: 1.0
 */
public class Test83 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        ListNode res = head;
        ListNode pre = null;
        while (head != null) {
            if(map.containsKey(head.val)) {
                pre = pre.next.next;
                head = pre.next;
            } else {
                map.put(head.val,head.val);
                pre = head;
                head = head.next;
            }
        }
        return res;
    }
}
