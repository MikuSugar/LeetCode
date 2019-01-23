package JavaCode.queue_stack.queue_and_bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    public static void main(String[] args) {
        char[][] grid={{'1','0','1','1','1'},{'1','0','1','0','1'},{'1','1','1','0','1'}};
        System.out.println(new NumIslands().new Solution().numIslands(grid));
    }
    class Solution {

        //坐标封装类
        class Ponit
        {
            public Ponit(int i,int j)
            {
                this.i=i;
                this.j=j;
            }
            int i,j;

        }
        public int numIslands(char[][] grid) {
            if(grid.length==0) return 0;
            int ans=0;
            Queue<Ponit> queue=new LinkedList<>();
            int book[][]=new int[grid.length][grid[0].length];

            for(int i=0;i<grid.length;i++)
                for(int j=0;j<grid[i].length;j++)
                {
                    if(grid[i][j]=='1'&&book[i][j]==0)
                    {
                        ans++;
                        if(ans==2)
                            System.out.println(i+" "+j);
                        queue.add(new Ponit(i,j));
                        book[i][j]=1;
                        while (!queue.isEmpty())
                        {
                            Ponit temp=queue.poll();
                            int ii=temp.i;
                            int jj=temp.j;
                            if(ii>0&&grid[ii-1][jj]=='1'&&book[ii-1][jj]==0)
                            {
                                queue.add(new Ponit(ii-1,jj));
                                book[ii-1][jj]=1;
                            }
                            if(jj>0&&grid[ii][jj-1]=='1'&&book[ii][jj-1]==0)
                            {
                                queue.add(new Ponit(ii,jj-1));
                                book[ii][jj-1]=1;
                            }
                            if(ii<grid.length-1&&grid[ii+1][jj]=='1'&&book[ii+1][jj]==0)
                            {
                                queue.add(new Ponit(ii+1,jj));
                                book[ii+1][jj]=1;
                            }
                            if(jj<grid[ii].length-1&&grid[ii][jj+1]=='1'&&book[ii][jj+1]==0)
                            {
                                queue.add(new Ponit(ii,jj+1));
                                book[ii][jj+1]=1;
                            }
                        }
                    }
                }
            return ans;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/872/
 * 岛屿的个数
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 */
