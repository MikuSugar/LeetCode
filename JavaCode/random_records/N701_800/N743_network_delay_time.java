package JavaCode.random_records.N701_800;

import java.util.*;

/**
 * author:fangjie
 * time:2019/11/7
 */
public class N743_network_delay_time {
    public int networkDelayTime(int[][] times, int N, int K) {
        List<int[]>[] graphs=new List[N+1];
        for (int i=0;i<graphs.length;i++)graphs[i]=new ArrayList<>();
        for (int[] time:times) graphs[time[0]].add(new int[]{time[1],time[2]});
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(o->o[0]));
        boolean[] book=new boolean[N+1];
        int res=0;
        queue.add(new int[]{0,K});
        while (!queue.isEmpty())
        {
            int[] cur=queue.poll();
            if(book[cur[1]])continue;
            book[cur[1]]=true;
            res=cur[0];
            for (int[] nexts:graphs[cur[1]])
            {
                queue.add(new int[]{res+nexts[1],nexts[0]});
            }
            N--;
        }
        return N==0?res:-1;
    }
}
/*
有 N 个网络节点，标记为 1 到 N。

给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。

现在，我们向当前的节点 K 发送了一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。

注意:

N 的范围在 [1, 100] 之间。
K 的范围在 [1, N] 之间。
times 的长度在 [1, 6000] 之间。
所有的边 times[i] = (u, v, w) 都有 1 <= u, v <= N 且 0 <= w <= 100。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/network-delay-time
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
