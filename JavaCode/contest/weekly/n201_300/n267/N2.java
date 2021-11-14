package JavaCode.contest.weekly.n201_300.n267;

import JavaCode.linked_list.ListNode;
import utils.Parse;

/**
 * @author mikusugar
 */
public class N2 {
    public static void main(String[] args) {
        final ListNode head = Parse.parserToListNode("5->2->6->3->9->1->7->3->8->4");
        System.out.println(new N2().reverseEvenLengthGroups(head));
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        int k = 2;
        ListNode p = head;
        while (p != null) {
            if (p.next == null) {
                return head;
            }
            int[] arr = new int[k];
            ListNode temp = p.next;
            int last = -1;
            for (int i = 0; i < k; i++) {
                if (temp == null) {
                    break;
                }
                last = i;
                arr[i] = temp.val;
                temp = temp.next;
            }
            if ((last + 1) % 2 == 0) {
                for (int i = last; i >= 0; i--) {
                    p.next = new ListNode(arr[i]);
                    p = p.next;
                }
            } else {
                for (int i = 0; i <= last; i++) {
                    p.next = new ListNode(arr[i]);
                    p = p.next;
                }
            }
            p.next = temp;
            k++;
        }
        return head;
    }


}
/*
给你一个链表的头节点 head 。

链表中的节点 按顺序 划分成若干 非空 组，这些非空组的长度构成一个自然数序列（1, 2, 3, 4, ...）。一个组的 长度 就是组中分配到的节点数目。换句话说：

节点 1 分配给第一组
节点 2 和 3 分配给第二组
节点 4、5 和 6 分配给第三组，以此类推
注意，最后一组的长度可能小于或者等于 1 + 倒数第二组的长度 。

反转 每个 偶数 长度组中的节点，并返回修改后链表的头节点 head 。



示例 1：



输入：head = [5,2,6,3,9,1,7,3,8,4]
输出：[5,6,2,3,9,1,4,8,3,7]
解释：
- 第一组长度为 1 ，奇数，没有发生反转。
- 第二组长度为 2 ，偶数，节点反转。
- 第三组长度为 3 ，奇数，没有发生反转。
- 最后一组长度为 4 ，偶数，节点反转。
示例 2：



输入：head = [1,1,0,6]
输出：[1,0,1,6]
解释：
- 第一组长度为 1 ，没有发生反转。
- 第二组长度为 2 ，节点反转。
- 最后一组长度为 1 ，没有发生反转。
示例 3：



输入：head = [2,1]
输出：[2,1]
解释：
- 第一组长度为 1 ，没有发生反转。
- 最后一组长度为 1 ，没有发生反转。
示例 4：

输入：head = [8]
输出：[8]
解释：只有一个长度为 1 的组，没有发生反转。


提示：

链表中节点数目范围是 [1, 105]
0 <= Node.val <= 105
 */
