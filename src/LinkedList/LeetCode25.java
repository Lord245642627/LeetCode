package LinkedList;

import utils.ListNode;

/**
 * @author Lord Camelot
 * @date 2024/5/2
 * @description LeetCode25 K 个一组翻转链表
 */
public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode n = dummy;
        int len = 0;
        while (n.next != null) {
            len++;
            n = n.next;
        }
        ListNode pre = dummy, cur = dummy.next;
        ListNode p = dummy;
        while (len >= k) {
            for (int i = 0; i < k; i++) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            ListNode temp = p.next;
            p.next.next = cur;
            p.next = pre;
            p = temp;
            len -= k;
        }
        return dummy.next;
    }
}
