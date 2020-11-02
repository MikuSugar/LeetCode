package JavaCode.contest.weekly.n201_300.n201;

import utils.Parse;

import java.util.Arrays;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/8/9 10:29 上午
 */
public class N4 {
    public static void main(String[] args) {
        System.out.println(new N4().minCost(9, Parse.parseToIntArray("[5,6,1,4,2]")));
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[][] dp=new int[cuts.length+5][cuts.length+5];
        return slove(0,cuts.length-1,dp,0,n,cuts);
    }

    private int slove(int left, int right, int[][] dp, int s,int e, int[] cuts) {
        if(left>right)return 0;
        if(left==right) return e-s;
        if(dp[left][right]!=0)return dp[left][right];

        int res=Integer.MAX_VALUE;
        for (int i=left;i<=right;i++)
        {
            res=Math.min(res,e-s+slove(left,i-1,dp,s,cuts[i],cuts)
                    +slove(i+1,right,dp,cuts[i],e,cuts));
        }

        return dp[left][right]=res;
    }
}
/*
有一根长度为 n 个单位的木棍，棍上从 0 到 n 标记了若干位置。例如，长度为 6 的棍子可以标记如下：



给你一个整数数组 cuts ，其中 cuts[i] 表示你需要将棍子切开的位置。

你可以按顺序完成切割，也可以根据需要更改切割的顺序。

每次切割的成本都是当前要切割的棍子的长度，切棍子的总成本是历次切割成本的总和。对棍子进行切割将会把一根木棍分成两根较小的木棍（这两根木棍的长度和就是切割前木棍的长度）。请参阅第一个示例以获得更直观的解释。

返回切棍子的 最小总成本 。



示例 1：



输入：n = 7, cuts = [1,3,4,5]
输出：16
解释：按 [1, 3, 4, 5] 的顺序切割的情况如下所示：

第一次切割长度为 7 的棍子，成本为 7 。第二次切割长度为 6 的棍子（即第一次切割得到的第二根棍子），第三次切割为长度 4 的棍子，最后切割长度为 3 的棍子。总成本为 7 + 6 + 4 + 3 = 20 。
而将切割顺序重新排列为 [3, 5, 1, 4] 后，总成本 = 16（如示例图中 7 + 4 + 3 + 2 = 16）。
示例 2：

输入：n = 9, cuts = [5,6,1,4,2]
输出：22
解释：如果按给定的顺序切割，则总成本为 25 。总成本 <= 25 的切割顺序很多，例如，[4，6，5，2，1] 的总成本 = 22，是所有可能方案中成本最小的。


提示：

2 <= n <= 10^6
1 <= cuts.length <= min(n - 1, 100)
1 <= cuts[i] <= n - 1
cuts 数组中的所有整数都 互不相同
 */
