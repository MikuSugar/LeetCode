package JavaCode.contest.n136;


public class N3 {

    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp=new int[A.length+1];
        for (int i=0;i<A.length;i++)
        {
            int max=0;
            for (int j=i;j<i+K&&j<A.length;j++)
            {
                max=Math.max(max,A[j]);
                dp[j+1]=Math.max(dp[j+1],dp[i]+(j-i+1)*max);
            }
        }
        return dp[A.length];
    }
}
/**
 * 5057. 分隔数组以得到最大和  显示英文描述
 * 用户通过次数 1
 * 用户尝试次数 1
 * 通过次数 1
 * 提交次数 1
 * 题目难度 Medium
 * 给出整数数组 A，将该数组分隔为长度最多为 K 的几个（连续）子数组。分隔完成后，每个子数组的中的值都会变为该子数组中的最大值。
 *
 * 返回给定数组完成分隔后的最大和。
 *
 *
 *
 * 示例：
 *
 * 输入：A = [1,15,7,9,2,5,10], K = 3
 * 输出：84
 * 解释：A 变为 [15,15,15,9,10,10,10]
 *
 *
 * 提示：
 *
 * 1 <= K <= A.length <= 500
 * 0 <= A[i] <= 10^6
 */
