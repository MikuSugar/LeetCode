package JavaCode.top_interview_questions_easy.design;

import java.util.ArrayList;
import java.util.List;

public class MinStack
{
    public static void main(String[] args)
    {
        MinStack minStack=new MinStack();
        minStack.push(-2);
        minStack.push(-3);
        minStack.push(0);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }


    private List<Integer> minlist;
    private List<Integer> list;
    /** initialize your data structure here. */
    public MinStack() {
        list=new ArrayList<>();
        minlist=new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
        if(minlist.size()<1)
        {
            minlist.add(x);
        }
        else
        {
            int temp=Math.min(x,minlist.get(minlist.size()-1));
            minlist.add(temp);
        }
    }

    public void pop() {
        list.remove(list.size()-1);
        minlist.remove(minlist.size()-1);
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        return minlist.get(minlist.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 *//**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/24/design/59/
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
