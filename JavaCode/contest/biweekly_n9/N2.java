package JavaCode.contest.biweekly_n9;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author:fangjie
 * time:2019/9/23
 */
public class N2 {

    public int minKnightMoves(int x, int y) {
        if(x==0&&y==0)return 0;
        boolean[][] book=new boolean[605][605];
        int res=0;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        book[300][300]=true;
        while (!queue.isEmpty())
        {
            int size=queue.size();
            res++;
            while (size-->0)
            {
                int[] cur=queue.poll();
                for (int[] next:nexts)
                {
                    int xx=cur[0]+next[0];
                    int yy=cur[1]+next[1];
                    if(book[xx+300][yy+300])continue;
                    book[xx+300][yy+300]=true;
                    if(xx==x&&yy==y)return res;
                    queue.add(new int[]{xx,yy});
                }
            }
        }
        return -1;
    }

    private final static int[][] nexts={{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
}
/**
 * 一个坐标可以从 -infinity 延伸到 +infinity 的 无限大的 棋盘上，你的 骑士 驻扎在坐标为 [0, 0] 的方格里。
 *
 * 骑士的走法和中国象棋中的马相似，走 “日” 字：即先向左（或右）走 1 格，再向上（或下）走 2 格；或先向左（或右）走 2 格，再向上（或下）走 1 格。
 *
 * 每次移动，他都可以按图示八个方向之一前进。
 *
 *
 *
 * 现在，骑士需要前去征服坐标为 [x, y] 的部落，请你为他规划路线。
 *
 * 最后返回所需的最小移动次数即可。本题确保答案是一定存在的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2, y = 1
 * 输出：1
 * 解释：[0, 0] → [2, 1]
 * 示例 2：
 *
 * 输入：x = 5, y = 5
 * 输出：4
 * 解释：[0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 *
 *
 * 提示：
 *
 * |x| + |y| <= 300
 */
