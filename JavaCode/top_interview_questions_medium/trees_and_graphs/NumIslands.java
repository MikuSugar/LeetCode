package JavaCode.top_interview_questions_medium.trees_and_graphs;

public class NumIslands
{
    class Solution
    {
        private char[][] grid;
        private int[][] book;
        public int numIslands(char[][] grid)
        {
            if(grid.length==0) return 0;
            this.grid=grid;
            this.book=new int[grid.length][grid[0].length];

            int cnt=0;
            for(int i=0;i<grid.length;i++)
            {
                for(int j=0;j<grid[i].length;j++)
                {
                    if(grid[i][j]=='1'&&book[i][j]==0)
                    {
                        cnt++;
                        dfs(i,j);
                    }
                }
            }
            return cnt;
        }

        void dfs(int x,int y)
        {
            if(x<0||y<0||y>=grid[0].length||x>=grid.length) return;
            if(grid[x][y]=='0'||book[x][y]==1) return;
            book[x][y]=1;
            dfs(x+1,y);
            dfs(x,y+1);
            dfs(x,y-1);
            dfs(x-1,y);
        }

    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/90/
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 */
