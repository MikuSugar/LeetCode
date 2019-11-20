package JavaCode.random_records.N901_1000;

/**
 * author:fangjie
 * time:2019/11/20
 */
public class N980_unique_paths_iii {
    public int uniquePathsIII(int[][] grid) {
        int[] start=new int[2];
        int k=init(start,grid);
        return dfs(start[0],start[1],k,grid,new boolean[grid.length][grid[0].length]);
    }

    private int dfs(int i, int j, int k, int[][] grid, boolean[][] book) {
        book[i][j]=true;
        int res=0;
        for (int[] next:NEXTS)
        {
            int ii=i+next[0];
            int jj=j+next[1];
            if(ii<0||jj<0||ii>=grid.length||jj>=grid[0].length||grid[ii][jj]==-1||book[ii][jj])continue;
            if(k==0) res+=grid[ii][jj]==2?1:0;
            else if(grid[ii][jj]==2)continue;
            else res+=dfs(ii,jj,k-1,grid,book);
        }
        book[i][j]=false;
        return res;
    }

    private final static int[][] NEXTS={{-1,0},{0,1},{0,-1},{1,0}};
    private int init(int[] start,int[][] grid) {
        int res=0;
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    start[0]=i;
                    start[1]=j;
                }
                else if(grid[i][j]==0)res++;
            }
        }
        return res;
    }
}
/*
在二维网格 grid 上，有 4 种类型的方格：

1 表示起始方格。且只有一个起始方格。
2 表示结束方格，且只有一个结束方格。
0 表示我们可以走过的空方格。
-1 表示我们无法跨越的障碍。
返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
示例 1：
输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
输出：2
解释：我们有以下两条路径：
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
示例 2：
输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
输出：4
解释：我们有以下四条路径：
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
示例 3：
输入：[[0,1],[2,0]]
输出：0
解释：
没有一条路能完全穿过每一个空的方格一次。
请注意，起始和结束方格可以位于网格中的任意位置。
提示：
1 <= grid.length * grid[0].length <= 20
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
