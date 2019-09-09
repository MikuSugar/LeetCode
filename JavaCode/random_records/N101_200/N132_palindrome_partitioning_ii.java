package JavaCode.random_records.N101_200;

import java.util.Arrays;

public class N132_palindrome_partitioning_ii {

    public int minCut(String s) {
        boolean[][] isPhrase=getPhrase(s);
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return slove(isPhrase,dp,0);
    }

    private int slove(boolean[][] isPhrase, int[] dp, int idx) {
        if(isPhrase[idx][isPhrase.length-1])return 0;
        if(dp[idx]!=-1)return dp[idx];
        int res=Integer.MAX_VALUE>>1;
        for (int i=idx;i<isPhrase.length;i++)
        {
            if(isPhrase[idx][i])
            {
                res=Math.min(res,slove(isPhrase,dp,i+1)+1);
            }
        }
        return dp[idx]=res;
    }

    private boolean[][] getPhrase(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        for (int l=1;l<=s.length();l++)
        {
            for (int i=0;i<=s.length()-l;i++)
            {
                int j=i+l-1;
                dp[i][j]=s.charAt(i)==s.charAt(j)&&(l<3||dp[i+1][j-1]);
            }
        }
        return dp;
    }
}
/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回符合要求的最少分割次数。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
