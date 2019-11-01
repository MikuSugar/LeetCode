package JavaCode.random_records.N101_200;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2019/11/1
 */
public class N115_distinct_subsequences {
    public int numDistinct(String s, String t) {
        if(t.isEmpty())return 1;
        if(s.isEmpty())return 0;
        int[][] dp=new int[s.length()][t.length()];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        return slove(0,0,s.toCharArray(),t.toCharArray(),dp);
    }

    private int slove(int sIdx, int tIdx, char[] sStr, char[] tStr, int[][] dp) {
        if(tIdx==dp[0].length)return 1;
        if(sIdx>=dp.length)return 0;
        if(dp[sIdx][tIdx]!=-1)return dp[sIdx][tIdx];
        int res=0;
        for (int i=sIdx;i<dp.length;i++)
        {
            if(sStr[i]==tStr[tIdx])
            {
                res+=slove(i+1,tIdx+1,sStr,tStr,dp);
            }
        }
        return dp[sIdx][tIdx]=res;
    }
}
/*
给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。

一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

示例 1:

输入: S = "rabbbit", T = "rabbit"
输出: 3
解释:

如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
(上箭头符号 ^ 表示选取的字母)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
示例 2:

输入: S = "babgbag", T = "bag"
输出: 5
解释:

如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
(上箭头符号 ^ 表示选取的字母)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/distinct-subsequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
