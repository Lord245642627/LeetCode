package LinkedList;

import utils.ListNode;

/**
 * @author Lord Camelot
 * @date 2024/5/4
 * @description LeetCode82 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ，删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                // 在内部再加一层循环，将所有重复元素都删除
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
