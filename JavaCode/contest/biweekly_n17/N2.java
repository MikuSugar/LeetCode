package JavaCode.contest.biweekly_n17;

/**
 * author:fangjie
 * time:2020/1/11
 */
public class N2 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] res=new int[mat.length][mat[0].length];
        int[][] sum=new int[mat.length+1][mat[0].length+1];
        for (int i=0;i<mat.length;i++)
        {
            for (int j=0;j<mat[0].length;j++)
            {
                sum[i+1][j+1]=sum[i+1][j]+sum[i][j+1]+mat[i][j]-sum[i][j];
            }
        }

        for (int i=0;i<mat.length;i++)
        {
            for (int j=0;j<mat[0].length;j++)
            {
                res[i][j]=getSum(i,j,mat,K,sum);
            }
        }
        return res;
    }

    private int getSum(int i, int j, int[][] mat, int k, int[][] sum) {
        int i1=Math.max(0,i-k);
        int i2=Math.min(i+k,mat.length-1);
        int j1=Math.max(0,j-k);
        int j2=Math.min(j+k,mat[0].length-1);
        return sum[i2+1][j2+1]+sum[i1][j1]-sum[i2+1][j1]-sum[i1][j2+1];
    }
}
/*
给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：

i - K <= r <= i + K, j - K <= c <= j + K
(r, c) 在矩阵内。


示例 1：

输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
输出：[[12,21,16],[27,45,33],[24,39,28]]
示例 2：

输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
输出：[[45,45,45],[45,45,45],[45,45,45]]


提示：

m == mat.length
n == mat[i].length
1 <= m, n, K <= 100
1 <= mat[i][j] <= 100
 */
