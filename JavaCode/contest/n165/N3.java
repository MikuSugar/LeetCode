package JavaCode.contest.n165;

/**
 * author:fangjie
 * time:2019/12/1
 */
public class N3 {
    public int countSquares(int[][] matrix) {
        int res=0;
        for (int i=1;i<=matrix.length;i++)
        {
            int t=slove(i,matrix);
            if(t==0)break;
            res+=t;
        }
        return res;
    }

    private int slove(int len, int[][] matrix) {
        int res=0;
        for (int i=0;i<matrix.length-len+1;i++)
        {
            for (int j=0;j<matrix[0].length-len+1;j++)
            {
                res+=check(i,j,matrix,len);
            }
        }
        return res;
    }

    private int check(int ix, int jy, int[][] matrix, int len) {
        for (int i=ix;i<ix+len;i++)
        {
            for (int j=jy;j<jy+len;j++)
            {
                if(matrix[i][j]==0)return 0;
            }
        }
        return 1;
    }
}
/*
给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。



示例 1：

输入：matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
输出：15
解释：
边长为 1 的正方形有 10 个。
边长为 2 的正方形有 4 个。
边长为 3 的正方形有 1 个。
正方形的总数 = 10 + 4 + 1 = 15.
示例 2：

输入：matrix =
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
输出：7
解释：
边长为 1 的正方形有 6 个。
边长为 2 的正方形有 1 个。
正方形的总数 = 6 + 1 = 7.


提示：

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1

 */
