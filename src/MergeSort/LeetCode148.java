package MergeSort;

import utils.ListNode;

/**
 * @author Lord Camelot
 * @date 2024/3/21
 * @description LeetCode148 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    // 分治思想，当问题拆分的足够小，可以直接解决
    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        return recursion(sortList(head, slow), sortList(slow, tail));
    }

    private ListNode recursion(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                list1.next = recursion(list1.next, list2);
                return list1;
            } else {
                list2.next = recursion(list1, list2.next);
                return list2;
            }
        }
        if (list1 != null) {
            return list1;
        }
        return list2;
    }
}
