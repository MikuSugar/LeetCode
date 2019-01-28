package JavaCode.linked_list.doubly_linked_list;

public class MyDoublyLinkedList {

    /**
     * ["MyLinkedList","addAtHead","addAtIndex","get","get","get"]
     * [[],[1],[1,2],[1],[0],[2]]
     * ["MyLinkedList","get","addAtIndex","get","get","addAtIndex","get","get"]
     * [[],[0],[1,2],[0],[1],[0,1],[0],[1]]
     * ["MyLinkedList","addAtHead","addAtIndex","addAtIndex","addAtTail","addAtHead","addAtIndex","addAtIndex","addAtIndex","addAtTail","addAtTail","deleteAtIndex"]
     * [[],[0],[1,9],[1,5],[7],[1],[5,8],[5,2],[3,0],[1],[0],[6]]
     *
     * @param args
     */
    public static void main(String[] args) {
        MyDoublyLinkedList list=new MyDoublyLinkedList();
        list.addAtHead(0);
        list.addAtIndex(1,9);
        list.addAtIndex(1,5);
        list.addAtTail(7);
        list.addAtHead(1);
        list.addAtIndex(5,8);
        list.addAtIndex(3,0);
        list.deleteAtIndex(0);
        list.deleteAtIndex(list.size-1);
        list.deleteAtIndex(2);
        list.addAtTail(1);
    }

    private class Date{
        int val;
        Date next;
        Date prev;
        public Date(int val)
        {
            this.val=val;
            next=null;
            prev=null;
        }
    }

    private int size;
    private Date head;
    private Date tail;

    /** Initialize your data structure here. */
    public MyDoublyLinkedList() {
        this.size=0;
        this.head=null;
        this.tail=null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0||index>=size) return -1;
        Date p=head;
        for(int i=0;i<index;i++)
        {
            p=p.next;
        }
        return p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(head==null)
        {
            head=new Date(val);
            tail=head;
        }
        else
        {
            Date date=new Date(val);
            date.next=head;
            head.prev=date;
            head=date;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head==null)
        {
            addAtHead(val);
        }
        else
        {
            Date date=new Date(val);
            tail.next=date;
            date.prev=tail;
            tail=date;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index<0||index>size) return;
        else
        {
            Date date=new Date(val);
            if(index==0)
            {
                if(size==0)
                {
                    addAtHead(val);
                    return;
                }
                else
                {
                    date.next = head;
                    head.prev = date;
                    head = date;
                }
            }
            else if(index==size)
            {
                tail.next=date;
                date.prev=tail;
                tail=date;

            }
            else
            {
                Date p=head;
                for(int i=0;i<index;i++)
                {
                    p=p.next;
                }
                date.next=p;
                date.prev=p.prev;
                p.prev.next=date;
                p.prev=date;
            }
            size++;
        }


    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0||index>=size) return;
        else
        {
            if(index==0)
            {
                head=head.next;
                head.prev=null;
            }
            else if(index==size-1)
            {
                tail=tail.prev;
                tail.next=null;
            }
            else
            {
                Date p=head;
                for(int i=0;i<index;i++)
                {
                    p=p.next;
                }
                p.prev.next=p.next;
                p.next.prev=p.prev;
            }
            size--;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/linked-list/196/doubly-linked-list/759/
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 *
 * 示例：
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 *
 * 提示：
 *
 * 所有值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 */
