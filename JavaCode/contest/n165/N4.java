package JavaCode.contest.n165;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2019/12/1
 */
public class N4 {
    public int palindromePartition(String s, int k) {
        char[] strs=s.toCharArray();
        boolean[][] isP=getPhrase(strs);
        int[][] dp=new int[strs.length][k+1];
        for (int[] d:dp)Arrays.fill(d,-1);
        return slove(0,k,strs,dp,isP);
    }

    private int slove(int idx, int k, char[] strs, int[][] dp, boolean[][] isP) {
        if(idx==strs.length)return 0;
        if(k==0)return Integer.MAX_VALUE>>1;
        if(dp[idx][k]!=-1)return dp[idx][k];
        int res=Integer.MAX_VALUE>>1;
        for (int i=idx;i<strs.length;i++)
        {
            if(isP[idx][i]) res=Math.min(res,slove(i+1,k-1,strs,dp,isP));
            else res=Math.min(res,getMin(idx,i,strs)+slove(i+1,k-1,strs,dp,isP));
        }
        return dp[idx][k]=res;
    }
    private boolean[][] getPhrase(char[] s) {
        boolean[][] dp=new boolean[s.length][s.length];
        for (int l=1;l<=s.length;l++)
        {
            for (int i=0;i<=s.length-l;i++)
            {
                int j=i+l-1;
                dp[i][j]=s[i]==s[j]&&(l<3||dp[i+1][j-1]);
            }
        }
        return dp;
    }
    private int getMin(int left, int right, char[] strs) {
        int res=0;
        while (left<right)
        {
            if(strs[left++]!=strs[right--])res++;
        }
        return res;
    }
}
/*
给你一个由小写字母组成的字符串 s，和一个整数 k。

请你按下面的要求分割字符串：

首先，你可以将 s 中的部分字符修改为其他的小写英文字母。
接着，你需要把 s 分割成 k 个非空且不相交的子串，并且每个子串都是回文串。
请返回以这种方式分割字符串所需修改的最少字符数。



示例 1：

输入：s = "abc", k = 2
输出：1
解释：你可以把字符串分割成 "ab" 和 "c"，并修改 "ab" 中的 1 个字符，将它变成回文串。
示例 2：

输入：s = "aabbc", k = 3
输出：0
解释：你可以把字符串分割成 "aa"、"bb" 和 "c"，它们都是回文串。
示例 3：

输入：s = "leetcode", k = 8
输出：0


提示：

1 <= k <= s.length <= 100
s 中只含有小写英文字母。
 */
