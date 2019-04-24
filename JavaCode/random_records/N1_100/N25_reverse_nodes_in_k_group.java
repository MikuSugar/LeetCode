package JavaCode.random_records.N1_100;

import JavaCode.linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class N25_reverse_nodes_in_k_group {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)return null;
        ListNode cur=head;
        List<ListNode> list=new ArrayList<>(k);
        while (cur!=null)
        {
            list.add(cur);
            if(list.size()>=k)break;
            cur=cur.next;
        }
        if(list.size()<k)return head;
        list.get(0).next=reverseKGroup(list.get(list.size()-1).next,k);
        for (int i=list.size()-1;i>=1;i--)
        {
            list.get(i).next=list.get(i-1);
        }
        return list.get(list.size()-1);
    }
}
/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
