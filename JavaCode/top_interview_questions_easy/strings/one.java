package JavaCode.top_interview_questions_easy.strings;

public class one {
    class Solution {
        public String reverseString(String s) {
            StringBuilder sb=new StringBuilder();
            for(int i=s.length()-1;i>=0;i--)
            {
                sb.append(s.substring(i,i+1));
            }
            return sb.toString();
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/32/
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * 示例 1:
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 */
