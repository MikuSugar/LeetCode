package JavaCode.random_records.N2401_N2600;

import utils.Parse;

import java.util.*;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/20 10:47
 * @description most-profitable-path-in-a-tree
 */
public class N2467_most_profitable_path_in_a_tree {

    public static void main(String[] args) {
        System.out.println(new N2467_most_profitable_path_in_a_tree().mostProfitablePath(
                Parse.toIntTwoArr("[[0,1],[1,2],[1,3],[3,4]]"),
                3,
                Parse.toIntArr("[-2,4,2,-4,6]")));
        System.out.println(new N2467_most_profitable_path_in_a_tree().mostProfitablePath(
                Parse.toIntTwoArr("[[0,1]]"),
                1,
                Parse.toIntArr("[-7280,2350]")));
        //[[0,21],[0,6],[0,29],[1,3],[1,38],[2,31],[2,33],[2,27],[3,23],[3,8],[4,5],[4,21],[5,11],[5,25],[6,27],[7,22],[7,21],[8,12],[8,20],[8,16],[9,10],[10,17],[12,15],[13,24],[14,29],[16,24],[16,34],[17,19],[17,27],[18,35],[18,26],[26,36],[26,30],[28,30],[29,30],[29,37],[32,34],[37,38]]
        //26
        //[3756,7618,130,-1544,-3646,4384,-9736,2100,-7186,-3798,-7392,4092,5620,1172,-6354,-6590,1262,-1392,-7034,-9342,-1682,1894,-6922,-748,5956,708,-7370,9076,7734,-7514,-6478,2288,4584,-6494,2790,-7840,2196,7712,5556]
        //预期 17034
        System.out.println(new N2467_most_profitable_path_in_a_tree().mostProfitablePath(
                Parse.toIntTwoArr("[[0,21],[0,6],[0,29],[1,3],[1,38],[2,31]," +
                        "[2,33],[2,27],[3,23],[3,8],[4,5],[4,21],[5,11],[5,25],[6,27]," +
                        "[7,22],[7,21],[8,12],[8,20],[8,16],[9,10],[10,17],[12,15]," +
                        "[13,24],[14,29],[16,24],[16,34],[17,19],[17,27],[18,35]," +
                        "[18,26],[26,36],[26,30],[28,30],[29,30],[29,37],[32,34],[37,38]]"),
                26,
                Parse.toIntArr("[3756,7618,130,-1544,-3646,4384,-9736,2100,-7186,-3798," +
                        "-7392,4092,5620,1172,-6354,-6590,1262,-1392,-7034,-9342,-1682,1894,-6922," +
                        "-748,5956,708,-7370,9076,7734,-7514,-6478,2288,4584,-6494,2790,-7840,2196,7712,5556]")));
    }

    private int res = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        final int n = edges.length + 1;
        //build Tree
        final int[] fa = new int[n];
        @SuppressWarnings("unchecked") final List<Integer>[] ch = new List[n];
        for (int i = 0; i < n; i++) {
            ch[i] = new ArrayList<>(2);
        }
        buildTree(fa, ch, edges);

        //Bob遍历
        List<Integer> bobRoute = new ArrayList<>();
        dfsBob(fa, bob, bobRoute);

        //Alice
        Set<Integer> bobOpen = new HashSet<>();
        this.res = Integer.MIN_VALUE;
        dfsAlice(0, 0, 0, bobRoute, bobOpen, ch, amount);
        return res;
    }

    private void buildTree(int[] fa, List<Integer>[] ch, int[][] edges) {
        final int n = edges.length + 1;
        @SuppressWarnings("unchecked")
        Set<Integer>[] edgesAdj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            edgesAdj[i] = new HashSet<>(2);
        }
        for (int[] edge : edges) {
            edgesAdj[edge[0]].add(edge[1]);
            edgesAdj[edge[1]].add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        Set<Integer> used = new HashSet<>();
        while (!queue.isEmpty()) {
            final int cur = queue.poll();
            used.add(cur);
            final Set<Integer> chs = edgesAdj[cur];
            chs.removeAll(used);
            ch[cur].addAll(chs);
            for (int next : chs) {
                fa[next] = cur;
            }
            queue.addAll(chs);
        }

    }

    private void dfsAlice(int cur,
                          int level,
                          int preSum,
                          List<Integer> bobRoute,
                          Set<Integer> bobOpen,
                          List<Integer>[] ch,
                          int[] amount) {
        if (!bobOpen.contains(cur)) {
            if (level < bobRoute.size() && bobRoute.get(level) == cur) {
                preSum += amount[cur] / 2;
            } else {
                preSum += amount[cur];
            }
        }
        if (level < bobRoute.size()) {
            bobOpen.add(bobRoute.get(level));
        }

        if (ch[cur].size() == 0) {
            this.res = Math.max(res, preSum);
        } else {
            for (int next : ch[cur]) {
                dfsAlice(next, level + 1, preSum, bobRoute, bobOpen, ch, amount);
            }
        }
        if (level < bobRoute.size()) {
            bobOpen.remove(bobRoute.get(level));
        }

    }


    private void dfsBob(int[] fa, int cur, List<Integer> bobRoute) {
        bobRoute.add(cur);
        if (cur == 0) {
            return;
        }
        dfsBob(fa, fa[cur], bobRoute);
    }
}
/*
一个 n 个节点的无向树，节点编号为 0 到 n - 1 ，树的根结点是 0 号节点。给你一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] ，表示节点 ai 和 bi 在树中有一条边。

在每一个节点 i 处有一扇门。同时给你一个都是偶数的数组 amount ，其中 amount[i] 表示：

如果 amount[i] 的值是负数，那么它表示打开节点 i 处门扣除的分数。
如果 amount[i] 的值是正数，那么它表示打开节点 i 处门加上的分数。
游戏按照如下规则进行：

一开始，Alice 在节点 0 处，Bob 在节点 bob 处。
每一秒钟，Alice 和 Bob 分别 移动到相邻的节点。Alice 朝着某个 叶子结点 移动，Bob 朝着节点 0 移动。
对于他们之间路径上的 每一个 节点，Alice 和 Bob 要么打开门并扣分，要么打开门并加分。注意：
如果门 已经打开 （被另一个人打开），不会有额外加分也不会扣分。
如果 Alice 和 Bob 同时 到达一个节点，他们会共享这个节点的加分或者扣分。换言之，如果打开这扇门扣 c 分，那么 Alice 和 Bob 分别扣 c / 2 分。如果这扇门的加分为 c ，那么他们分别加 c / 2 分。
如果 Alice 到达了一个叶子结点，她会停止移动。类似的，如果 Bob 到达了节点 0 ，他也会停止移动。注意这些事件互相 独立 ，不会影响另一方移动。
请你返回 Alice 朝最优叶子结点移动的 最大 净得分。

 

示例 1：



输入：edges = [[0,1],[1,2],[1,3],[3,4]], bob = 3, amount = [-2,4,2,-4,6]
输出：6
解释：
上图展示了输入给出的一棵树。游戏进行如下：
- Alice 一开始在节点 0 处，Bob 在节点 3 处。他们分别打开所在节点的门。
  Alice 得分为 -2 。
- Alice 和 Bob 都移动到节点 1 。
  因为他们同时到达这个节点，他们一起打开门并平分得分。
  Alice 的得分变为 -2 + (4 / 2) = 0 。
- Alice 移动到节点 3 。因为 Bob 已经打开了这扇门，Alice 得分不变。
  Bob 移动到节点 0 ，并停止移动。
- Alice 移动到节点 4 并打开这个节点的门，她得分变为 0 + 6 = 6 。
现在，Alice 和 Bob 都不能进行任何移动了，所以游戏结束。
Alice 无法得到更高分数。
示例 2：



输入：edges = [[0,1]], bob = 1, amount = [-7280,2350]
输出：-7280
解释：
Alice 按照路径 0->1 移动，同时 Bob 按照路径 1->0 移动。
所以 Alice 只打开节点 0 处的门，她的得分为 -7280 。
 

提示：

2 <= n <= 105
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
edges 表示一棵有效的树。
1 <= bob < n
amount.length == n
amount[i] 是范围 [-104, 104] 之间的一个 偶数 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/most-profitable-path-in-a-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
