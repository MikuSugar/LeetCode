package JavaCode.random_records;

import JavaCode.linked_list.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class N143_reorder_list {
    public void reorderList(ListNode head) {
        if(head==null) return;

        //寻找中点
        ListNode p=head;
        ListNode q=head;
        while (q.next!=null&&q.next.next!=null)
        {
            p=p.next;
            q=q.next.next;
        }
        ListNode mid=p.next;

        //将链表一分为二，反转第二条链表
        p.next=null;
        p=reverse(mid);

        //将两条链表合并
        q=head;
        while (q!=null&&p!=null)
        {
            ListNode temp_p=p.next;
            ListNode temp_q=q.next;
            q.next=p;
            p.next=temp_q;
            q=temp_q;
            p=temp_p;
        }

    }

    //反转链表
    private ListNode reverse(ListNode head)
    {
        ListNode p=head;
        ListNode q=head;
        ListNode s=null;
        while (p!=null)
        {
            p=p.next;
            q.next=s;
            s=q;
            q=p;
        }
        return s;
    }
}
/**
 * https://leetcode-cn.com/problems/reorder-list/
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
