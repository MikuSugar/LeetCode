package JavaCode.top_interview_questions_easy.strings;

public class five {
    class Solution {
        public boolean isPalindrome(String s) {
            StringBuilder sb=new StringBuilder();
            char[] chars=s.toCharArray();

            //去除空格等无用字符，统一字母大小写
            for(int i=0;i<chars.length;i++)
            {
                if(chars[i]>='a'&&chars[i]<='z')
                {
                    sb.append((char)( chars[i]-32));
                }
                else if(chars[i]>='A'&&chars[i]<='Z')
                {
                    sb.append(chars[i]);
                }
                else if(chars[i]>='0'&&chars[i]<='9')
                {
                    sb.append(chars[i]);
                }
            }
            String s1=sb.toString();
            String s2=sb.reverse().toString();
            if(s1.equals(s2))
            {
                return true;
            }
            return false;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/36/
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
