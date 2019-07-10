package JavaCode.random_records.N601_700;

public class N647_palindromic_substrings {
    public int countSubstrings(String s) {
        char[] str=s.toCharArray();
        boolean[][] dp=new boolean[str.length][str.length];
        int res=0;
        for (int j=0;j<dp.length;j++)
        {
            for (int i=0;i<=j;i++)
            {
                if(j-i<2)
                {
                    dp[i][j]=str[i]==str[j];
                }
                else
                {
                    dp[i][j]=(str[i]==str[j])&&dp[i+1][j-1];
                }
                res+=dp[i][j]?1:0;
            }
        }
        return res;
    }
}
/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 *
 * 输入的字符串长度不会超过1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
