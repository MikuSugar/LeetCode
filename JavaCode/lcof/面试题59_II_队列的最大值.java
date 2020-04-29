package JavaCode.lcof;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @Author:fangjie
 * @Date:2020/4/29 10:02 下午
 */
public class 面试题59_II_队列的最大值 {
}
class MaxQueue {

    private Deque<Integer> maxQueue;
    private Queue<Integer> queue;
    public MaxQueue() {
        maxQueue=new ArrayDeque<>();
        queue=new ArrayDeque<>();
    }

    public int max_value() {
        return maxQueue.isEmpty()?-1:maxQueue.peek();
    }

    public void push_back(int value) {
        while (!maxQueue.isEmpty()&&maxQueue.peekLast()<value)
        {
            maxQueue.pollLast();
        }
        maxQueue.add(value);
        queue.add(value);
    }

    public int pop_front() {
        if(queue.isEmpty())return -1;
        int res=queue.poll();
        if(res==maxQueue.peek())maxQueue.poll();
        return res;
    }
}
/*
请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1

示例 1：

输入:
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
示例 2：

输入:
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]
 

限制：

1 <= push_back,pop_front,max_value的总操作数 <= 10000
1 <= value <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
