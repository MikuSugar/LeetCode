package JavaCode.random_records.N801_900;

import java.util.LinkedList;
import java.util.Queue;

public class N847_shortest_path_visiting_all_nodes {
    public int shortestPathLength(int[][] graph) {
        int len=graph.length;
        boolean[][] book=new boolean[len][1<<len];
        int k=(1<<len)-1;
        Queue<int[]> queue=new LinkedList<>();
        for (int i=0;i<len;i++)
        {
            queue.offer(new int[]{i,1<<i});
        }
        int step=0;
        while (!queue.isEmpty())
        {
            int size=queue.size();
            while (size-->0)
            {
                int[] node=queue.poll();
                if(k==node[1])return step;
                for (int next:graph[node[0]])
                {
                    int next_state=node[1]|(1<<next);
                    if(book[next][next_state])continue;
                    book[next][next_state]=true;
                    queue.offer(new int[]{next,next_state});
                }
            }
            step++;
        }
        return step;
    }
}
/**
 * 给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。
 *
 * graph.length = N，且只有节点 i 和 j 连通时，j != i 在列表 graph[i] 中恰好出现一次。
 *
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一个可能的路径为 [1,0,2,0,3]
 * 示例 2：
 *
 * 输入：[[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一个可能的路径为 [0,1,4,2,3]
 *
 *
 * 提示：
 *
 * 1 <= graph.length <= 12
 * 0 <= graph[i].length < graph.length
 */
