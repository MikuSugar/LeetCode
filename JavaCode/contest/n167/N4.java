package JavaCode.contest.n167;

import java.util.*;

/**
 * author:fangjie
 * time:2019/12/15
 */
public class N4 {
    public int shortestPath(int[][] grid, int k) {
        int[][][] dp=new int[grid.length+5][grid[0].length+5][k+1];
        for (int[][] t:dp)for (int[] d:t)Arrays.fill(d,-1);
        dp[0][0][0]=0;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0,0});
        while (!queue.isEmpty())
        {
            int[] cur=queue.poll();
            for (int[] n:NEXTS)
            {
                int i=cur[0]+n[0];
                int j=cur[1]+n[1];
                if(i<0||j<0||i>=grid.length||j>=grid[0].length||cur[2]+grid[i][j]>k)continue;
                if(dp[i][j][cur[2]+grid[i][j]]==-1)
                {
                    dp[i][j][cur[2]+grid[i][j]]=dp[cur[0]][cur[1]][cur[2]]+1;
                    queue.add(new int[]{i,j,cur[2]+grid[i][j]});
                }
            }
        }
        int res=Integer.MAX_VALUE>>1;
        for (int i:dp[grid.length-1][grid[0].length-1])
        {
            if(i!=-1)res=Math.min(res,i);
        }
        return res==Integer.MAX_VALUE>>1?-1:res;
    }

    private final static int[][] NEXTS={{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
}
/*
给你一个 m * n 的网格，其中每个单元格不是 0（空）就是 1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。

如果您 最多 可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，并返回通过该路径所需的步数。如果找不到这样的路径，则返回 -1。



示例 1：

输入：
grid =
[[0,0,0],
 [1,1,0],
 [0,0,0],
 [0,1,1],
 [0,0,0]],
k = 1
输出：6
解释：
不消除任何障碍的最短路径是 10。
在位置 (3,2) 处消除一个障碍后的最短路径是 6 。该路径是 (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).


示例 2：

输入：
grid =
[[0,1,1],
 [1,1,1],
 [1,0,0]],
k = 1
输出：-1
解释：
我们至少需要消除两个障碍才能找到这样的道路。


提示：

grid.length == m
grid[0].length == n
1 <= m, n <= 40
1 <= k <= m*n
grid[i][j] == 0 or 1
grid[0][0] == grid[m-1][n-1] == 0
 */
