package JavaCode.top_interview_questions_medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis
{
    class Solution
    {
        private List<String> list;
        private int n;
        public List<String> generateParenthesis(int n)
        {
            list=new ArrayList<>();
            if(n==0) return list;
            this.n=n;
            fun("",0,0);
            return list;
        }

        /**
         * 递归方式
         * @param s
         * @param i s中左括号的个数
         * @param j s中右括号的个数
         */
        void fun(String s,int i,int j)
        {
            if(s.length()==2*n)
            {
                list.add(s);
                return;
            }
            if(i>=j&&i<=n)
            {
                if(i!=n)fun (s+"(",i+1,j);
                fun(s+")",i,j+1);
            }
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/92/
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
