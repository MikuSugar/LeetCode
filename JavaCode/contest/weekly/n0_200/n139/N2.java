package JavaCode.contest.weekly.n0_200.n139;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N2 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String,Integer> map=new HashMap<>();
        for (int[] m:matrix)
        {
            String key=Arrays.toString(m);
            map.put(key,map.getOrDefault(key,0)+1);
            for (int i=0;i<m.length;i++)
            {
                m[i]=m[i]==0?1:0;
            }
            key=Arrays.toString(m);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        int res=0;
        for (int i:map.values())
        {
            res=Math.max(res,i);
        }
        return res;
    }
}
/**
 *给定由若干 0 和 1 组成的矩阵 matrix，从中选出任意数量的列并翻转其上的 每个 单元格。翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。
 *
 * 返回经过一些翻转后，行上所有值都相等的最大行数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[0,1],[1,1]]
 * 输出：1
 * 解释：不进行翻转，有 1 行所有值都相等。
 * 示例 2：
 *
 * 输入：[[0,1],[1,0]]
 * 输出：2
 * 解释：翻转第一列的值之后，这两行都由相等的值组成。
 * 示例 3：
 *
 * 输入：[[0,0,0],[0,0,1],[1,1,0]]
 * 输出：2
 * 解释：翻转前两列的值之后，后两行由相等的值组成。
 *
 *
 * 提示：
 *
 * 1 <= matrix.length <= 300
 * 1 <= matrix[i].length <= 300
 * 所有 matrix[i].length 都相等
 * matrix[i][j] 为 0 或 1
 */
