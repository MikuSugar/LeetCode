package JavaCode.contest.n207;

import java.util.*;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/9/20 10:15 上午
 */
public class N4 {
    public int connectTwoGroups(List<List<Integer>> cost) {

        int max = 1 << cost.get(0).size();
        int[] min = new int[cost.get(0).size()];
        int[] dp = new int[max];
        int[] dp2 = new int[max];

        Arrays.fill(dp, Integer.MAX_VALUE>>1);
        dp[0] = 0;
        Arrays.fill(min, Integer.MAX_VALUE>>1);
        for (List<Integer> res : cost)
        {
            for (int j=0; j<cost.get(0).size(); j++) min[j]=Math.min(min[j], res.get(j));
        }

        for (List<Integer> integers : cost)
        {
            Arrays.fill(dp2, Integer.MAX_VALUE>>1);
            for (int j=0; j<max; j++)
            {
                if (dp[j]!=Integer.MAX_VALUE)
                {
                    for (int k=0; k<cost.get(0).size(); k++)
                    {
                        int next=j|1<<k;
                        dp2[next]=Math.min(dp2[next], dp[j]+integers.get(k));
                    }
                }
            }
            int[] temp=dp;
            dp=dp2;
            dp2=temp;
        }

        int res = Integer.MAX_VALUE>>1;
        for (int i=1; i<max; i++)
        {
            int cur = dp[i];
            for (int j=0; j<cost.get(0).size(); j++)
            {
                if ((i & 1 << j) == 0) cur += min[j];

            }
            res = Math.min(res, cur);
        }
        return res;

    }

}
/*
给你两组点，其中第一组中有 size1 个点，第二组中有 size2 个点，且 size1 >= size2 。

任意两点间的连接成本 cost 由大小为 size1 x size2 矩阵给出，其中 cost[i][j] 是第一组中的点 i 和第二组中的点 j 的连接成本。如果两个组中的每个点都与另一组中的一个或多个点连接，则称这两组点是连通的。换言之，第一组中的每个点必须至少与第二组中的一个点连接，且第二组中的每个点必须至少与第一组中的一个点连接。

返回连通两组点所需的最小成本。



示例 1：



输入：cost = [[15, 96], [36, 2]]
输出：17
解释：连通两组点的最佳方法是：
1--A
2--B
总成本为 17 。
示例 2：



输入：cost = [[1, 3, 5], [4, 1, 1], [1, 5, 3]]
输出：4
解释：连通两组点的最佳方法是：
1--A
2--B
2--C
3--A
最小成本为 4 。
请注意，虽然有多个点连接到第一组中的点 2 和第二组中的点 A ，但由于题目并不限制连接点的数目，所以只需要关心最低总成本。
示例 3：

输入：cost = [[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]
输出：10


提示：

size1 == cost.length
size2 == cost[i].length
1 <= size1, size2 <= 12
size1 >= size2
0 <= cost[i][j] <= 100
 */
