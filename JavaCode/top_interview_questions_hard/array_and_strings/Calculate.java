package JavaCode.top_interview_questions_hard.array_and_strings;

import java.util.Stack;

public class Calculate {
    public static void main(String[] args) {
        System.out.println(new Calculate().calculate("3/2"));
    }
    public int calculate(String s) {

        if(s.length()==0) return 0;

        int num=0;
        Stack<Integer> stack=new Stack<>();
        char symbol='+';
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                num=num*10+c-'0';
            }
            if(c<'0'&&c!=' '||i==s.length()-1)
            {
                if(symbol=='+')
                {
                    stack.push(num);
                }
                else if(symbol=='-')
                {
                    stack.push(-num);
                }
                else if(symbol=='*')
                {
                    stack.push(stack.pop()*num);
                }
                else
                {
                    stack.push(stack.pop()/num);
                }
                symbol=c;
                num=0;
            }
        }
        int result=0;

        while (!stack.isEmpty())
        {
            result+=stack.pop();
        }
        return result;
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/131/
 * 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
