package JavaCode.random_records.N401_500;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * author:fangjie
 * time:2019/10/9
 */
public class N407_trapping_rain_water_ii {

    public int trapRainWater(int[][] heightMap) {
        if(heightMap==null||heightMap.length==0||heightMap[0].length==0)return 0;

        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
        final int m=heightMap.length;
        final int n=heightMap[0].length;
        boolean[][] book=new boolean[m][n];
        for (int i=0;i<m;i++)
        {
            book[i][0]=true;
            book[i][n-1]=true;
            queue.add(new int[]{i,0,heightMap[i][0]});
            queue.add(new int[]{i,n-1,heightMap[i][n-1]});
        }
        for (int i=0;i<n;i++)
        {
            book[0][i]=true;
            book[m-1][i]=true;
            queue.add(new int[]{0,i,heightMap[0][i]});
            queue.add(new int[]{m-1,i,heightMap[m-1][i]});
        }

        int res=0;
        while (!queue.isEmpty())
        {
            int[] cur=queue.poll();
            for (int[] next:NEXTS)
            {
                int i=cur[0]+next[0];
                int j=cur[1]+next[1];
                if(i<0||j<0||i>=m||j>=n||book[i][j])continue;
                book[i][j]=true;
                res+=Math.max(0,cur[2]-heightMap[i][j]);
                queue.add(new int[]{i,j,Math.max(heightMap[i][j],cur[2])});
            }
        }
        return res;
    }
    final static int[][] NEXTS={{-1,0},{0,-1},{0,1},{1,0}};
}
/**
 * 给定一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 *
 *  
 *
 * 说明:
 *
 * m 和 n 都是小于110的整数。每一个单位的高度都大于 0 且小于 20000。
 *
 *  
 *
 * 示例：
 *
 * 给出如下 3x6 的高度图:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 *
 * 返回 4。
 *
 *
 * 如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。
 *
 *  
 *
 *
 *
 * 下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
