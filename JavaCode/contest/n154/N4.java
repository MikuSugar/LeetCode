package JavaCode.contest.n154;

import java.util.ArrayList;
import java.util.List;

public class N4 {
    private int total;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>[] graph=getGraph(n,connections);
        this.total=0;
        dfs(0,-1,graph,res,new int[(int) (1e5+5)],new int[(int)(1e5+5)]);
        return res;
    }

    private void dfs(int cur, int father, List<Integer>[] graph, List<List<Integer>> res, int[] dfn, int[] low) {
        dfn[cur]=low[cur]=++total;
        for (int next:graph[cur])
        {
            if(dfn[next]==0)
            {
                dfs(next,cur,graph,res,dfn,low);
                low[cur]=Math.min(low[cur],low[next]);
                if(dfn[cur]<low[next])
                {
                    res.add(new ArrayList<Integer>(){{add(cur);add(next);}});
                }
            }
            else if(next!=father)low[cur]=Math.min(low[cur],dfn[next]);
        }
    }

    private List<Integer>[] getGraph(int n, List<List<Integer>> connections) {
        List<Integer>[] graph=new List[n+1];
        for (List<Integer> conn:connections)
        {
            int a=conn.get(0);
            int b=conn.get(1);
            if(graph[a]==null)graph[a]=new ArrayList<>();
            if(graph[b]==null)graph[b]=new ArrayList<>();
            graph[a].add(b);
            graph[b].add(a);
        }
        return graph;
    }
}
/**
 *力扣数据中心有 n 台服务器，分别按从 0 到 n-1 的方式进行了编号。
 *
 * 它们之间以「服务器到服务器」点对点的形式相互连接组成了一个内部集群，其中连接 connections 是无向的。
 *
 * 从形式上讲，connections[i] = [a, b] 表示服务器 a 和 b 之间形成连接。任何服务器都可以直接或者间接地通过网络到达任何其他服务器。
 *
 * 「关键连接」是在该集群中的重要连接，也就是说，假如我们将它移除，便会导致某些服务器无法访问其他服务器。
 *
 * 请你以任意顺序返回该集群内的所有 「关键连接」。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * 输出：[[1,3]]
 * 解释：[[3,1]] 也是正确的。
 *
 *
 * 提示：
 *
 * 1 <= n <= 10^5
 * n-1 <= connections.length <= 10^5
 * connections[i][0] != connections[i][1]
 * 不存在重复的连接
 */
