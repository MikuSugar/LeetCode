package JavaCode.top_interview_questions_easy.linked_list;

public class five {
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
        public boolean isPalindrome(ListNode head) {
           ListNode p=head;
           ListNode s=head;

           //寻找后半段链表
           while (s.next!=null)
           {
               p=p.next;
               if(s.next==null)
               {
                   break;
               }
               s=s.next.next;
           }
           s=p;
           p=head;

           ListNode pre=null;

           //反转后半段链表
           while (s!=null)
           {
               ListNode temp=s.next;
               s.next=pre;
               pre=s;
               s=temp;
           }

           while (p!=null&&pre!=null)
           {
               if(p.val!=pre.val)
               {
                   return false;
               }
               p=p.next;
               pre=pre.next;
           }
           return true;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/45/
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
