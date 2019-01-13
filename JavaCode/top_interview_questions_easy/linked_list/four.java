package JavaCode.top_interview_questions_easy.linked_list;

public class four {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
           if(l1==null)
           {
               return l2;
           }
           if(l2==null)
           {
               return l1;
           }

           ListNode head=null;
           if(l1.val<l2.val)
           {
               head=l1;
               head.next=mergeTwoLists(l1.next,l2);
           }
           else
           {
               head=l2;
               head.next=mergeTwoLists(l2.next,l1);
           }
           return head;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/44/
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
