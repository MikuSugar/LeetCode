package JavaCode.random_records.N1_100;

import JavaCode.linked_list.ListNode;

public class N86_partition_list {
    public ListNode partition(ListNode head, int x) {
        ListNode p=new ListNode(0);
        ListNode q=new ListNode(0);
        ListNode head_p=p;
        ListNode head_q=q;
        while (head!=null)
        {
            if(head.val<x)
            {
                p.next=head;
                p=p.next;
            }
            else
            {
                q.next=head;
                q=q.next;
            }
            head=head.next;
        }
        p.next=head_q.next;
        q.next=null;
        return head_p.next;
    }
}
/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
