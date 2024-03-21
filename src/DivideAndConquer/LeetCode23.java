package DivideAndConquer;

import utils.ListNode;

/**
 * @author Lord Camelot
 * @date 2024/3/20
 * @description LeetCode23 合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        ListNode list1 = mergeKLists(lists, start, mid);
        ListNode list2 = mergeKLists(lists, mid + 1, end);
        return mergeTwoLists(list1, list2);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        if (list1 != null) {
            return list1;
        } else {
            return list2;
        }
    }
}
