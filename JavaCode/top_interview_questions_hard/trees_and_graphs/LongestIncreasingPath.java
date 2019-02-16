package JavaCode.top_interview_questions_hard.trees_and_graphs;

public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0)return 0;
        int max=0;
        int[][] dp=new int[matrix.length][matrix[0].length];
        boolean[][] book=new boolean[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                max=Math.max(max,dfs(i,j,matrix,dp,book));
            }
        }
        return max;
    }

    private int[] row={-1,0,0,1};
    private int[] cul={0,-1,1,0};
    private int dfs(int i,int j,int[][] matrix,int dp[][],boolean[][] book)
    {
        if(book[i][j])
        {
            return dp[i][j];
        }
        dp[i][j]=1;
        for (int k=0;k<4;k++)
        {
            int ii=i+row[k];
            int jj=j+cul[k];

            if(ii>=0&&ii<matrix.length&&jj>=0&&jj<matrix[0].length&&matrix[ii][jj]<matrix[i][j])
            {
                dp[i][j]=Math.max(dp[i][j],dfs(ii,jj,matrix,dp,book)+1);
            }
        }
        book[i][j]=true;
        return dp[i][j];
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/144/
 * 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 示例 1:
 *
 * 输入: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 *
 * 输入: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 */
