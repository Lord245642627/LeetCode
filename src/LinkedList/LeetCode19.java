package LinkedList;

import utils.ListNode;

/**
 * @author Lord Camelot
 * @date 2024/5/4
 * @description LeetCode19 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LeetCode19 {
    // 使用快慢指针法
    // 先将快指针走 n 次，这样当快指针指向最后时，慢指针就指向了倒数第 n 个指针
    // 当链表头也可能被删除的时候，就需要采用哨兵
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode left = dummy, right = head;
        while (--n != 0) {
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
