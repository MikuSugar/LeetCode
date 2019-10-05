package JavaCode.contest.biweekly_n10;

/**
 * author:fangjie
 * time:2019/10/5
 */
public class N4 {

    public boolean isValidPalindrome(String s, int k) {
        char [] str= s.toCharArray();
        int n = str.length;
        int [][] dp=new int[n+1][n+1];
        for(int i=1; i<=n; i++)
        {
            dp[i][0]=dp[0][i] = i;
        }
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                dp[i][j] = Math.min(dp[i][j-1] + 1, dp[i-1][j] + 1);
                if(str[i-1] == str[n-j])
                {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                }
            }
        }

        return dp[n][n]/2<=k;

    }
}
/**
 *给出一个字符串 s 和一个整数 k，请你帮忙判断这个字符串是不是一个「K 回文」。
 *
 * 所谓「K 回文」：如果可以通过从字符串中删去最多 k 个字符将其转换为回文，那么这个字符串就是一个「K 回文」。
 *
 *
 *
 * 示例：
 *
 * 输入：s = "abcdeca", k = 2
 * 输出：true
 * 解释：删除字符 “b” 和 “e”。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 中只含有小写英文字母
 * 1 <= k <= s.length
 */
