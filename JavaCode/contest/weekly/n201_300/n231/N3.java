package JavaCode.contest.weekly.n201_300.n231;

import utils.Parse;

import java.util.*;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/3/7 10:27 上午
 */
public class N3 {
    public static void main(String[] args) {
        System.out.println(new N3().countRestrictedPaths(
                5,
                Parse.parseToIntTwoArray("[[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]")
        ));
    }
    private final static int MOD=(int) (1e9+7);
    private final static int MAX=Integer.MAX_VALUE;
    public int countRestrictedPaths(int n, int[][] edges) {
        List<int[]>[] g=new List[n+1];
        for (int i=0;i<g.length;i++)g[i]=new ArrayList<>();
        for (int[] i:edges){
            g[i[0]].add(new int[]{i[1],i[2]});
            g[i[1]].add(new int[]{i[0],i[2]});
        }

        int[] dis=new int[n+1];
        Arrays.fill(dis,MAX);

        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });

        queue.add(new int[]{n,0});
        while (!queue.isEmpty()){
            int[] poll=queue.poll();
            int idx=poll[0];
            int d=poll[1];
            if(dis[idx]<d)continue;
            dis[idx]=d;
            for (int[] next:g[idx]){
                if(dis[next[0]]>next[1]+d) {
                    dis[next[0]]=next[1]+d;
                    queue.add(new int[]{next[0],next[1]+d});
                }
            }
        }

        //System.out.println(Arrays.toString(dis));
        long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
        return (int)dfs(1,n,g,dis,dp);
    }

    private long dfs(int cur, int n,List<int[]>[] g, int[] dis,long[] dp) {
        if(dp[cur]!=-1)return dp[cur];
        if(cur==n)return dp[cur]=1L;
        long res=0L;
        for (int[] next:g[cur]){
            if(dis[next[0]]<dis[cur]){
                res+=dfs(next[0],n,g,dis,dp);
                res%=MOD;
            }
        }
        return dp[cur]=res;
    }
}
/*
现有一个加权无向连通图。给你一个正整数 n ，表示图中有 n 个节点，并按从 1 到 n 给节点编号；另给你一个数组 edges ，其中每个 edges[i] = [ui, vi, weighti] 表示存在一条位于节点 ui 和 vi 之间的边，这条边的权重为 weighti 。

从节点 start 出发到节点 end 的路径是一个形如 [z0, z1, z2, ..., zk] 的节点序列，满足 z0 = start 、zk = end 且在所有符合 0 <= i <= k-1 的节点 zi 和 zi+1 之间存在一条边。

路径的距离定义为这条路径上所有边的权重总和。用 distanceToLastNode(x) 表示节点 n 和 x 之间路径的最短距离。受限路径 为满足 distanceToLastNode(zi) > distanceToLastNode(zi+1) 的一条路径，其中 0 <= i <= k-1 。

返回从节点 1 出发到节点 n 的 受限路径数 。由于数字可能很大，请返回对 109 + 7 取余 的结果。



示例 1：


输入：n = 5, edges = [[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]
输出：3
解释：每个圆包含黑色的节点编号和蓝色的 distanceToLastNode 值。三条受限路径分别是：
1) 1 --> 2 --> 5
2) 1 --> 2 --> 3 --> 5
3) 1 --> 3 --> 5
示例 2：


输入：n = 7, edges = [[1,3,1],[4,1,2],[7,3,4],[2,5,3],[5,6,1],[6,7,2],[7,5,3],[2,6,4]]
输出：1
解释：每个圆包含黑色的节点编号和蓝色的 distanceToLastNode 值。唯一一条受限路径是：1 --> 3 --> 7 。


提示：

1 <= n <= 2 * 104
n - 1 <= edges.length <= 4 * 104
edges[i].length == 3
1 <= ui, vi <= n
ui != vi
1 <= weighti <= 105
任意两个节点之间至多存在一条边
任意两个节点之间至少存在一条路径

 */
