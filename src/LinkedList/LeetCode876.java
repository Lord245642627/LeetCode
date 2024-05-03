package LinkedList;

import utils.ListNode;

/**
 * @author Lord Camelot
 * @date 2024/5/3
 * @description LeetCode876 链表的中间结点
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class LeetCode876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
