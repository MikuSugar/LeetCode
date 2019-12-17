package JavaCode.random_records.N1_100;

/**
 * author:fangjie
 * time:2019/12/17
 */
public class N85_maximal_rectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0)return 0;
        int res=0;
        int[][] dp=new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)continue;
                dp[i][j]=j==0?1:dp[i][j-1]+1;
                int w=dp[i][j];
                for (int k=i;k>=0;k--)
                {
                    w=Math.min(w,dp[k][j]);
                    res=Math.max(res,w*(i-k+1));
                }
            }
        }
        return res;
    }
}
/*
给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

示例:

输入:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-rectangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
