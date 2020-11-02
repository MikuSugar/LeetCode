package JavaCode.contest.biweekly.biweekly_n12;

import java.util.*;

/**
 * author:fangjie
 * time:2019/11/4
 */
public class N3 {
    public int treeDiameter(int[][] edges) {
        List<Integer>[] graphs=new List[edges.length+1];
        for (int i=0;i<graphs.length;i++)graphs[i]=new ArrayList<>();
        for (int[] e:edges)
        {
            graphs[e[0]].add(e[1]);
            graphs[e[1]].add(e[0]);
        }
        Map<Integer,Map<Integer,Integer>> dpMap=new HashMap<>();
        return slove(-1,-1,graphs,dpMap);
    }

    private int slove(int pre, int cur, List<Integer>[] graphs, Map<Integer, Map<Integer, Integer>> dpMap) {
        int res=0;
        if(cur==-1)
        {
            for(int i=0;i<graphs.length;i++) res=Math.max(res,slove(cur,i,graphs,dpMap));
            return res;
        }

        if(dpMap.containsKey(pre)&&dpMap.get(pre).containsKey(cur)) return dpMap.get(pre).get(cur);
        for (int next:graphs[cur])
        {
            if(next==pre)continue;
            res=Math.max(res,1+slove(cur,next,graphs,dpMap));
        }
        dpMap.putIfAbsent(pre, new HashMap<>());
        Map<Integer, Integer> map=dpMap.get(pre);
        map.put(cur, res);
        return res;
    }
}
/*
给你这棵「无向树」，请你测算并返回它的「直径」：这棵树上最长简单路径的 边数。

我们用一个由所有「边」组成的数组 edges 来表示一棵无向树，其中 edges[i] = [u, v] 表示节点 u 和 v 之间的双向边。

树上的节点都已经用 {0, 1, ..., edges.length} 中的数做了标记，每个节点上的标记都是独一无二的。



示例 1：



输入：edges = [[0,1],[0,2]]
输出：2
解释：
这棵树上最长的路径是 1 - 0 - 2，边数为 2。
示例 2：



输入：edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
输出：4
解释：
这棵树上最长的路径是 3 - 2 - 1 - 4 - 5，边数为 4。


提示：

0 <= edges.length < 10^4
edges[i][0] != edges[i][1]
0 <= edges[i][j] <= edges.length
edges 会形成一棵无向树

 */
