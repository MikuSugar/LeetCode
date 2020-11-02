package JavaCode.contest.biweekly.biweekly_n3;


import java.util.LinkedList;
import java.util.Queue;

public class N4 {

    public int maximumMinimumPath(int[][] A) {
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0,A[0][0]});
        int[][] dp=new int[A.length][A[0].length];
        dp[0][0]=A[0][0];
        while (!queue.isEmpty())
        {
            int[] next = queue.poll();
            for (int k=0;k<4;k++)
            {
                int i=next[0]+cul[k];
                int j=next[1]+row[k];
                if(i<0||j<0||i>=A.length||j>=A[0].length)continue;
                int min = Math.min(next[2], A[i][j]);
                if(min>dp[i][j])
                {
                    dp[i][j]=min;
                    queue.add(new int[]{i,j,min});
                }
            }
        }
        return dp[A.length-1][A[0].length-1];
    }

    private static int[] cul={-1,0,0,1};
    private static int[] row={0,-1,1,0};
}
/**
 *给你一个 R 行 C 列的整数矩阵 A。矩阵上的路径从 [0,0] 开始，在 [R-1,C-1] 结束。
 *
 * 路径沿四个基本方向（上、下、左、右）展开，从一个已访问单元格移动到任一相邻的未访问单元格。
 *
 * 路径的得分是该路径上的 最小 值。例如，路径 8 →  4 →  5 →  9 的值为 4 。
 *
 * 找出所有路径中得分 最高 的那条路径，返回其 得分。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[5,4,5],[1,2,6],[7,4,6]]
 * 输出：4
 * 解释：
 * 得分最高的路径用黄色突出显示。
 * 示例 2：
 *
 *
 *
 * 输入：[[2,2,1,2,2,2],[1,2,2,2,1,2]]
 * 输出：2
 * 示例 3：
 *
 *
 *
 * 输入：[[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= R, C <= 100
 * 0 <= A[i][j] <= 10^9
 */
