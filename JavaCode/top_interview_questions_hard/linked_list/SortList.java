package JavaCode.top_interview_questions_hard.linked_list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        return head==null?null:mergeSort(head);
    }

    //归并排序
    private ListNode mergeSort(ListNode head)
    {
        if(head.next==null) return head;

        ListNode p=head;
        ListNode q=head;
        ListNode pre=null;
        while (q!=null&&q.next!=null)
        {
            pre=p;
            p=p.next;
            q=q.next.next;
        }
        pre.next=null;
        ListNode left=mergeSort(head);
        ListNode right=mergeSort(p);
        return merge(left,right);
    }

    //合并两个有序链表
    private ListNode merge(ListNode left,ListNode right)
    {
        ListNode help=new ListNode(0);
        ListNode cur=help;
        while (left!=null&&right!=null)
        {
            if(left.val<right.val)
            {
                cur.next=left;
                cur=cur.next;
                left=left.next;
            }
            else
            {
                cur.next=right;
                cur=cur.next;
                right=right.next;
            }
        }
        if(left!=null)
        {
            cur.next=left;
        }
        if(right!=null)
        {
            cur.next=right;
        }
        return help.next;
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/56/linked-list/135/
 * 链表排序
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
