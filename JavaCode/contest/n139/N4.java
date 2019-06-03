package JavaCode.contest.n139;

import java.util.HashMap;
import java.util.Map;

public class N4 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int res = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            long[] sum = new long[matrix[0].length];
            for (int j = i; j < matrix.length; j++)
            {
                for (int k = 0; k < matrix[0].length; k++)
                {
                    sum[k] += matrix[j][k];
                }

                long s = 0;
                Map<Long, Long> map = new HashMap<>();
                map.put(0l, 1l);
                for (int k = 0; k < matrix[0].length; k++)
                {
                    s += sum[k];
                    long dis = s - target;
                    res += map.getOrDefault(dis, 0l);
                    map.put(s, map.getOrDefault(s, 0l) + 1l);
                }
            }
        }
        return res;
    }
}
/**
 *给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 *
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 *
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * 输出：4
 * 解释：四个只含 0 的 1x1 子矩阵。
 * 示例 2：
 *
 * 输入：matrix = [[1,-1],[-1,1]], target = 0
 * 输出：5
 * 解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
 *
 *
 * 提示：
 *
 * 1 <= matrix.length <= 300
 * 1 <= matrix[0].length <= 300
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 */
