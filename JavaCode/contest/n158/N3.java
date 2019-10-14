package JavaCode.contest.n158;


import java.util.Arrays;

/**
 * author:fangjie
 * time:2019/10/13
 */
public class N3 {

    private final static int MOD=(int) (1e9+7);
    public int dieSimulator(int n, int[] rollMax) {
        long[][][] dp=new long[15+1][6][n+1];
        for (int i=0;i<dp.length;i++)
        {
            for (int j=0;j<dp[0].length;j++)
            {
                Arrays.fill(dp[i][j],-1L);
            }
        }
        return (int) slove(0,-1,n,rollMax,dp);
    }

    private long slove(int pre, int num, int idx, int[] rollMax, long[][][] dp) {
        if(idx==0)return 1L;
        if(num!=-1&&dp[pre][num][idx]!=-1L)return dp[pre][num][idx];
        long res=0L;
        for (int i=0;i<6;i++)
        {
            if(i==num)
            {
                if(pre<rollMax[num])res+=slove(pre+1,i,idx-1,rollMax, dp);
            }
            else res+=slove(1,i,idx-1,rollMax, dp);
            res%=MOD;
        }
        if(num==-1)return res%MOD;
        return dp[pre][num][idx]=res%MOD;

    }
}
/**
 *有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。
 *
 * 不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。
 *
 * 现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。
 *
 * 假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2, rollMax = [1,1,2,2,2,3]
 * 输出：34
 * 解释：我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所以不会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2 = 34。
 * 示例 2：
 *
 * 输入：n = 2, rollMax = [1,1,1,1,1,1]
 * 输出：30
 * 示例 3：
 *
 * 输入：n = 3, rollMax = [1,1,1,2,2,3]
 * 输出：181
 *
 *
 * 提示：
 *
 * 1 <= n <= 5000
 * rollMax.length == 6
 * 1 <= rollMax[i] <= 15
 */
