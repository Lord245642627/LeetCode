package LinkedList;

import utils.ListNode;

/**
 * @author Lord Camelot
 * @date 2024/5/2
 * @description LeetCode445 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 */
public class LeetCode445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseLinkedList(l1);
        l2 = reverseLinkedList(l2);
        return reverseLinkedList(addTwoLinkedList(l1, l2));
    }

    private ListNode reverseLinkedList(ListNode l) {
        ListNode pre = null, cur = l;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private ListNode addTwoLinkedList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        int a = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + a;
            a = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + a;
            a = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + a;
            a = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l2 = l2.next;
        }
        if (a != 0) {
            cur.next = new ListNode(a);
        }
        return head.next;
    }
}
