package JavaCode.top_interview_questions_easy.strings;

public class nine {
    class Solution {
        public String longestCommonPrefix(String[] strs) {

            if(strs.length==0)
            {
                return "";
            }
            else if(strs.length==1)
            {
                return strs[0];
            }

            StringBuilder sb=new StringBuilder();
            for(int i=0;i<strs[0].length();i++)
            {
                char temp=strs[0].charAt(i);
                boolean flag=true;
                for(int k=1;k<strs.length;k++)
                {
                    if(i>=strs[k].length())
                    {
                        flag=false;
                        break;
                    }
                    if(temp!=strs[k].charAt(i))
                    {
                        flag=false;
                        break;
                    }
                }
                if(!flag)
                {
                    break;
                }
                sb.append(temp);
            }
            return sb.toString();

        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/40/
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
