package JavaCode.top_interview_questions_hard.linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        for(ListNode node:lists)
        {
            if(node!=null)
            {
                queue.add(node);
            }
        }

        ListNode newRoot=queue.peek();
        ListNode q=queue.poll();
        if(q==null) return newRoot;
        if(q.next!=null) queue.add(q.next);
        while (!queue.isEmpty())
        {
            ListNode p=queue.poll();
            if(p.next!=null)queue.add(p.next);
            q.next=p;
            q=p;

        }
        return newRoot;
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/56/linked-list/134/
 * 合并K个元素的有序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
