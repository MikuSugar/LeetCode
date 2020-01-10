package JavaCode.random_records.N1201_1300;

/**
 * author:fangjie
 * time:2019/11/29
 */
public class N1206_design_skiplist {
    class Skiplist {
        private Node head;
        public Skiplist() {
           head=new Node(-1);
        }

        public boolean search(int target) {
            Node cur=head;
            while (cur!=null)
            {
                while (cur.right!=null&&cur.right.val<=target)cur=cur.right;
                if(cur.val==target)return true;
                cur=cur.down;
            }
            return false;
        }


        private Node searchPre(int target)
        {
            Node cur=head;
            Node pre=null;
            while (cur!=null)
            {
                while (cur.right!=null&&cur.right.val<=target)cur=cur.right;
                pre=cur;
                cur=cur.down;
            }
            return pre;
        }
        public void add(int num) {
            Node cur=searchPre(num);
            Node node=new Node(num);
            insert(cur, node);
            while (tossCoin())
            {
                cur=getUpCur(cur);
                Node temp=new Node(num);
                insert(cur,temp);
                node.up=temp;
                temp.down=node;
                node=temp;
            }
        }

        private void insert(Node cur, Node node) {
            node.left=cur;
            node.right=cur.right;
            if(cur.right!=null)cur.right.left=node;
            cur.right=node;
        }

        private Node getUpCur(Node cur) {
            if(cur.up!=null)return cur.up;
            if(cur.val==-1)
            {
                Node node=new Node(-1);
                node.down=cur;
                cur.up=node;
                return head=node;
            }
            return getUpCur(cur.left);
        }

        private boolean tossCoin() {
            return Math.random()<=0.5;
        }

        public boolean erase(int num) {
            Node cur=searchPre(num);
            while (cur.right!=null&&cur.right.val<=num)cur=cur.right;
            if(cur.val!=num)return false;
            delete(cur);
            return true;
        }

        private void delete(Node cur) {
            if(cur==null)return;
            cur.left.right=cur.right;
            if(cur.right!=null)cur.right.left=cur.left;
            delete(cur.up);
        }

        class Node{
            Node down,left,right,up;
            int val;
            public Node(int val)
            {
                this.val=val;
            }
        }
    }
}
/*
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
/*
不使用任何库函数，设计一个跳表。

跳表是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。

例如，一个跳表包含 [30, 40, 50, 60, 70, 90]，然后增加 80、45 到跳表中，以下图的方式操作：


Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons

跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。

在本题中，你的设计应该要包含这些函数：

bool search(int target) : 返回target是否存在于跳表中。
void add(int num): 插入一个元素到跳表。
bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
了解更多 : https://en.wikipedia.org/wiki/Skip_list

注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。

样例:

Skiplist skiplist = new Skiplist();

skiplist.add(1);
skiplist.add(2);
skiplist.add(3);
skiplist.search(0);   // 返回 false
skiplist.add(4);
skiplist.search(1);   // 返回 true
skiplist.erase(0);    // 返回 false，0 不在跳表中
skiplist.erase(1);    // 返回 true
skiplist.search(1);   // 返回 false，1 已被擦除
约束条件:

0 <= num, target <= 20000
最多调用 50000 次 search, add, 以及 erase操作。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/design-skiplist
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
