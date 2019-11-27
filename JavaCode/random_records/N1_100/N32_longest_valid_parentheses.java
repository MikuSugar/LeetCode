package JavaCode.random_records.N1_100;

import java.util.Stack;

/**
 * author:fangjie
 * time:2019/11/27
 */
public class N32_longest_valid_parentheses {
    public int longestValidParentheses(String s) {
        char[] strs=s.toCharArray();
        Stack<Integer> stack=new Stack<>();
        int res=0;
        stack.push(-1);
        for (int i=0;i<strs.length;i++)
        {
            if(strs[i]=='(')
            {
                stack.push(i);
            }
            else
            {
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else res=Math.max(res,i-stack.peek());
            }
        }
        return res;
    }
}
/*
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
