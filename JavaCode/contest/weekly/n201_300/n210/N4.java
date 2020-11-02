package JavaCode.contest.weekly.n201_300.n210;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/10/11 10:49 上午
 */
public class N4 {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        final int MAX=Integer.MAX_VALUE >> 1;
        //init
        int[][] dist=new int[n][n];
        int[][] graph=new int[n][n];
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                if(i==j)dist[i][j]=0;
                else dist[i][j]=MAX;
            }
        }
        for (int[] e:edges)
        {
            dist[e[0]-1][e[1]-1]=dist[e[1]-1][e[0]-1]=1;
            graph[e[0]-1][e[1]-1]=graph[e[1]-1][e[0]-1]=1;
        }

        for (int k=0;k<n;k++)
        {
            for (int i=0;i<n;i++)
            {
                for (int j=0;j<n;j++)
                {
                    if(k!=i&&k!=j&&dist[i][k]!=MAX&&dist[k][j]!=MAX)
                    {
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        int[] res=new int[n-1];
        //枚举所有子集
        for (int s=1;s<(1<<n);s++)
        {
            int[] p=new int[20];
            int l=0;
            for (int i=0;i<n;i++)
            {
                if((s&(1<<i))!=0)p[l++]=i;
            }
            if(l<=1)continue;

            int d=0,cnt=0;
            for (int i=0;i<l;i++)
            {
                for (int j=i+1;j<l;j++)
                {
                    cnt+=graph[p[i]][p[j]];
                    d=Math.max(d,dist[p[i]][p[j]]);
                }
            }
            if(cnt==l-1)res[d-1]++;
        }
        return res;
    }
}
/*
给你 n 个城市，编号为从 1 到 n 。同时给你一个大小为 n-1 的数组 edges ，其中 edges[i] = [ui, vi] 表示城市 ui 和 vi 之间有一条双向边。题目保证任意城市之间只有唯一的一条路径。换句话说，所有城市形成了一棵 树 。

一棵 子树 是城市的一个子集，且子集中任意城市之间可以通过子集中的其他城市和边到达。两个子树被认为不一样的条件是至少有一个城市在其中一棵子树中存在，但在另一棵子树中不存在。

对于 d 从 1 到 n-1 ，请你找到城市间 最大距离 恰好为 d 的所有子树数目。

请你返回一个大小为 n-1 的数组，其中第 d 个元素（下标从 1 开始）是城市间 最大距离 恰好等于 d 的子树数目。

请注意，两个城市间距离定义为它们之间需要经过的边的数目。



示例 1：



输入：n = 4, edges = [[1,2],[2,3],[2,4]]
输出：[3,4,0]
解释：
子树 {1,2}, {2,3} 和 {2,4} 最大距离都是 1 。
子树 {1,2,3}, {1,2,4}, {2,3,4} 和 {1,2,3,4} 最大距离都为 2 。
不存在城市间最大距离为 3 的子树。
示例 2：

输入：n = 2, edges = [[1,2]]
输出：[1]
示例 3：

输入：n = 3, edges = [[1,2],[2,3]]
输出：[2,1]


提示：

2 <= n <= 15
edges.length == n-1
edges[i].length == 2
1 <= ui, vi <= n
题目保证 (ui, vi) 所表示的边互不相同。
 */
