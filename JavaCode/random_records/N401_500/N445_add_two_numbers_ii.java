package JavaCode.random_records.N401_500;

import JavaCode.linked_list.ListNode;

public class N445_add_two_numbers_ii {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1=getLen(l1);
        int len2=getLen(l2);

        if(len1>len2)l2=addPre(l2,len1-len2);
        else if(len1<len2)l1=addPre(l1,len2-len1);

        ListNode res=slove(l1,l2);
        if(res.val<10)return res;
        ListNode ans=new ListNode(res.val/10);
        res.val%=10;
        ans.next=res;
        return ans;
    }

    private ListNode addPre(ListNode node, int k) {
        ListNode res=new ListNode(0);
        ListNode p=res;
        while (k-->1)
        {
            p.next=new ListNode(0);
            p=p.next;
        }
        p.next=node;
        return res;
    }

    private int getLen(ListNode node) {
        if(node==null)return 0;
        return getLen(node.next)+1;
    }

    private ListNode slove(ListNode l1, ListNode l2) {
        if(l1==null)return null;
        int res=0;
        ListNode next=slove(l1.next,l2.next);
        res+=l1.val+l2.val;
        if(next!=null)
        {
            res+=next.val/10;
            next.val%=10;
        }
        ListNode ans=new ListNode(res);
        ans.next=next;
        return ans;
    }

}
/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *  
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
