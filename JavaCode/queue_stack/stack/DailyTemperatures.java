package JavaCode.queue_stack.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] t={73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(t)));
    }

    public int[] dailyTemperatures(int[] T) {

        int[] result=new int[T.length];
        if(T.length<=1) return result;

        class Node{
            int t;
            int index;
            public Node(int t,int index)
            {
                this.t=t;
                this.index=index;
            }
        }

        Stack<Node> stack=new Stack<>();

        for(int i=0;i<T.length;i++)
        {
            if(stack.isEmpty())
            {
                stack.push(new Node(T[i],i));
            }
            else
            {
                while (!stack.isEmpty())
                {
                    Node node=stack.peek();
                    if(T[i]>node.t)
                    {
                        result[node.index]=i-node.index;
                        stack.pop();
                    }
                    else
                    {
                        break;
                    }
                }
                stack.push(new Node(T[i],i));
            }
        }
        return result;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/queue-stack/218/stack-last-in-first-out-data-structure/879/
 *  每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 */
