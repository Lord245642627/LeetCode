package LinkedList;

import utils.ListNode;

/**
 * @author Lord Camelot
 * @date 2024/5/2
 * @description LeetCode24 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        return swapPairsByRecursion(head);
    }

    private ListNode swapPairsByIteration(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy, cur = head;
        while (cur != null && cur.next != null) {
            ListNode temp = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            cur.next = temp;
            pre = cur;
            cur = temp;
        }
        return dummy.next;
    }

    private ListNode swapPairsByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }
}
