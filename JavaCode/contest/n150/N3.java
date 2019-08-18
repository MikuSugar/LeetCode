package JavaCode.contest.n150;


import java.util.LinkedList;
import java.util.Queue;

public class N3 {
    public int maxDistance(int[][] grid) {
        int[][] book=new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    Queue<int[]> queue=new LinkedList<>();
                    queue.add(new int[]{i,j});
                    int level=0;
                    boolean[][] visted=new boolean[grid.length][grid[0].length];
                    visted[i][j]=true;
                    while (!queue.isEmpty())
                    {
                        level++;
                        int size = queue.size();
                        while (size-->0)
                        {
                            int[] poll = queue.poll();
                            for (int[] n:next)
                            {

                                int ii=poll[0]+n[0];
                                int jj=poll[1]+n[1];
                                if(ii<0||jj<0||ii>=grid.length||jj>=grid[0].length||visted[ii][jj])continue;
                                if(grid[ii][jj]==0&&(book[ii][jj]==0||book[ii][jj]>=level))
                                {
                                    book[ii][jj]=level;
                                    queue.add(new int[]{ii,jj});
                                }
                                visted[ii][jj]=true;
                            }
                        }
                    }
                }
            }
        }
        int res=0;
        for (int[] b:book)
        {
            for (int i:b)
            {
                res=Math.max(res,i);
            }
        }
        return res==0?-1:res;
    }
    private static final int[][] next={{-1,0},{0,-1},{0,1},{1,0}};

}
/**
 *你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，
 * 你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 * 提示：
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 */
