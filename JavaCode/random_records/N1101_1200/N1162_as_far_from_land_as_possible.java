package JavaCode.random_records.N1101_1200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author:fangjie
 * time:2020/3/29
 */
public class N1162_as_far_from_land_as_possible {
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        boolean[][] book=new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)queue.add(new int[]{i,j});
            }
        }

        int res=0;
        boolean isOK=false;
        while (!queue.isEmpty())
        {
            int size=queue.size();
            res++;
            while (size-->0)
            {
                int[] cur=queue.poll();
                for (int[] next:NEXTS)
                {
                    int i=next[0]+cur[0];
                    int j=next[1]+cur[1];
                    if(i<0||j<0||i>=grid.length||j>=grid[0].length||book[i][j]||grid[i][j]==1)continue;
                    queue.add(new int[]{i,j});
                    book[i][j]=true;
                    isOK=true;
                }
            }
        }
        return isOK?res-1:-1;
    }
    private static final int[][] NEXTS={{-1,0},{0,-1},{0,1},{1,0}};
}
/*
你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。

我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。

如果我们的地图上只有陆地或者海洋，请返回 -1。

 

示例 1：



输入：[[1,0,1],[0,0,0],[1,0,1]]
输出：2
解释：
海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
示例 2：



输入：[[1,0,0],[0,0,0],[0,0,0]]
输出：4
解释：
海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 

提示：

1 <= grid.length == grid[0].length <= 100
grid[i][j] 不是 0 就是 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */