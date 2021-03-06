package JavaCode.contest.weekly.n0_200.n167;

import JavaCode.linked_list.ListNode;

import java.util.Stack;

/**
 * author:fangjie
 * time:2019/12/15
 */
public class N1 {
    public int getDecimalValue(ListNode head) {
        if(head==null)return 0;
        Stack<Integer> stack=new Stack<>();
        while (head!=null)
        {
            stack.add(head.val);
            head=head.next;
        }
        int res=0,cnt=0;
        while (!stack.isEmpty())
        {
            res+=stack.pop()*Math.pow(2,cnt++);
        }
        return res;
    }
}
/*
给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。

请你返回该链表所表示数字的 十进制值 。



示例 1：



输入：head = [1,0,1]
输出：5
解释：二进制数 (101) 转化为十进制数 (5)
示例 2：

输入：head = [0]
输出：0
示例 3：

输入：head = [1]
输出：1
示例 4：

输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
输出：18880
示例 5：

输入：head = [0,0]
输出：0


提示：

链表不为空。
链表的结点总数不超过 30。
每个结点的值不是 0 就是 1。
 */
