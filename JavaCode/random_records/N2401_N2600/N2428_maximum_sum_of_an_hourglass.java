package JavaCode.random_records.N2401_N2600;

/**
 * @author mikusugar
 * @version 1.0, 2024/7/30 上午11:22
 * @description N2428_maximum_sum_of_an_hourglass
 */
public class N2428_maximum_sum_of_an_hourglass {
    public int maxSum(int[][] grid) {
        int maxSum = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                maxSum = Math.max(maxSum, getSum(i, j, grid));
            }
        }
        return maxSum;
    }

    private int getSum(int i, int j, int[][] grid) {
        return grid[i][j] +
                grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] +
                grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1];
    }
}
/*
给你一个大小为 m x n 的整数矩阵 grid 。

按以下形式将矩阵的一部分定义为一个 沙漏 ：


返回沙漏中元素的 最大 总和。

注意：沙漏无法旋转且必须整个包含在矩阵中。



示例 1：


输入：grid = [[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]
输出：30
解释：上图中的单元格表示元素总和最大的沙漏：6 + 2 + 1 + 2 + 9 + 2 + 8 = 30 。
示例 2：


输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
输出：35
解释：上图中的单元格表示元素总和最大的沙漏：1 + 2 + 3 + 5 + 7 + 8 + 9 = 35 。


提示：

m == grid.length
n == grid[i].length
3 <= m, n <= 150
0 <= grid[i][j] <= 10^6
 */
