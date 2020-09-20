package JavaCode.contest.n207;

import utils.Parse;

import java.util.Arrays;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/9/20 10:14 上午
 */
public class N3 {

    public static void main(String[] args) {
        System.out.println(new N3().maxProductPath(Parse.parseToIntTwoArray("[[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]")));
    }

    public int maxProductPath(int[][] grid) {
        long[][] maxDp=new long[grid.length][grid[0].length];
        long[][] minDp=new long[grid.length][grid[0].length];
        maxDp[0][0]=minDp[0][0]=grid[0][0];
        for (int i=1;i<grid.length;i++){
            maxDp[i][0]=minDp[i][0]=maxDp[i-1][0]*grid[i][0];
        }
        for (int j=1;j<grid[0].length;j++){
            minDp[0][j]=maxDp[0][j]=minDp[0][j-1]*grid[0][j];
        }

        for (int i=1;i<grid.length;i++){
            for (int j=1;j<grid[0].length;j++)
            {
               long[] res=new long[]{
                       grid[i][j]*maxDp[i-1][j],
                       grid[i][j]*maxDp[i][j-1],
                       grid[i][j]*minDp[i-1][j],
                       grid[i][j]*minDp[i][j-1]
               };
               Arrays.sort(res);
               maxDp[i][j]=res[res.length-1];
               minDp[i][j]=res[0];
            }
        }

        for (int i=0;i<grid.length;i++){
            System.out.println(Arrays.toString(maxDp[i]));
        }
        System.out.println("==============");
        for (int i=0;i<grid.length;i++){
            System.out.println(Arrays.toString(minDp[i]));
        }

        if(maxDp[grid.length-1][grid[0].length-1]<0)return -1;

        return (int) (maxDp[grid.length-1][grid[0].length-1]%MOD);
    }

    private final static int MOD=(int) (1e9+7);
}
/*
给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。

在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。

返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为负数，则返回 -1 。

注意，取余是在得到最大积之后执行的。



示例 1：

输入：grid = [[-1,-2,-3],
             [-2,-3,-3],
             [-3,-3,-2]]
输出：-1
解释：从 (0, 0) 到 (2, 2) 的路径中无法得到非负积，所以返回 -1
示例 2：

输入：grid = [[1,-2,1],
             [1,-2,1],
             [3,-4,1]]
输出：8
解释：最大非负积对应的路径已经用粗体标出 (1 * 1 * -2 * -4 * 1 = 8)
示例 3：

输入：grid = [[1, 3],
             [0,-4]]
输出：0
解释：最大非负积对应的路径已经用粗体标出 (1 * 0 * -4 = 0)
示例 4：

输入：grid = [[ 1, 4,4,0],
             [-2, 0,0,1],
             [ 1,-1,1,1]]
输出：2
解释：最大非负积对应的路径已经用粗体标出 (1 * -2 * 1 * -1 * 1 * 1 = 2)


提示：

1 <= rows, cols <= 15
-4 <= grid[i][j] <= 4

 */
