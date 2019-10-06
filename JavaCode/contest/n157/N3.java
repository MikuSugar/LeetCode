package JavaCode.contest.n157;

/**
 * author:fangjie
 * time:2019/10/6
 */
public class N3 {

    final static int[][] nexts={{-1,0},{0,-1},{0,1},{1,0}};
    private int res;
    public int getMaximumGold(int[][] grid) {
        boolean[][] book=new boolean[grid.length][grid[0].length];
        res=0;
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]!=0)
                {
                    dfs(i,j,grid,book,0);
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] book, int  sum) {
        sum+=grid[i][j];
        book[i][j]=true;
        res=Math.max(sum,res);
        for (int[] next:nexts)
        {
            int ii=i+next[0];
            int jj=j+next[1];
            if(ii<0||jj<0||ii>=grid.length||jj>=grid[0].length||book[ii][jj]||grid[ii][jj]==0)continue;
            dfs(ii,jj,grid,book,sum);
        }
        book[i][j]=false;
    }
}
/**
 *你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 *
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 *
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
 * 输出：24
 * 解释：
 * [[0,6,0],
 *  [5,8,7],
 *  [0,9,0]]
 * 一种收集最多黄金的路线是：9 -> 8 -> 7。
 * 示例 2：
 *
 * 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * 输出：28
 * 解释：
 * [[1,0,7],
 *  [2,0,6],
 *  [3,4,5],
 *  [0,3,0],
 *  [9,0,20]]
 * 一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
 *
 *
 * 提示：
 *
 * 1 <= grid.length, grid[i].length <= 15
 * 0 <= grid[i][j] <= 100
 * 最多 25 个单元格中有黄金。
 */
