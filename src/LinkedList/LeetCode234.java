package LinkedList;

import utils.ListNode;

/**
 * @author Lord Camelot
 * @date 2024/5/3
 * @description LeetCode234 回文链表
 */
public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        ListNode h2 = middleNode(head);
        h2 = reverseLinkedList(h2);
        while (h2 != null) {
            if (head.val != h2.val) {
                return false;
            }
            head = head.next;
            h2 = h2.next;
        }
        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
