package JavaCode.random_records.N101_200;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2019/11/15
 */
public class N188_best_time_to_buy_and_sell_stock_iv {
    public int maxProfit(int k, int[] prices) {
        if(k>=prices.length/2)
        {
            int[][] dp=new int[2][prices.length];
            for (int[] a:dp)Arrays.fill(a,-1);
            return slove(0,0,dp,prices);
        }
        int[][][] dp=new int[k+1][2][prices.length];
        for (int[][] a:dp) for (int[] b:a) Arrays.fill(b,-1);
        return slove(0,0,0,dp,prices);
    }

    private int slove(int flag, int idx, int[][] dp, int[] prices) {
        if(idx==prices.length)return 0;
        if(dp[flag][idx]!=-1)return dp[flag][idx];
        int res=slove(flag,idx+1,dp,prices);
        if(flag==0)res=Math.max(res,-prices[idx]+slove(1,idx+1,dp,prices));
        else res=Math.max(res,prices[idx]+slove(0,idx+1,dp,prices));
        return dp[flag][idx]=res;
    }

    private int slove(int k, int flag, int idx, int[][][] dp, int[] prices) {
        if(k==dp.length||idx==prices.length)return 0;
        if(dp[k][flag][idx]!=-1)return dp[k][flag][idx];
        int res=slove(k,flag,idx+1,dp,prices);
        if(flag==0) res=Math.max(res,-prices[idx]+slove(k+1,1,idx+1,dp,prices));
        else res=Math.max(res,prices[idx]+slove(k,0,idx+1,dp,prices));
        return dp[k][flag][idx]=res;
    }
}
/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [2,4,1], k = 2
输出: 2
解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
示例 2:

输入: [3,2,6,5,0,3], k = 2
输出: 7
解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
