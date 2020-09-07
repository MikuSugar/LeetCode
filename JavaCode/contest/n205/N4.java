package JavaCode.contest.n205;

import utils.Parse;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/9/6 10:25 上午
 */
public class N4 {

    public static void main(String[] args) {
        //4
        //[[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
        System.out.println(new N4().maxNumEdgesToRemove(4, Parse.parseToIntTwoArray("[[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]")));
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] fa1=new int[n+1];
        int[] fa2=new int[n+1];
        for (int i=0; i<fa1.length; i++) {
            fa1[i]=fa2[i]=i;
        }

        int res=0;
        for (int[] e : edges) {
            if (e[0]!=3) continue;
            if (find(e[1], fa1)==find(e[2], fa1)||find(e[1], fa2)==find(e[2], fa2)) continue;
            fa1[find(e[1], fa1)]=find(e[2], fa1);
            fa2[find(e[1], fa2)]=find(e[2], fa2);
            res++;
        }

        for (int[] e : edges) {
            if (e[0]==3) continue;
            if (e[0]==1) {
                if (find(e[1], fa1)==find(e[2], fa1)) continue;
                fa1[find(e[1], fa1)]=find(e[2], fa1);
            } else {
                if (find(e[1], fa2)==find(e[2], fa2)) continue;
                fa2[find(e[1], fa2)]=find(e[2], fa2);
            }
            res++;
        }
        if (getNum(fa1)>1||getNum(fa2)>1) return -1;
        return edges.length-res;
    }

    private int getNum(int[] fa) {
        int res=0;
        for (int i=1; i<fa.length; i++) {
            if (fa[i]==i) res++;
        }
        return res;
    }

    private int find(int x, int[] fa) {
        if (x==fa[x]) return x;
        return fa[x]=find(fa[x], fa);
    }
}
/*
Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：

类型 1：只能由 Alice 遍历。
类型 2：只能由 Bob 遍历。
类型 3：Alice 和 Bob 都可以遍历。
给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。

返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。



示例 1：



输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
输出：2
解释：如果删除 [1,1,2] 和 [1,1,3] 这两条边，Alice 和 Bob 仍然可以完全遍历这个图。再删除任何其他的边都无法保证图可以完全遍历。所以可以删除的最大边数是 2 。
示例 2：



输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
输出：0
解释：注意，删除任何一条边都会使 Alice 和 Bob 无法完全遍历这个图。
示例 3：



输入：n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
输出：-1
解释：在当前图中，Alice 无法从其他节点到达节点 4 。类似地，Bob 也不能达到节点 1 。因此，图无法完全遍历。


提示：

1 <= n <= 10^5
1 <= edges.length <= min(10^5, 3 * n * (n-1) / 2)
edges[i].length == 3
1 <= edges[i][0] <= 3
1 <= edges[i][1] < edges[i][2] <= n
所有元组 (typei, ui, vi) 互不相同
 */
