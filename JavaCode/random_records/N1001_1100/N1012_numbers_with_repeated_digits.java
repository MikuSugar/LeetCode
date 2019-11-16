package JavaCode.random_records.N1001_1100;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2019/11/16
 */
public class N1012_numbers_with_repeated_digits {
    public int numDupDigitsAtMostN(int N) {
        char[] strs=String.valueOf(N).toCharArray();
        int[][] dp=new int[strs.length][1<<10];
        for (int[] d:dp)Arrays.fill(d,-1);
        return N-slove(0, 0, true, strs, dp)+1;
    }

    private int slove(int idx, int pre, boolean isLimit, char[] strs, int[][] dp) {
        if(idx==strs.length)return 1;
        if(!isLimit&&dp[idx][pre]!=-1)return dp[idx][pre];
        int res=0;
        int max=isLimit?strs[idx]-'0':9;
        for (int i=0;i<=max;i++)
        {
            if ((pre&(1<<i))!=0) continue;
            boolean nextLimit=isLimit&&strs[idx]-'0'==i;
            if(pre==0&&i==0)res+=slove(idx+1,pre,nextLimit,strs,dp);
            else res+=slove(idx+1,pre|(1<<i),nextLimit,strs,dp);
        }
        if(!isLimit)dp[idx][pre]=res;
        return res;
    }

}
/*
给定正整数 N，返回小于等于 N 且具有至少 1 位重复数字的正整数。

示例 1：

输入：20
输出：1
解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
示例 2：

输入：100
输出：10
解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
示例 3：

输入：1000
输出：262
 

提示：

1 <= N <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/numbers-with-repeated-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
