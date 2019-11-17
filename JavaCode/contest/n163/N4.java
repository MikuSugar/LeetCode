package JavaCode.contest.n163;

import java.util.*;

/**
 * author:fangjie
 * time:2019/11/17
 */
public class N4 {
    public int minPushBox(char[][] grid) {
        Set<String> book=new HashSet<>();
        Queue<int[]> queue=new LinkedList<>();
        int[] start=new int[4];
        int[] tar=new int[2];
        init(start,tar,grid);

        queue.add(start);
        book.add(Arrays.toString(start));
        int res=0;
        while (!queue.isEmpty())
        {
            res++;
            int size=queue.size();
            while (size-->0)
            {
                int[] cur=queue.poll();
                boolean[][] can=new boolean[grid.length][grid[0].length];
                can[cur[0]][cur[1]]=can[cur[2]][cur[3]]=true;
                dfs(grid,can,cur[2],cur[3]);
                for (int[] next:NEXTS)
                {
                    int bi=cur[0]+next[0];
                    int bj=cur[1]+next[1];
                    int ti=cur[0]-next[0];
                    int tj=cur[1]-next[1];
                    if(bi<0||bj<0||ti<0||tj<0||
                    bi>=grid.length||ti>=grid.length||bj>=grid[0].length||tj>=grid[0].length||
                    !can[ti][tj]||grid[bi][bj]=='#')continue;
                    if(bi==tar[0]&&bj==tar[1])return res;
                    int[] nextP=new int[]{bi,bj,ti,tj};
                    String key=Arrays.toString(nextP);
                    if(book.contains(key))continue;
                    book.add(key);
                    queue.add(nextP);
                }
            }
        }

        return -1;
    }

    private void dfs(char[][] grid, boolean[][] used, int si, int sj) {
        for (int[] next:NEXTS)
        {
            int i=si+next[0];
            int j=sj+next[1];
            if(i<0||j<0||i>=grid.length||j>=grid[0].length||used[i][j]||grid[i][j]=='#')continue;
            used[i][j]=true;
            dfs(grid,used,i,j);
        }
    }

    private void init(int[] start, int[] tar, char[][] grid) {
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='B')
                {
                    start[0]=i;
                    start[1]=j;
                }
                else if(grid[i][j]=='S')
                {
                    start[2]=i;
                    start[3]=j;
                }
                else if(grid[i][j]=='T')
                {
                    tar[0]=i;
                    tar[1]=j;
                }
            }
        }
    }

    private final static int[][] NEXTS={{-1,0},{0,-1},{0,1},{1,0}};
}
/*
「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。

游戏地图用大小为 n * m 的网格 grid 表示，其中每个元素可以是墙、地板或者是箱子。

现在你将作为玩家参与游戏，按规则将箱子 'B' 移动到目标位置 'T' ：

玩家用字符 'S' 表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。
地板用字符 '.' 表示，意味着可以自由行走。
墙用字符 '#' 表示，意味着障碍物，不能通行。
箱子仅有一个，用字符 'B' 表示。相应地，网格上有一个目标位置 'T'。
玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。
玩家无法越过箱子。
返回将箱子推到目标位置的最小 推动 次数，如果无法做到，请返回 -1。

示例 1：



输入：grid = [["#","#","#","#","#","#"],
             ["#","T","#","#","#","#"],
             ["#",".",".","B",".","#"],
             ["#",".","#","#",".","#"],
             ["#",".",".",".","S","#"],
             ["#","#","#","#","#","#"]]
输出：3
解释：我们只需要返回推箱子的次数。
示例 2：

输入：grid = [["#","#","#","#","#","#"],
             ["#","T","#","#","#","#"],
             ["#",".",".","B",".","#"],
             ["#","#","#","#",".","#"],
             ["#",".",".",".","S","#"],
             ["#","#","#","#","#","#"]]
输出：-1
示例 3：

输入：grid = [["#","#","#","#","#","#"],
             ["#","T",".",".","#","#"],
             ["#",".","#","B",".","#"],
             ["#",".",".",".",".","#"],
             ["#",".",".",".","S","#"],
             ["#","#","#","#","#","#"]]
输出：5
解释：向下、向左、向左、向上再向上。
示例 4：

输入：grid = [["#","#","#","#","#","#","#"],
             ["#","S","#",".","B","T","#"],
             ["#","#","#","#","#","#","#"]]
输出：-1


提示：

1 <= grid.length <= 20
1 <= grid[i].length <= 20
grid 仅包含字符 '.', '#',  'S' , 'T', 以及 'B'。
grid 中 'S', 'B' 和 'T' 各只能出现一个。
 */
