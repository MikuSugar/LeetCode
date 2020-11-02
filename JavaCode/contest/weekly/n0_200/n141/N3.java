package JavaCode.contest.weekly.n0_200.n141;

import java.util.LinkedList;
import java.util.Queue;

public class N3 {
    private static int[] row={-1,-1,-1,0,0,1,1,1};
    private static int[] cul={-1,0,1,-1,1,-1,0,1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        if(grid[0][0]==1)return -1;
        if (grid.length==1&&grid[0].length==1)return 1;
        queue.add(new int[]{0,0});
        int res=0;
        boolean[][] book=new boolean[grid.length][grid[0].length];
        while (!queue.isEmpty())
        {
            int size=queue.size();
            res++;
            for (int i=0;i<size;i++)
            {
                int[] poll = queue.poll();
                int x,y;
                for (int k=0;k<8;k++)
                {
                    x=poll[0]+row[k];
                    y=poll[1]+cul[k];
                    if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]==1||book[x][y])continue;
                    if(x==grid.length-1&&y==grid[0].length-1)return res+1;
                    queue.add(new int[]{x,y});
                    book[x][y]=true;
                }
            }
        }
        return -1;
    }
}
/**
 *在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 *
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 *
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[0,1],[1,0]]
 *
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：[[0,0,0],[1,1,0],[1,1,0]]
 *
 * 输出：4
 *
 *
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 */
