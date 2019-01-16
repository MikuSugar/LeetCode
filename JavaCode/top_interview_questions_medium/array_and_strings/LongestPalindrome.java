package JavaCode.top_interview_questions_medium.array_and_strings;

public class LongestPalindrome
{

    class Solution {
        public String longestPalindrome(String s) {
            if(s.length()==0)
            {
                return "";
            }
            int[][] dp=new int[s.length()+1][s.length()+1];

            for(int i=0;i<dp.length;i++)
            {
                for(int j=0;j<dp.length;j++)
                {
                    if(i==j)
                    {
                        dp[i][j]=1;
                    }
                }
            }
            int max=1;
            int mi=0;
            int mj=0;
            char[] c=s.toCharArray();

            for(int j=0;j<c.length;j++)
            {
                for(int i=j-1;i>=0;i--)
                {
                    if(c[i]==c[j])
                    {
                        if(j-i==1)
                        {
                            dp[i][j]=2;
                        }
                        else if(dp[i+1][j-1]!=0)
                        {
                            dp[i][j]=dp[i+1][j-1]+2;
                        }

                        if(dp[i][j]>=max)
                        {
                            max=dp[i][j];
                            mi=i;
                            mj=j;
                        }
                    }
                }
            }
            return s.substring(mi,mj+1);
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/79/
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
