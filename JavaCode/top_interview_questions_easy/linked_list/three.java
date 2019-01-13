package JavaCode.top_interview_questions_easy.linked_list;

public class three {
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
        public ListNode reverseList(ListNode head) {
            if(head==null)
            {
                return head;
            }
            ListNode node=head.next;
            ListNode tempnode=head;
            head.next=null;
            while (node!=null)
            {
                ListNode temp2=node.next;
                node.next=tempnode;
                tempnode=node;
                node=temp2;
            }
            return tempnode;
        }
    }
}
/**
 *https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/43/
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
