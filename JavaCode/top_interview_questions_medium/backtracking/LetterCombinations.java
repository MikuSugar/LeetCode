package JavaCode.top_interview_questions_medium.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations
{
    class Solution
    {
        private  String[] infos;
        private List<String> list;
        public List<String> letterCombinations(String digits)
        {
            list=new ArrayList<>();
            if(digits.length()==0) return list;
            this.infos=new String[10];
            infos[2]="abc";
            infos[3]="def";
            infos[4]="ghi";
            infos[5]="jkl";
            infos[6]="mno";
            infos[7]="pqrs";
            infos[8]="tuv";
            infos[9]="wxyz";
            fun("",digits,0);
            return list;
        }

        void fun(String temp,String digits,int index)
        {
            if(index==digits.length()-1)
            {
                list.add(temp);
                return;
            }
            char[] s=infos[digits.charAt(index)-'0'].toCharArray();

            for(char c:s)
            {
                fun(temp+c,digits,index+1);
            }
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/91/
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
