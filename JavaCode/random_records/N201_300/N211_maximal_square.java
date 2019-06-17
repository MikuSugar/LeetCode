package JavaCode.random_records.N201_300;

public class N211_maximal_square {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length<1)return 0;
        int[][] dp=new int[matrix.length+5][matrix[0].length+5];

        int maxL=0;

        for (int i=1;i<=matrix.length;i++)
        {
            for (int j=1;j<=matrix[0].length;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    maxL=Math.max(maxL,dp[i][j]);
                }
            }
        }
        return maxL*maxL;
    }
}
/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
