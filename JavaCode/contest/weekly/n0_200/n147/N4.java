package JavaCode.contest.weekly.n0_200.n147;

import java.util.Arrays;

public class N4 {
    public int stoneGameII(int[] piles) {
        int[] presum=new int[piles.length+1];
        for (int i=0;i<piles.length;i++)
        {
            presum[i+1]=presum[i]+piles[i];
        }
        int[][] dp=new int[piles.length+1][piles.length];
        for (int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return solve(piles,presum,dp,1,0);
    }

    private int solve(int[] piles, int[] presum, int[][] dp, int m, int idx) {
        if(idx>=piles.length)return 0;
        if(dp[m][idx]!=-1)return dp[m][idx];
        int res=0,sum=0;
        for (int x=1;x<=2*m;x++)
        {
            if(x+idx>piles.length)break;
            sum+=piles[x+idx-1];
            int temp=solve(piles,presum,dp,Math.min(piles.length,Math.max(m,x)),idx+x);
            res=Math.max(res,presum[piles.length]-presum[idx+x]-temp+sum);
        }
        return dp[m][idx]=res;
    }
}
/**
 *亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
 *
 * 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
 *
 * 游戏一直持续到所有石子都被拿走。
 *
 * 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
 *
 *
 *
 * 示例：
 *
 * 输入：piles = [2,7,9,4,4]
 * 输出：10
 * 解释：
 * 如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。
 * 如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
 * 所以我们返回更大的 10。
 *
 *
 * 提示：
 *
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10 ^ 4
 */
