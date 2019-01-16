package JavaCode.top_interview_questions_medium.linked_list;

public class OddEvenList
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
        public ListNode oddEvenList(ListNode head) {

            if(head==null||head.next==null||head.next.next==null)
            {
                return head;
            }


            /**
             * 分别迭代出奇数链表和偶数链表
             * 最后奇数链表尾接上偶数链表
             */
            ListNode p1=head;//奇数节点指针
            ListNode ohead=head.next;//第一个偶数节点
            ListNode p2=head.next;//偶数节点指针
            while (p2!=null&&p2.next!=null)
            {
                p1.next=p2.next;
                p1=p1.next;
                p2.next=p1.next;
                p2=p2.next;
            }
            p1.next=ohead;
            return head;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/83/
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
