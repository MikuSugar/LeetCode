package JavaCode.contest.n149;

import java.util.Arrays;
import java.util.Map;

public class N2 {

    public static void main(String[] args) {
        System.out.println(new N2().numRollsToTarget(30,30,500));
    }
    final static int MOD=(int)(1e9+7);
    public int numRollsToTarget(int d, int f, int target) {
        long[][] dp=new long[d+1][target+1];
        dp[0][0]=1l;
        for (int i=1;i<=d;i++)
        {
            for (int j=1;j<=f;j++)
            {
                for (int k=0;k+j<=target;k++)
                {
                    dp[i][k+j]=(dp[i][k+j]+dp[i-1][k])%MOD;
                }
            }
        }
        return (int) dp[d][target];

    }

}
/**
 *这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。
 *
 * 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
 *
 * 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：d = 1, f = 6, target = 3
 * 输出：1
 * 示例 2：
 *
 * 输入：d = 2, f = 6, target = 7
 * 输出：6
 * 示例 3：
 *
 * 输入：d = 2, f = 5, target = 10
 * 输出：1
 * 示例 4：
 *
 * 输入：d = 1, f = 2, target = 3
 * 输出：0
 * 示例 5：
 *
 * 输入：d = 30, f = 30, target = 500
 * 输出：222616187
 *
 *
 * 提示：
 *
 * 1 <= d, f <= 30
 * 1 <= target <= 1000
 */
