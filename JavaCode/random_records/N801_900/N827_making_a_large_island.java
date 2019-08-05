package JavaCode.random_records.N801_900;

import java.util.*;

public class N827_making_a_large_island {

    private final static int[][] nexts={{-1,0},{0,-1},{0,1},{1,0}};
    private int cnt;
    private int num;
    public int largestIsland(int[][] grid) {
        num=0;
        int res=0;
        boolean[][] book=new boolean[grid.length][grid[0].length];
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid.length;j++)
            {
                if(grid[i][j]!=0&&!book[i][j])
                {
                    cnt=0;
                    num++;
                    dfs(grid,book,i,j);
                    map.put(num,cnt);
                }
            }
        }
        boolean flag=true;
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid.length;j++)
            {
                if(!book[i][j])
                {
                    flag=false;
                    int sum=1;
                    int pre=-1;
                    Set<Integer> used=new HashSet<>();
                    for (int[] next:nexts)
                    {
                        int ii=i+next[0];
                        int jj=j+next[1];
                        if(ii<0||jj<0||ii>=grid.length||jj>=grid[0].length)continue;
                        if(grid[ii][jj]!=pre)
                        {
                            if(!used.contains(grid[ii][jj]))
                            {
                                sum+=map.get(grid[ii][jj]);
                                used.add(grid[ii][jj]);
                            }
                        }
                    }
                    res=Math.max(res,sum);
                }
            }
        }
        if(flag)return grid.length*grid[0].length;
        return res;

    }

    private void dfs(int[][] grid, boolean[][] visted, int i, int j) {
        if(grid[i][j]==0)return;
        cnt++;
        visted[i][j]=true;
        for (int[] next:nexts)
        {
            int ii=i+next[0];
            int jj=j+next[1];
            if(ii<0||jj<0||ii>=grid.length||jj>=grid[0].length||visted[ii][jj])continue;
            dfs(grid,visted,ii,jj);
        }
        grid[i][j]=num;
    }
}
/**
 * 在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。
 *
 * 进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）
 *
 * 示例 1:
 *
 * 输入: [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * 示例 2:
 *
 * 输入: [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * 示例 3:
 *
 * 输入: [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 * 说明:
 *
 * 1 <= grid.length = grid[0].length <= 50
 * 0 <= grid[i][j] <= 1
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/making-a-large-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
