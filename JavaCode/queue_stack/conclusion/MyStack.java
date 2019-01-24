package JavaCode.queue_stack.conclusion;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       if(queue1.size()==1)
       {
           return queue1.poll();
       }
       else
       {
           while (queue1.size()>1)
           {
               queue2.add(queue1.poll());
           }
       }
       int x=queue1.poll();
       queue1=queue2;
       queue2=new LinkedList<>();
       return x;
    }

    /** Get the top element. */
    public int top() {
        int x=0;
        if(queue1.size()==1)
        {
           return queue1.peek();
        }
        else
        {
            while (!queue1.isEmpty())
            {
                if(queue1.size()==1)
                {
                    x=queue1.peek();
                }
                queue2.add(queue1.poll());
            }
        }
        queue1=queue2;
        queue2=new LinkedList<>();
        return x;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue1.isEmpty())
            return true;
        return false;
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
/**
 * https://leetcode-cn.com/explore/learn/card/queue-stack/220/conclusion/889/
 * 用队列实现栈
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */
