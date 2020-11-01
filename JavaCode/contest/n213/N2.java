package JavaCode.contest.n213;

import java.util.Arrays;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/11/1 10:41 上午
 */
public class N2 {
    //["a","e","i","o","u"]
    public int countVowelStrings(int n) {
        int[][] dp=new int[6][n+1];
        for (int[] a:dp) Arrays.fill(a,-1);
        return slove(0,n,dp);
    }

    private int slove(int pre, int n, int[][] dp) {
        if(dp[pre][n]!=-1)return dp[pre][n];
        if(n==0)return 1;
        int res=0;
        for (int i=Math.max(1,pre);i<=5;i++)
        {
            res+=slove(i,n-1,dp);
        }
        return dp[pre][n]=res;
    }
}
/*
给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。

字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。



示例 1：

输入：n = 1
输出：5
解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
示例 2：

输入：n = 2
输出：15
解释：仅由元音组成的 15 个字典序字符串为
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
示例 3：

输入：n = 33
输出：66045


提示：

1 <= n <= 50
 */
