package JavaCode.contest.n167;

/**
 * author:fangjie
 * time:2019/12/15
 */
public class N3 {
    public int maxSideLength(int[][] mat, int threshold) {
        int[][] sum=new int[mat.length][mat[0].length+1];
        for (int i=0;i<mat.length;i++)
        {
            for (int j=0;j<mat[0].length;j++)
            {
                sum[i][j+1]=sum[i][j]+mat[i][j];
            }
        }
        int res=0;
        for (int i=0;i<mat.length;i++)
        {
            for (int j=0;j<mat[0].length;j++)
            {
                res=Math.max(res,slove(i,j,sum,threshold));
            }
        }
        return res;
    }

    private int slove(int i, int j, int[][] sum, int threshold) {
        int res=0;
        for (int k=0;k+i<sum.length&&k+j<sum[0].length-1;k++)
        {
            int temp=0;
            for (int ii=i;ii<=k+i;ii++)
            {
                temp+=sum[ii][k+j+1]-sum[ii][j];
            }
            if(temp<=threshold)
            {
                res=Math.max(res,k+1);
            }
        }
        return res;
    }
}
/*
给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。

请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。


示例 1：



输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
输出：2
解释：总和小于 4 的正方形的最大边长为 2，如图所示。
示例 2：

输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
输出：0
示例 3：

输入：mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
输出：3
示例 4：

输入：mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold = 40184
输出：2


提示：

1 <= m, n <= 300
m == mat.length
n == mat[i].length
0 <= mat[i][j] <= 10000
0 <= threshold <= 10^5
 */
