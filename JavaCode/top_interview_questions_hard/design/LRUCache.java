package JavaCode.top_interview_questions_hard.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


    //简单的双➡️链表
    private class Node
    {
        Node pre;
        Node next;
        int value;
        int key;
        public Node(int key,int value)
        {
            this.value=value;
            this.key=key;
        }
    }

    private int size;//缓存大小
    private int count;//当前的大小
    private Map<Integer,Node> map;
    private Node head;//链表头，最近最多使用
    private Node tail;//链表尾，最近最少使用

    public LRUCache(int capacity) {
        this.size=capacity;
        count=0;
        map=new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            put(key,node.value);
            return node.value;
        }
        else
        {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            if(node==head||count==1)
            {
                node.value=value;
            }
            else if(node==tail)
            {
                tail = node.pre;
                tail.next = null;
                head.pre = node;
                node.pre = null;
                node.next = head;
                head = node;
                node.value=value;
            }
            else
            {
                node.pre.next=node.next;
                node.next.pre=node.pre;
                head.pre=node;
                node.pre=null;
                node.next=head;
                head=node;
                node.value=value;
            }
        }
        else
        {
            if(head==null)
            {
                head=new Node(key,value);
                map.put(key,head);
                tail=head;
            }
            else
            {
                Node node=new Node(key,value);
                node.next=head;
                head.pre=node;
                head=node;
                map.put(key,node);
            }
            count++;
            if(count>size)
            {
                Node temp=tail;
                tail=temp.pre;
                tail.next=null;
                map.remove(temp.key);
                count--;
            }
        }
    }


}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/61/design/160/
 * LRU 缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2（缓存容量）);
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // 返回  1
        *cache.put(3,3);    // 该操作会使得密钥 2 作废
        *cache.get(2);       // 返回 -1 (未找到)
        *cache.put(4,4);    // 该操作会使得密钥 1 作废
        *cache.get(1);       // 返回 -1 (未找到)
        *cache.get(3);       // 返回  3
        *cache.get(4);       // 返回  4
 */
