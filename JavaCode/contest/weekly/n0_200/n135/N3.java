package JavaCode.contest.weekly.n0_200.n135;

public class N3 {
    public int minScoreTriangulation(int[] A) {
        return getRes(A,new int[A.length][A.length],0,A.length-1);
    }

    private int getRes(int[] a, int[][] dp, int i, int j) {
        if(dp[i][j]!=0)return dp[i][j];
        if(i==j||i+1==j)return 0;
        dp[i][j]=getRes(a,dp,i+1,j)+help(a,i,i+1,j);
        for (int k=i+2;k<j;k++)
        {
            int t=getRes(a,dp,i,k)+getRes(a,dp,k,j)+help(a,i,k,j);
            if(t<dp[i][j])
            {
                dp[i][j]=t;
            }
        }
        return dp[i][j];
    }
    private int help(int[] a,int i, int k, int j) {
        return a[i]*a[k]*a[j];
    }

}
/**
 * 给定 N，想象一个凸 N 边多边形，其顶点按顺时针顺序依次标记为 A[0], A[i], ..., A[N-1]。
 *
 * 假设您将多边形剖分为 N-2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 N-2 个三角形的值之和。
 *
 * 返回多边形进行三角剖分后可以得到的最低分。
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3]
 * 输出：6
 * 解释：多边形已经三角化，唯一三角形的分数为 6。
 * 示例 2：
 *
 *
 *
 * 输入：[3,7,4,5]
 * 输出：144
 * 解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
 * 示例 3：
 *
 * 输入：[1,3,1,4,1,5]
 * 输出：13
 * 解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
 *
 *
 * 提示：
 *
 * 3 <= A.length <= 50
 * 1 <= A[i] <= 100
 */

