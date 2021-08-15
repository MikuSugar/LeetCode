package JavaCode.contest.weekly.n201_300.n254;

import utils.Parse;

import java.util.Arrays;

/**
 * @author mikusugar
 */
public class N4 {
    public static void main(String[] args) {
        System.out.println(new N4().latestDayToCross(
                2,2,
                Parse.parseToIntTwoArray("[[1,1],[1,2],[2,1],[2,2]]")
        ));
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int[][] book = new int[row+2][col+2];

        for (int i=0;i<cells.length;i++){
            book[cells[i][0]][cells[i][1]]=i+1;
        }
        showArray(book);

        int[][] dp = new int[row+2][col+2];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        int res = 0;
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<=col;j++){
                help(dp[i][j-1]+1,i,j-1,dp,book);
                help(dp[i-1][j]+1,i-1,j,dp,book);
            }
            for (int j=col;j>=1;j--){
                help(dp[i][j+1]+1,i,j+1,dp,book);
            }
        }
        showArray(dp);
        for (int i=1;i<=col;i++)res=Math.max(res,dp[row][i]);
        return res;
    }

    private void help(int d, int i, int j, int[][] dp, int[][] book) {
        if(book[i][j]>d)dp[i][j]=Math.max(d,dp[i][j]);
        else dp[i][j] = book[i][j] - 1;
    }
    private void showArray(int[][] array){
        System.out.println();
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}
/*
给你一个下标从 1 开始的二进制矩阵，其中 0 表示陆地，1 表示水域。同时给你 row 和 col 分别表示矩阵中行和列的数目。

一开始在第 0 天，整个 矩阵都是 陆地 。但每一天都会有一块新陆地被 水 淹没变成水域。给你一个下标从 1 开始的二维数组 cells ，其中 cells[i] = [ri, ci] 表示在第 i 天，第 ri 行 ci 列（下标都是从 1 开始）的陆地会变成 水域 （也就是 0 变成 1 ）。

你想知道从矩阵最 上面 一行走到最 下面 一行，且只经过陆地格子的 最后一天 是哪一天。你可以从最上面一行的 任意 格子出发，到达最下面一行的 任意 格子。你只能沿着 四个 基本方向移动（也就是上下左右）。

请返回只经过陆地格子能从最 上面 一行走到最 下面 一行的 最后一天 。



示例 1：


输入：row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
输出：2
解释：上图描述了矩阵从第 0 天开始是如何变化的。
可以从最上面一行到最下面一行的最后一天是第 2 天。
示例 2：


输入：row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]
输出：1
解释：上图描述了矩阵从第 0 天开始是如何变化的。
可以从最上面一行到最下面一行的最后一天是第 1 天。
示例 3：


输入：row = 3, col = 3, cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]
输出：3
解释：上图描述了矩阵从第 0 天开始是如何变化的。
可以从最上面一行到最下面一行的最后一天是第 3 天。


提示：

2 <= row, col <= 2 * 104
4 <= row * col <= 2 * 104
cells.length == row * col
1 <= ri <= row
1 <= ci <= col
cells 中的所有格子坐标都是 唯一 的。
 */
