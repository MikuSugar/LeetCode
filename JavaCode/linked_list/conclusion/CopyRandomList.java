package JavaCode.linked_list.conclusion;


import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        Map<Integer,RandomListNode> map=new HashMap<>();
        RandomListNode new_head=new RandomListNode(head.label);
        map.put(head.label,new_head);
        RandomListNode p=head.next;
        RandomListNode q=new_head;
        while (p!=null)
        {
            q.next=new RandomListNode(p.label);
            map.put(p.label,q.next);
            q=q.next;
            p=p.next;
        }
        p=head;
        q=new_head;
        while (p!=null)
        {
            if(p.random!=null)
            {
                q.random=map.get(p.random.label);
            }
            p=p.next;
            q=q.next;
        }

        return new_head;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/linked-list/197/conclusion/766/
 * 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的深度拷贝。
 */
