package JavaCode.contest.weekly.n0_200.n134;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class N4 {

    private static int[][] ds={{-1,0},{0,-1},{0,1},{1,0}};
    private final static int MAX=1_000_000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if(source==null||source.length==0||target==null||target.length==0)return false;
        if (blocked==null||blocked.length==0)return true;
        return help(blocked, source,target)&&help(blocked,target,source);
    }

    private boolean help(int[][] blocked, int[] source,int[] target) {
        Set<String> set=new HashSet<>();
        for (int[] b:blocked)
        {
            set.add(getKey(b));
        }

        Queue<int[]> queue=new LinkedList<>();
        queue.add(source);
        set.add(getKey(source));

        for (int i=0;i<100;i++)
        {
            if(queue.isEmpty())return false;
            int len=queue.size();
            for (int j=0;j<len;j++)
            {
                int[] cur=queue.poll();
                for (int[] d:ds)
                {
                    int ii=cur[0]+d[0];
                    int jj=cur[1]+d[1];
                    String key = ii+","+jj;
                    if(ii>0&&ii<MAX&&jj>0&&jj<MAX&&!set.contains(key))
                    {
                        if(ii==target[0]&&jj==target[1])return true;
                        set.add(key);
                        queue.add(new int[]{ii,jj});
                    }
                }
            }
        }
        return true;
    }

    private String getKey(int[] a) {
        return a[0]+","+a[1];
    }

}
/**
 *5042. 逃离大迷宫  显示英文描述
 * 用户通过次数 15
 * 用户尝试次数 36
 * 通过次数 16
 * 提交次数 58
 * 题目难度 Hard
 * 在一个 10^6 x 10^6 的网格中，每个网格块的坐标为 (x, y)，其中 0 <= x, y < 10^6。
 *
 * 我们从源方格 source 开始出发，意图赶往目标方格 target。每次移动，我们都可以走到网格中在四个方向上相邻的方格，只要该方格不在给出的封锁列表 blocked 上。
 *
 * 只有在可以通过一系列的移动到达目标方格时才返回 true。否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * 输出：false
 * 解释：
 * 从源方格无法到达目标方格，因为我们无法在网格中移动。
 * 示例 2：
 *
 * 输入：blocked = [], source = [0,0], target = [999999,999999]
 * 输出：true
 * 解释：
 * 因为没有方格被封锁，所以一定可以到达目标方格。
 *
 *
 * 提示：
 *
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= blocked[i][j] < 10^6
 * source.length == target.length == 2
 * 0 <= source[i][j], target[i][j] < 10^6
 * source != target
 */
