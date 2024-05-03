package LinkedList;

import utils.ListNode;

/**
 * @author Lord Camelot
 * @date 2024/5/3
 * @description LeetCode143 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class LeetCode143 {
    // 该题可以分为 3 个步骤
    // 1. 找到中间位置的节点
    // 2. 反转后半部分链表
    // 3. 进行链表插入
    public void reorderList(ListNode head) {
        ListNode h1 = head, h2 = middleNode(head);
        h2 = reverseLinkedList(h2);
        // 奇数情况下，head2 多一个 node，但是这个 node 一开始就是被连在 head1 的尾部的，所以没问题，不需要处理。
        // 偶数情况下，head1.next = head2依旧成立，而 head2.next 在反转的时候就变为 null 了，所以也不需要处理了。
        while (h2.next != null) {
            ListNode temp1 = h1.next;
            ListNode temp2 = h2.next;
            h1.next = h2;
            h2.next = temp1;
            h1 = temp1;
            h2 = temp2;
        }
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
