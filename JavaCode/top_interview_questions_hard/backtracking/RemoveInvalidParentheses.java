package JavaCode.top_interview_questions_hard.backtracking;

import java.util.ArrayList;
import java.util.List;



public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<>();
        remove(s,res,0,0,new char[]{'(',')'});
        return res;
    }

    /**
     * @param s
     * @param res
     * @param last_i 之前的合法
     * @param last_j 上一次删除的位置
     * @param par
     */
    private void remove(String s,List<String> res ,int last_i,int last_j,char[] par)
    {
        for(int cnt=0,i=last_i;i<s.length();i++)
        {
            if(s.charAt(i)==par[0])cnt++;
            if(s.charAt(i)==par[1])cnt--;
            if(cnt<0)
            {
                for (int j=last_j;j<=i;j++)
                {
                    if(s.charAt(j)==par[1]&&(j==last_j||s.charAt(j-1)!=par[1]))
                    {
                        remove(s.substring(0,j)+s.substring(j+1,s.length()),res,i,j,par);
                    }
                }
                return;
            }
        }
        String reverse=new StringBuilder(s).reverse().toString();
        if(par[0]=='(')remove(reverse,res,0,0,new char[]{')','('});
        else res.add(reverse);
    }


}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/58/backtracking/148/
 * Remove Invalid Parentheses
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 *
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 * 示例 1:
 *
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 示例 2:
 *
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 示例 3:
 *
 * 输入: ")("
 * 输出: [""]
 */
