package JavaCode.recursion_i.principle_of_recursion;

import JavaCode.linked_list.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode temp = head.next.next;
        head.next.next=head;
        ListNode next = head.next;
        head.next=swapPairs(temp);
        return next;
    }
}
/**
 * https://leetcode-cn.com/explore/orignial/card/recursion-i/256/principle-of-recursion/1201/
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
