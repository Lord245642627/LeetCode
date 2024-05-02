package LinkedList;

import utils.ListNode;

/**
 * @author Lord Camelot
 * @date 2024/5/2
 * @description LeetCode2816 翻倍以链表形式表示的数字
 * 给你一个 非空 链表的头节点 head ，表示一个不含前导零的非负数整数。
 * 将链表 翻倍 后，返回头节点 head 。
 */
public class LeetCode2816 {
    public ListNode doubleIt(ListNode head) {
        return doubleIt2(head);
    }

    public ListNode doubleIt1(ListNode head) {
        head = reverseLinkList(head);
        return reverseLinkList(doubleLinkList(head));
    }

    public ListNode doubleIt2(ListNode head) {
        if (head.val > 4) {
            head = new ListNode(0, head);
        }
        for (ListNode cur = head; cur != null; cur = cur.next) {
            cur.val = cur.val * 2 % 10;
            if (cur.next != null && cur.next.val > 4) {
                cur.val++;
            }
        }
        return head;
    }

    private ListNode reverseLinkList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private ListNode doubleLinkList(ListNode head) {
        int add = 0;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head != null || add != 0) {
            int sum = add;
            if (head != null) {
                sum += head.val * 2;
                head = head.next;
            }
            add = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        return dummy.next;
    }
}
