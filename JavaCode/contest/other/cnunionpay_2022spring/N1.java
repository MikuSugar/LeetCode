package JavaCode.contest.other.cnunionpay_2022spring;

import JavaCode.linked_list.ListNode;

import java.util.List;

/**
 * @author mikusugar
 */
public class N1 {
    public boolean isPalindrome(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode root = pre;
        pre.next = head;
        ListNode p = head;
        while (p != null) {
            pre.next = p.next;
            if (help(root.next)) return true;
            pre.next = p;
            pre=p;
            p = p.next;
        }
        return false;
    }

    public boolean help(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
/*
给定一个链表的头结点 head，判断链表删除一个节点后是否可以成为「回文链表」。
若可以，则返回 true；否则返回 false

注意：

输入用例均保证链表长度 大于等于 3
示例 1：

输入：head = [1,2,2,3,1]

输出：true

解释：如下图所示，蓝色结点为删除的结点
删除该节点后，链表为「回文链表」 [1,2,2,1]，返回 true
image.png

示例 2：

输入：head = [5,1,8,8,1,5]

输出：true

解释： 删除节点值为 8 的节点

示例 3：

输入：head = [1,2,3,4]

输出：false

提示：

链表中节点数目在范围 [3, 10^5]
0 <= Node.val <= 10
 */
