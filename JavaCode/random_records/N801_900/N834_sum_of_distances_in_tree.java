package JavaCode.random_records.N801_900;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * author:fangjie
 * time:2019/9/17
 */
public class N834_sum_of_distances_in_tree {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        Set<Integer>[] graph=new Set[N];
        for (int i=0;i<graph.length;i++)
        {
            graph[i]=new HashSet<>();
        }
        for (int[] edge:edges)
        {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] res=new int[N];
        int[] count=new int[N];
        Arrays.fill(count,1);
        getCount(0,-1,graph,count,res);
        getRes(0,-1,graph,count,res);
        return res;
    }

    private void getRes(int cur, int pre, Set<Integer>[] graph, int[] count, int[] res) {
        for (int next:graph[cur])
        {
            if(next!=pre)
            {
                res[next]=res[cur]-count[next]+graph.length-count[next];
                getRes(next,cur,graph,count,res);
            }
        }
    }

    private void getCount(int cur, int pre, Set<Integer>[] graph, int[] count, int[] res) {
        for (int next:graph[cur])
        {
            if(next!=pre)
            {
                getCount(next,cur,graph,count, res);
                count[cur]+=count[next];
                res[cur]+=res[next]+count[next];
            }
        }
    }
    
}
/**
 * 给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。
 *
 * 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。
 *
 * 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。
 *
 * 示例 1:
 *
 * 输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * 输出: [8,12,6,10,10,10]
 * 解释:
 * 如下为给定的树的示意图：
 *   0
 *  / \
 * 1   2
 *    /|\
 *   3 4 5
 *
 * 我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * 也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
 * 说明: 1 <= N <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-distances-in-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
