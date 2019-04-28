package JavaCode.contest.n134;


import java.util.Map;

public class N3 {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp=new int[A.length+1][B.length+1];
        for (int i=1;i<=A.length;i++)
        {
            for (int j=1;j<=B.length;j++)
            {
                if(A[i-1]==B[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[A.length][B.length];

    }
}
/**
 *5041. 不相交的线  显示英文描述
 * 用户通过次数 33
 * 用户尝试次数 50
 * 通过次数 33
 * 提交次数 74
 * 题目难度 Medium
 * 我们在两条独立的水平线上按给定的顺序写下 A 和 B 中的整数。
 *
 * 现在，我们可以绘制一些连接两个数字 A[i] 和 B[j] 的直线，只要 A[i] == B[j]，且我们绘制的直线不与任何其他连线（非水平线）相交。
 *
 * 以这种方法绘制线条，并返回我们可以绘制的最大连线数。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：A = [1,4,2], B = [1,2,4]
 * 输出：2
 * 解释：
 * 我们可以画出两条不交叉的线，如上图所示。
 * 我们无法画出第三条不相交的直线，因为从 A[1]=4 到 B[2]=4 的直线将与从 A[2]=2 到 B[1]=2 的直线相交。
 * 示例 2：
 *
 * 输入：A = [2,5,1,2,5], B = [10,5,2,1,5,2]
 * 输出：3
 * 示例 3：
 *
 * 输入：A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 500
 * 1 <= B.length <= 500
 * 1 <= A[i], B[i] <= 2000
 */
