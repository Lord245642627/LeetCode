package Recursion;

import utils.ListNode;

/**
 * @author Lord Camelot
 * @date 2024/3/20
 * @description LeetCode21 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return recursion(list1, list2);
//        return iteration(list1, list2);
    }

    // 递归法
    private ListNode recursion(ListNode list1, ListNode list2) {

    }

    // 迭代法
    private ListNode iteration(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), tail = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }
        return head.next;
    }
}
