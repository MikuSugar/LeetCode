package JavaCode.random_records.N101_200;

import JavaCode.linked_list.ListNode;

/**
 * author:fangjie
 * time:2019/11/29
 */
public class N148_sort_list {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode p=head;
        ListNode q=head;
        ListNode t=null;
        while (q!=null&&q.next!=null)
        {
            t=p;
            p=p.next;
            q=q.next.next;
        }
        t.next=null;
        ListNode list1=sortList(head);
        ListNode list2=sortList(p);
        return merge(list1,list2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(0);
        ListNode cur=res;
        while (l1!=null&&l2!=null)
        {
            if(l1.val<l2.val)
            {
                cur.next=l1;
                cur=cur.next;
                l1=l1.next;
            }
            else
            {
                cur.next=l2;
                cur=cur.next;
                l2=l2.next;
            }
        }
        if(l1!=null)cur.next=l1;
        if(l2!=null)cur.next=l2;
        return res.next;
    }
}
/*
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
