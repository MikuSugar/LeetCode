package JavaCode.top_interview_questions_easy.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class five
{
    class Solution {
        public boolean isValid(String s) {

            List<Character> list=new ArrayList<>();
            char[] t=s.toCharArray();

            for(char c:t)
            {
                if(fun(c)&&list.size()>0)
                {
                    if(list.get(list.size()-1)==fun1(c))
                    {
                        list.remove(list.size()-1);
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    list.add(c);
                }
            }
            if(list.size()==0)
            {
                return true;
            }
            return false;

        }

        //判断是否为括号结尾
        boolean fun(char c)
        {
            if(c==')'||c=='}'||c==']')
            {
                return true;
            }
            return false;
        }

        //返回配对的括号
        char fun1(char c)
        {
            if(c==')') return '(';
            else if(c==']') return '[';
            else if(c=='}') return '{';
            return '0';
        }

    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/68/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
