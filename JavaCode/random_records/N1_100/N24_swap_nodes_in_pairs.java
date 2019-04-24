package JavaCode.random_records.N1_100;

import JavaCode.linked_list.ListNode;

public class N24_swap_nodes_in_pairs {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode next = head.next;
        head.next=swapPairs(next.next);
        next.next=head;
        return next;
    }
}
/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
