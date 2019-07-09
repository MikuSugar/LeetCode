package JavaCode.random_records.N701_800;

import java.util.Arrays;

public class N787_cheapest_flights_within_k_stops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        int[][] dp=new int[n][K+2];//dp[i][j]，代表从起点到i在j短距离的花费最小值
        int MAX=Integer.MAX_VALUE>>1;
        for (int[] a:dp)
        {
            Arrays.fill(a, MAX);
        }
        //K+2   例如0-1-2进过了1次中转，飞了2段距离
        for (int i=0;i<K+2;i++)
        {
            dp[src][i]=0;
        }

        for (int k=1;k<=K+1;k++)
        {
            for (int[] f:flights)
            {
                if(dp[f[0]][k-1]!=MAX)
                {
                    dp[f[1]][k]=Math.min(dp[f[1]][k],dp[f[0]][k-1]+f[2]);
                }
            }
        }
        return dp[dst][K+1]==MAX?-1:dp[dst][K+1];
    }
}
/**
 * https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/
 *  有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 *
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 cnt 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 *
 * 示例 1:
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, cnt = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 *
 *
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * 示例 2:
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, cnt = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 *
 *
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 * 提示：
 *
 * n 范围是 [1, 100]，城市标签从 0 到 n - 1.
 * 航班数量范围是 [0, n * (n - 1) / 2].
 * 每个航班的格式 (src, dst, price).
 * 每个航班的价格范围是 [1, 10000].
 * cnt 范围是 [0, n - 1].
 * 航班没有重复，且不存在环路
 */
