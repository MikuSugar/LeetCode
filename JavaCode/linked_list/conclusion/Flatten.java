package JavaCode.linked_list.conclusion;

import java.util.Stack;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
public class Flatten {
    public Node flatten(Node head) {
        Stack<Node> stack=new Stack<>();
        Node p=head;
        while (p!=null)
        {
            if(p.child!=null)
            {
                if(p.next!=null)
                {
                    stack.push(p.next);
                }
                p.child.prev=p;
                p.next=p.child;
                p.child=null;
            }
            else if(p.next==null)
            {
                if(stack.isEmpty())
                {
                    break;
                }
                else
                {
                    p.next=stack.pop();
                    p.next.prev=p;
                }
            }
            p=p.next;

        }
        return head;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/linked-list/197/conclusion/764/
 * 扁平化多级双向链表
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 *
 *
 *
 * 示例:
 *
 * 输入:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 *
 * 输出:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 *
 *
 * 以上示例的说明:
 *
 * 给出以下多级双向链表:
 *
 *
 *
 *
 * 我们应该返回如下所示的扁平双向链表:
 */
