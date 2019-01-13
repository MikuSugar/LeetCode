package JavaCode.top_interview_questions_easy.linked_list;


public class two {
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int length=0;
            ListNode node=head;
            while (node!=null)
            {
                length++;
                node=node.next;
            }

            if(n==length)
            {
                if(head.next==null)
                {
                    head=null;
                }
                else
                {
                    head.val = head.next.val;
                    head.next = head.next.next;
                }
            }
            else
            {
                node=head;
                for(int i=0;i<length-n-1;i++)
                {
                    node=node.next;
                }
                node.next=node.next.next;
            }
            return head;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/42/
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */
