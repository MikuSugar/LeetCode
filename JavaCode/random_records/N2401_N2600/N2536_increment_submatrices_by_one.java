package JavaCode.random_records.N2401_N2600;

/**
 * @author mikusugar
 * @version 1.0, 2023/4/4 17:27
 * @description N2536_increment_submatrices_by_one
 */
public class N2536_increment_submatrices_by_one {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        final int[][] sum = new int[n + 1][n + 1];
        final int[][] res = new int[n][n];
        for (int[] query : queries) {
            sum[query[0]][query[1]]++;
            sum[query[0]][query[3] + 1]--;
            sum[query[2] + 1][query[1]]--;
            sum[query[2] + 1][query[3] + 1]++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] += sum[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(sum[i], 0, res[i], 0, n);
        }

        return res;
    }
}
/*
给你一个正整数 n ，表示最初有一个 n x n 、下标从 0 开始的整数矩阵 mat ，矩阵中填满了 0 。

另给你一个二维整数数组 query 。针对每个查询 query[i] = [row1i, col1i, row2i, col2i] ，请你执行下述操作：

找出 左上角 为 (row1i, col1i) 且 右下角 为 (row2i, col2i) 的子矩阵，将子矩阵中的 每个元素 加 1 。也就是给所有满足 row1i <= x <= row2i 和 col1i <= y <= col2i 的 mat[x][y] 加 1 。
返回执行完所有操作后得到的矩阵 mat 。

 

示例 1：



输入：n = 3, queries = [[1,1,2,2],[0,0,1,1]]
输出：[[1,1,0],[1,2,1],[0,1,1]]
解释：上图所展示的分别是：初始矩阵、执行完第一个操作后的矩阵、执行完第二个操作后的矩阵。
- 第一个操作：将左上角为 (1, 1) 且右下角为 (2, 2) 的子矩阵中的每个元素加 1 。
- 第二个操作：将左上角为 (0, 0) 且右下角为 (1, 1) 的子矩阵中的每个元素加 1 。
示例 2：



输入：n = 2, queries = [[0,0,1,1]]
输出：[[1,1],[1,1]]
解释：上图所展示的分别是：初始矩阵、执行完第一个操作后的矩阵。
- 第一个操作：将矩阵中的每个元素加 1 。
 

提示：

1 <= n <= 500
1 <= queries.length <= 104
0 <= row1i <= row2i < n
0 <= col1i <= col2i < n

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/increment-submatrices-by-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
