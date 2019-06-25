package JavaCode.recursion_i.recurrence_relation;

import JavaCode.linked_list.ListNode;

import java.util.List;

public class ReverseList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode temp = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return temp;
    }
}
/**
 *反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
