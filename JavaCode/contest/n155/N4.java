package JavaCode.contest.n155;

import java.util.*;

/**
 * author:fangjie
 * time:2019/9/24
 */
public class N4 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int[] cnt=new int[m];
        int idx=m;
        List<List<Integer>> groups=new ArrayList<>(m);
        for (int i=0;i<m;i++)
        {
            groups.add(new ArrayList<>());
        }
        for (int i=0;i<n;i++)
        {
            if(group[i]==-1)
            {
                group[i]=idx;
                groups.add(new ArrayList<>());
                groups.get(idx++).add(i);
            }
            else
            {
                cnt[group[i]]++;
                groups.get(group[i]).add(i);
            }
        }
        Graph graph=new Graph(idx);
        Graph[] graphs=new Graph[m];
        for (int i=0;i<m;i++)
        {
            graphs[i]=new Graph(cnt[i]);
        }
        for (int i=0;i<n;i++)
        {
            List<Integer> before=beforeItems.get(i);
            int g=group[i];
            int idx1=Collections.binarySearch(groups.get(g), i);
            for (int b:before)
            {
                int g2=group[b];
                if(g==g2)
                {
                    int idx2=Collections.binarySearch(groups.get(g2),b);
                    graphs[g].addEdge(idx2,idx1);
                }
                else
                {
                    graph.addEdge(g2,g);
                }
            }
        }
        List<Integer> gslove=graph.slove();
        if(gslove==null)return new int[0];
        int[] res=new int[n];
        idx=0;
        for (int i:gslove)
        {
            List<Integer> grp=groups.get(i);
            if(grp.size()==1)res[idx++]=grp.get(0);
            else
            {
                List<Integer> graphslove=graphs[i].slove();
                if(graphslove==null)return new int[0];
                for (int k:graphslove)
                {
                    res[idx++]=grp.get(k);
                }
            }
        }
        return res;
    }

    class Graph{
        private Set<Integer>[] nodes;
        int[] cnt;
        Graph(int n)
        {
            nodes=new Set[n];
            for (int i=0;i<n;i++)
            {
                nodes[i]=new HashSet<>();
            }
            cnt=new int[n];
        }
        void addEdge(int u,int v)
        {
            if(!nodes[u].contains(v))
            {
                nodes[u].add(v);
                cnt[v]++;
            }
        }
        List<Integer> slove()
        {
            List<Integer> res=new ArrayList<>();
            Queue<Integer> queue=new LinkedList<>();
            for (int i=0;i<cnt.length;i++)
            {
                if(cnt[i]==0)
                {
                    queue.add(i);
                }
            }
            while (!queue.isEmpty())
            {
                int cur=queue.poll();
                res.add(cur);
                for (int v:nodes[cur])
                {
                    cnt[v]--;
                    if(cnt[v]==0)queue.add(v);
                }
            }
            return res.size()==cnt.length?res:null;
        }
    }
}
/**
 * 公司共有 n 个项目和  m 个小组，每个项目要不没有归属，要不就由其中的一个小组负责。
 *
 * 我们用 group[i] 代表第 i 个项目所属的小组，如果这个项目目前无人接手，那么 group[i] 就等于 -1。（项目和小组都是从零开始编号的）
 *
 * 请你帮忙按要求安排这些项目的进度，并返回排序后的项目列表：
 *
 * 同一小组的项目，排序后在列表中彼此相邻。
 * 项目之间存在一定的依赖关系，我们用一个列表 beforeItems 来表示，其中 beforeItems[i] 表示在进行第 i 个项目前（位于第 i 个项目左侧）应该完成的所有项目。
 * 结果要求：
 *
 * 如果存在多个解决方案，只需要返回其中任意一个即可。
 *
 * 如果没有合适的解决方案，就请返回一个 空列表。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
 * 输出：[6,3,4,1,5,2,0,7]
 * 示例 2：
 *
 * 输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]]
 * 输出：[]
 * 解释：与示例 1 大致相同，但是在排序后的列表中，4 必须放在 6 的前面。
 *
 *
 * 提示：
 *
 * 1 <= m <= n <= 3*10^4
 * group.length == beforeItems.length == n
 * -1 <= group[i] <= m-1
 * 0 <= beforeItems[i].length <= n-1
 * 0 <= beforeItems[i][j] <= n-1
 * i != beforeItems[i][j]
 */
