package JavaCode.top_interview_questions_medium.others;

import java.util.Stack;

public class EvalRPN {
    public static void main(String[] args) {
        String[] t={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvalRPN().new Solution().evalRPN(t));
    }
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack=new Stack<>();
            for(String s:tokens)
            {
                try{
                    int i=Integer.parseInt(s);
                    stack.push(i);
                }catch (Exception e)
                {
                    int a=stack.pop();
                    int b=stack.pop();
                    if(s.equals("+")) stack.push(a+b);
                    else if(s.equals("-")) stack.push(b-a);
                    else if(s.equals("*")) stack.push(a*b);
                    else stack.push(b/a);
                }
            }
            return stack.peek();
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/54/others/120/
 * 逆波兰表达式求值
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
