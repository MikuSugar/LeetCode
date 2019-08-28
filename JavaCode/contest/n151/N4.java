package JavaCode.contest.n151;

import java.util.*;

public class N4 {

    //LeetCode.com AC
    //LeetCode-cn.com 超时
    class DinnerPlates {
        final int MAX=100000+5;
        private int[][] data;
        private int[] cur;
        private int capacity;
        private int idx;
        private PriorityQueue<Integer> pushQ;
        private PriorityQueue<Integer> popQ;
        public DinnerPlates(int capacity) {
            this.capacity=capacity;
            data=new int[MAX][capacity];
            cur=new int[MAX];
            idx=0;
            pushQ=new PriorityQueue<>();
            popQ=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        }

        public void push(int val) {
            if(pushQ.isEmpty()||cur[pushQ.peek()]>=capacity)
            {
                data[idx][cur[idx]++]=val;
                if(cur[idx]<capacity)pushQ.add(idx);
                popQ.add(idx++);
                return;
            }
            int first= pushQ.poll();
            data[first][cur[first]++]=val;
            if(cur[first]==1)popQ.add(first);
            if(cur[first]<capacity) pushQ.add(first);
        }

        public int pop() {
            if(popQ.isEmpty())return -1;
            int first=popQ.peek();
            if(cur[first]==capacity) pushQ.add(first);
            int res=data[first][--cur[first]];
            if(cur[first]==0)popQ.remove(first);
            return res;
        }

        public int popAtStack(int index) {
            if(index<0||index>=idx||cur[index]==0)return -1;
            if(cur[index]==capacity)pushQ.add(index);
            int res=data[index][--cur[index]];
            if (cur[index]==0)popQ.remove(index);
            return res;
        }
    }

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
}
/**
 *我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。
 *
 * 实现一个叫「餐盘」的类 DinnerPlates：
 *
 * DinnerPlates(int capacity) - 给出栈的最大容量 capacity。
 * void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。
 * int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。
 * int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -1。
 *
 *
 * 示例：
 *
 * 输入：
 * ["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
 * [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
 * 输出：
 * [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
 *
 * 解释：
 * DinnerPlates D = DinnerPlates(2);  // 初始化，栈最大容量 capacity = 2
 * D.push(1);
 * D.push(2);
 * D.push(3);
 * D.push(4);
 * D.push(5);         // 栈的现状为：    2  4
 *                                     1  3  5
 *                                     ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 2。栈的现状为：      4
 *                                           1  3  5
 *                                           ﹈ ﹈ ﹈
 * D.push(20);        // 栈的现状为：  20  4
 *                                    1  3  5
 *                                    ﹈ ﹈ ﹈
 * D.push(21);        // 栈的现状为：  20  4 21
 *                                    1  3  5
 *                                    ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 20。栈的现状为：       4 21
 *                                             1  3  5
 *                                             ﹈ ﹈ ﹈
 * D.popAtStack(2);   // 返回 21。栈的现状为：       4
 *                                             1  3  5
 *                                             ﹈ ﹈ ﹈
 * D.pop()            // 返回 5。栈的现状为：        4
 *                                             1  3
 *                                             ﹈ ﹈
 * D.pop()            // 返回 4。栈的现状为：    1  3
 *                                            ﹈ ﹈
 * D.pop()            // 返回 3。栈的现状为：    1
 *                                            ﹈
 * D.pop()            // 返回 1。现在没有栈。
 * D.pop()            // 返回 -1。仍然没有栈。
 *
 *
 * 提示：
 *
 * 1 <= capacity <= 20000
 * 1 <= val <= 20000
 * 0 <= index <= 100000
 * 最多会对 push，pop，和 popAtStack 进行 200000 次调用。
 */
