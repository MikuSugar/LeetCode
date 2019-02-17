package JavaCode.top_interview_questions_hard.backtracking;

public class Match {
    public static void main(String[] args) {
        System.out.println(new Match().isMatch("aa","??"));
    }
    public boolean isMatch(String s, String p) {

        //dp[i][j]表示s(0～i-1)与p(0～j-1)子串是否匹配
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];

        //初始化
        dp[0][0]=true;
        for (int i=1;i<=s.length();i++)
        {
            dp[i][0]=false;
        }
        for (int j=1;j<=p.length();j++)
        {
            dp[0][j]=(p.charAt(j-1)=='*'&&dp[0][j-1]);
        }

        //遍历
        for(int j=1;j<=p.length();j++)
        {
            for(int i=1;i<=s.length();i++)
            {
                if(p.charAt(j-1)=='*')
                {
                    dp[i][j]=(dp[i-1][j]||dp[i][j-1]);
                }
                else
                {
                    dp[i][j]=(dp[i-1][j-1]&&(p.charAt(j-1)=='?'||p.charAt(j-1)==s.charAt(i-1)));
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/58/backtracking/149/
 * 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 */
