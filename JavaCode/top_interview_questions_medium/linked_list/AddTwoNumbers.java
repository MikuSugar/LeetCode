package JavaCode.top_interview_questions_medium.linked_list;

public class AddTwoNumbers
{
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head=null;
            ListNode temp=null;
            int carry=0;
            while (l1!=null||l2!=null)
            {
                int a=0;
                int b=0;
                if(l1!=null)
                {
                    a=l1.val;
                    l1=l1.next;
                }
                if(l2!=null)
                {
                    b=l2.val;
                    l2=l2.next;
                }

                int x=a+b+carry;
                carry=x/10;
                x%=10;
                if(head==null)
                {
                    head=new ListNode(x);
                    temp=head;
                }
                else
                {
                    temp.next=new ListNode(x);
                    temp=temp.next;
                }
            }
            if(carry!=0)
            {
                temp.next=new ListNode(carry);
            }
            return head;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/82/
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
