package JavaCode.random_records.N1_100;

import JavaCode.linked_list.ListNode;

public class N82_remove_duplicates_from_sorted_list_ii {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)return head;
        if(head.val==head.next.val)
        {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }
        else
        {
            head.next=deleteDuplicates(head.next);
        }
        return head;
    }

}
/**
 *给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
