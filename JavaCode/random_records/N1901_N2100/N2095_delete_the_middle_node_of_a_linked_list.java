package JavaCode.random_records.N1901_N2100;

import JavaCode.linked_list.ListNode;
import utils.CheckUtil;
import utils.Parse;

/**
 * @author mikusugar
 * @version 1.0, 2023/6/2 10:11
 * @description N2095_delete_the_middle_node_of_a_linked_list
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class N2095_delete_the_middle_node_of_a_linked_list {
    public static void main(String[] args) {
        final N2095_delete_the_middle_node_of_a_linked_list algo = new N2095_delete_the_middle_node_of_a_linked_list();
        CheckUtil.check("[1,3,4,1,2,6]", Parse.listNode2Str(algo.deleteMiddle(Parse.toListNodeForArrStr("[1,3,4,7,1,2,6]"))));
        CheckUtil.check("[1,2,4]", Parse.listNode2Str(algo.deleteMiddle(Parse.toListNodeForArrStr("[1,2,3,4]"))));
        CheckUtil.check("[2]", Parse.listNode2Str(algo.deleteMiddle(Parse.toListNodeForArrStr("[2,1]"))));
        CheckUtil.check("[]", Parse.listNode2Str(algo.deleteMiddle(Parse.toListNodeForArrStr("[2]"))));
    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode p1 = new ListNode(-1);
        p1.next = head;
        ListNode p2 = head;
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2.next != null) {
                p2 = p2.next;
            } else break;
        }
        if (p1.next == head) {
            return null;
        }
        p1.next = p1.next.next;
        return head;
    }
}
/*
给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。

长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。

对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
 

示例 1：



输入：head = [1,3,4,7,1,2,6]
输出：[1,3,4,1,2,6]
解释：
上图表示给出的链表。节点的下标分别标注在每个节点的下方。
由于 n = 7 ，值为 7 的节点 3 是中间节点，用红色标注。
返回结果为移除节点后的新链表。
示例 2：



输入：head = [1,2,3,4]
输出：[1,2,4]
解释：
上图表示给出的链表。
对于 n = 4 ，值为 3 的节点 2 是中间节点，用红色标注。
示例 3：



输入：head = [2,1]
输出：[2]
解释：
上图表示给出的链表。
对于 n = 2 ，值为 1 的节点 1 是中间节点，用红色标注。
值为 2 的节点 0 是移除节点 1 后剩下的唯一一个节点。
 

提示：

链表中节点的数目在范围 [1, 105] 内
1 <= Node.val <= 105

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
