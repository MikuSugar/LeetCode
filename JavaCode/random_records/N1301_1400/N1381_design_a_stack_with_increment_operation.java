package JavaCode.random_records.N1301_1400;

/**
 * author:fangjie
 * time:2020/3/17
 */
public class N1381_design_a_stack_with_increment_operation {
    class CustomStack {
        private int size;
        private final int maxSize;
        private Node head;
        private Node tail;
        public CustomStack(int maxSize) {
            this.maxSize=maxSize;
            this.size=0;
            this.head=new Node(-1);
            this.tail=new Node(-1);
            head.next=tail;
            tail.pre=head;
        }

        public void push(int x) {
            if(size==maxSize)return;
            Node node=new Node(x);
            node.pre=tail.pre;
            node.next=tail;
            node.pre.next=node;
            tail.pre=node;
            size++;
        }

        public int pop() {
            if(tail.pre==head)return -1;
            Node node=tail.pre;
            node.pre.next=tail;
            tail.pre=node.pre;
            size--;
            return node.val;
        }

        public void increment(int k, int val) {
            Node cur=head.next;
            while (cur!=null&&k-->0)
            {
                cur.add(val);
                cur=cur.next;
            }
        }

        private class Node
        {
            Node pre,next;
            int val;
            public Node(int val) {
                this.val=val;
            }
            public void  add(int num)
            {
                this.val+=num;
            }
        }
    }

/*
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
}
/*
请你设计一个支持下述操作的栈。

实现自定义栈类 CustomStack ：

CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
int pop()：返回栈顶的值，或栈为空时返回 -1 。
void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
 

示例：

输入：
["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
输出：
[null,null,null,2,null,null,null,null,null,103,202,201,-1]
解释：
CustomStack customStack = new CustomStack(3); // 栈是空的 []
customStack.push(1);                          // 栈变为 [1]
customStack.push(2);                          // 栈变为 [1, 2]
customStack.pop();                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
customStack.push(2);                          // 栈变为 [1, 2]
customStack.push(3);                          // 栈变为 [1, 2, 3]
customStack.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
customStack.increment(5, 100);                // 栈变为 [101, 102, 103]
customStack.increment(2, 100);                // 栈变为 [201, 202, 103]
customStack.pop();                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
customStack.pop();                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
customStack.pop();                            // 返回 201 --> 返回栈顶值 201，栈变为 []
customStack.pop();                            // 返回 -1 --> 栈为空，返回 -1
 

提示：

1 <= maxSize <= 1000
1 <= x <= 1000
1 <= k <= 1000
0 <= val <= 100
每种方法 increment，push 以及 pop 分别最多调用 1000 次

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/design-a-stack-with-increment-operation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
