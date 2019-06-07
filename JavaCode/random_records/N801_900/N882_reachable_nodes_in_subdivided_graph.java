package JavaCode.random_records.N801_900;

import java.util.Arrays;
import java.util.PriorityQueue;

public class N882_reachable_nodes_in_subdivided_graph {

    public int reachableNodes(int[][] edges, int M, int N) {
        int[][] m=new int[N][N];
        for (int i=0;i<N;i++)
        {
            Arrays.fill(m[i],-1);
        }

        for (int[] edge:edges)
        {
            m[edge[0]][edge[1]]=edge[2];
            m[edge[1]][edge[0]]=edge[2];
        }

        int res=0;
        boolean[] book=new boolean[N];
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->{return b[1]-a[1];});
        queue.add(new int[]{0,M});
        while (!queue.isEmpty())
        {
            int[] cur = queue.poll();
            int node = cur[0];
            int step = cur[1];
            if (book[node]) continue;
            book[node] = true;
            res++;
            for (int i = 0; i < N; i++){
                int cost = m[node][i] + 1;
                if (cost > 0){
                    if (step >= cost && !book[i]){
                        queue.offer(new int[]{i, step - cost});
                    }
                    int reach = Math.min(step, cost - 1);
                    res += reach;
                    m[i][node] -= reach;
                }
            }
        }
        return res;
    }
}
/**
 * 从具有 0 到 N-1 的结点的无向图（“原始图”）开始，对一些边进行细分。
 *
 * 该图给出如下：edges[k] 是整数对 (i, j, n) 组成的列表，使 (i, j) 是原始图的边。
 *
 * n 是该边上新结点的总数
 *
 * 然后，将边 (i, j) 从原始图中删除，将 n 个新结点 (x_1, x_2, ..., x_n) 添加到原始图中，
 *
 * 将 n+1 条新边 (i, x_1), (x_1, x_2), (x_2, x_3), ..., (x_{n-1}, x_n), (x_n, j) 添加到原始图中。
 *
 * 现在，你将从原始图中的结点 0 处出发，并且每次移动，你都将沿着一条边行进。
 *
 * 返回最多 M 次移动可以达到的结点数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：edges = [[0,1,10],[0,2,1],[1,2,2]], M = 6, N = 3
 * 输出：13
 * 解释：
 * 在 M = 6 次移动之后在最终图中可到达的结点如下所示。
 *
 * 示例 2：
 *
 * 输入：edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], M = 10, N = 4
 * 输出：23
 *  
 *
 * 提示：
 *
 * 0 <= edges.length <= 10000
 * 0 <= edges[i][0] < edges[i][1] < N
 * 不存在任何 i != j 情况下 edges[i][0] == edges[j][0] 且 edges[i][1] == edges[j][1].
 * 原始图没有平行的边。
 * 0 <= edges[i][2] <= 10000
 * 0 <= M <= 10^9
 * 1 <= N <= 3000
 * 可到达结点是可以从结点 0 开始使用最多 M 次移动到达的结点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reachable-nodes-in-subdivided-graph
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
