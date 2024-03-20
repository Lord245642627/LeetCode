package Recursion;

import utils.ListNode;

/**
 * @author Lord Camelot
 * @date 2024/3/20
 * @description LeetCode24 两两交换链表中的节点
 */
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }
}
