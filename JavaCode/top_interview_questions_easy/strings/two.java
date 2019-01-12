package JavaCode.top_interview_questions_easy.strings;

public class two {
    class Solution {
        public int reverse(int x) {
            boolean flag=false;//是否为负数标志
            if(x<0)
            {
                flag=true;
            }
            int ans=0;

            String num=new String(new Integer(x).toString());
            if(flag)
            {
                StringBuilder sb=new StringBuilder(num.substring(1,num.length()));
                num="-"+sb.reverse().toString();
            }
            else
            {
                StringBuilder sb=new StringBuilder(num);
                sb=sb.replace(0,num.length(),num);
                num=sb.reverse().toString();
            }

            try
            {
                ans=Integer.parseInt(num);
            }
            catch (Exception e)
            {
                return 0;
            }
            return ans;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/33/
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
