package JavaCode.contest.n179;


import java.util.*;

/**
 * author:fangjie
 * time:2020/3/8
 */
public class N4 {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        Node[] nodes=new Node[n+1];
        for (int i=0;i<=n;i++)
        {
            nodes[i]=new Node(i);
        }
        for (int[] edge:edges)
        {
            nodes[edge[0]].nexts.add(nodes[edge[1]]);
            nodes[edge[1]].nexts.add(nodes[edge[0]]);
        }
        boolean[] book=new boolean[n+1];
        double[] res=new double[n+1];
        res[1]=1d;
        dfs(1,res,nodes,t,book);
        return res[target];
    }

    private void dfs(int i, double[] dbs, Node[] nodes, int t,boolean[] book) {
        book[i]=true;
        Node cur=nodes[i];
        List<Node> next=new ArrayList<>(cur.nexts.size());
        for (Node n:cur.nexts)
        {
            if(book[n.idx])continue;
            next.add(n);
        }
        if(next.size()==0||t==0)
        {
            book[i]=false;
            return;
        }
        else
        {
            double var=dbs[i]/next.size();
            dbs[i]=0d;
            for (Node n:next)
            {
                dbs[n.idx]+=var;
                dfs(n.idx,dbs,nodes,t-1,book);
            }
        }
        book[i]=false;
    }

    private class Node{
        Set<Node> nexts;
        int idx;
        public Node(int idx) {
            this.idx=idx;
            nexts=new HashSet<>();
        }
    }
}
/*
给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下：

在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。
青蛙无法跳回已经访问过的顶点。
如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。
如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。
无向树的边用数组 edges 描述，其中 edges[i] = [fromi, toi] 意味着存在一条直接连通 fromi 和 toi 两个顶点的边。

返回青蛙在 t 秒后位于目标顶点 target 上的概率。



示例 1：



输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
输出：0.16666666666666666
解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，因此青蛙在 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。
示例 2：



输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
输出：0.3333333333333333
解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，有 1/3 = 0.3333333333333333 的概率能够 1 秒 后跳到顶点 7 。
示例 3：

输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 20, target = 6
输出：0.16666666666666666


提示：

1 <= n <= 100
edges.length == n-1
edges[i].length == 2
1 <= edges[i][0], edges[i][1] <= n
1 <= t <= 50
1 <= target <= n
与准确值误差在 10^-5 之内的结果将被判定为正确。

 */
