package JavaCode.contest.weekly.n0_200.n132;

public class N3 {

    private final static int MAX=10000;
    public int longestArithSeqLength(int[] A) {
        if(A.length<=2)return A.length;

        int res=2;
        int[][] dp=new int[A.length][MAX*2+5];
        for (int i=1;i<A.length;i++)
        {
            for (int j=0;j<i;j++)
            {
                int dif=A[i]-A[j]+MAX;
                int len=dp[j][dif]==0?2:dp[j][dif]+1;
                dp[i][dif]=Math.max(dp[i][dif],len);
                res=Math.max(res,dp[i][dif]);
            }
        }
        return res;
    }
}
/**
 * 5025. 最长等差数列  显示英文描述
 * 用户通过次数 0
 * 用户尝试次数 0
 * 通过次数 0
 * 提交次数 0
 * 题目难度 Medium
 * 给定一个整数数组 A，返回 A 中最长等差子序列的长度。
 *
 * 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 示例 2：
 *
 * 输入：[9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * 示例 3：
 *
 * 输入：[20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 *
 *
 * 提示：
 *
 * 2 <= A.length <= 2000
 * 0 <= A[i] <= 10000
 */
