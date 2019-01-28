package JavaCode.linked_list.classic_problems;

import JavaCode.linked_list.ListNode;

public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        while (head!=null&&head.val==val)
        {
            head=head.next;
        }
        if(head==null||head.next==null)return head;

        ListNode p=head.next;
        ListNode q=head;

        while (p!=null)
        {
            if(p.val!=val)
            {
                q.next=p;
                q=q.next;
            }
            p=p.next;
        }
        q.next=null;
        return head;
    }
}
/**
 * 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
