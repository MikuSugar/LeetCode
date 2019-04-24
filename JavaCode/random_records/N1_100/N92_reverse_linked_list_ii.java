package JavaCode.random_records.N1_100;

import JavaCode.linked_list.ListNode;

public class N92_reverse_linked_list_ii {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static void main(String[] args) {
        int[] t={1,2,3,4,5};
        ListNode head=new ListNode(t[0]);
        ListNode cur=head;
        for (int i=1;i<t.length;i++)
        {
            cur.next=new ListNode(t[i]);
            cur=cur.next;
        }
        int a=1;
        new N92_reverse_linked_list_ii().reverseBetween(head,1,5);
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre_head=new ListNode(0);
        pre_head.next=head;
        ListNode cur=pre_head;
        for (int i=1;i<m;i++)
        {
            cur=cur.next;
        }
        ListNode pre=cur;
        cur=cur.next;
        for (int i=m;i<n;i++)
        {
           ListNode temp=cur.next;
           cur.next=temp.next;
           temp.next=pre.next;
           pre.next=temp;
        }
        return pre_head.next;
    }
}
/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
