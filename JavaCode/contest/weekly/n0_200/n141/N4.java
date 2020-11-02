package JavaCode.contest.weekly.n0_200.n141;

public class N4 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int maxL=str1.length()>str2.length()?str1.length():str2.length();
        int[][] book=new int[maxL+5][maxL+5];
        int[][] dp=new int[maxL+5][maxL+5];
        lcs(str1,str2,dp,book);
        StringBuilder sb = new StringBuilder();
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();
        getlcs(sb,s1,s2,str1.length(),str2.length(),book);
        String s=sb.toString();
        StringBuilder res=new StringBuilder();
        int i=0,j=0;
        for (char c:s.toCharArray())
        {
            while (i<s1.length&&s1[i]!=c)
            {
                res.append(s1[i++]);
            }
            while (j<s2.length&&s2[j]!=c)
            {
                res.append(s2[j++]);
            }
            res.append(c);
            i++;
            j++;
        }
        while (i<s1.length)
        {
            res.append(s1[i++]);
        }
        while (j<s2.length)
        {
            res.append(s2[j++]);
        }
        return res.toString();
    }

    private void getlcs(StringBuilder sb, char[] s1, char[] s2, int i, int j, int[][] book) {
        if(i==0||j==0)return;
        if(book[i][j]==0)
        {
            getlcs(sb,s1,s2,i-1,j-1,book);
            sb.append(s1[i-1]);
        }
        else if(book[i][j]==1)
        {
            getlcs(sb,s1,s2,i-1,j,book);
        }
        else
        {
            getlcs(sb,s1,s2,i,j-1,book);
        }
    }

    private void lcs(String str1, String str2, int[][] dp, int[][] book) {
        for (int i=1;i<=str1.length();i++)
        {
            for (int j=1;j<=str2.length();j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                    book[i][j]=0;
                }
                else if(dp[i-1][j]>=dp[i][j-1])
                {
                    dp[i][j]=dp[i-1][j];
                    book[i][j]=1;
                }
                else
                {
                    dp[i][j]=dp[i][j-1];
                    book[i][j]=-1;
                }
            }
        }
    }
}
/**
 *给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。
 *
 * （如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列）
 *
 *
 *
 * 示例：
 *
 * 输入：str1 = "abac", str2 = "cab"
 * 输出："cabac"
 * 解释：
 * str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。
 * str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
 * 最终我们给出的答案是满足上述属性的最短字符串。
 *
 *
 * 提示：
 *
 * 1 <= str1.length, str2.length <= 1000
 * str1 和 str2 都由小写英文字母组成。
 */
