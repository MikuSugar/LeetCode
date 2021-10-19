package JavaCode.contest.weekly.n201_300.n263;

import utils.Parse;

import java.util.*;

/**
 * @author mikusugar
 */
public class N4 {
    public static void main(String[] args) {
        //2
        //[[1,2]]
        //1
        //2
        System.out.println(new N4().secondMinimum(
                2,
                Parse.parseToIntTwoArray("[[1,2]]"),
                1,
                2
        ));
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {

        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0});
        Queue<int[]> back = new ArrayDeque<>();
        int[] book = new int[n + 1];
        Arrays.fill(book, Integer.MAX_VALUE);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (!queue.isEmpty()) {
            final int[] cur = queue.poll();
            int t = cur[1];
            int idx = cur[0];
            System.out.println(Arrays.toString(cur));
            if (t / change % 2 != 0) {
                t = t + t % change;
                System.out.println(t);
            }
            int nextTime = t + time;
            for (int next : g[idx]) {
                if (next == n) {
                    pq.add(nextTime);
                    if (pq.size() > 2) pq.poll();
                }
                if (book[next] <= nextTime) {
                    back.add(new int[]{next, nextTime});
                } else {
                    queue.add(new int[]{next, nextTime});
                    book[next] = nextTime;
                }
            }
        }
        if (pq.size() == 2) {
            pq.poll();
            return pq.poll();
        }
        int min = pq.poll();
        pq.add(min);
        Arrays.fill(book, Integer.MAX_VALUE);
        queue = back;
        queue.add(new int[]{n, min});
        while (!queue.isEmpty()) {
            final int[] cur = queue.poll();
            int t = cur[1];
            int idx = cur[0];
            System.out.println(Arrays.toString(cur));
            if (t / change % 2 != 0) {
                t = t + t % change;
            }
            int nextTime = t + time;
            for (int next : g[idx]) {
                if (next == n) {
                    pq.add(nextTime);
                    if (pq.size() > 2) pq.poll();
                }
                if (book[next] <= nextTime) {

                } else {
                    queue.add(new int[]{next, nextTime});
                    book[next] = nextTime;
                }
            }
        }
        if (pq.size() == 2) {
            pq.poll();
            return pq.poll();
        }

        return -1;

    }
}
/*
城市用一个 双向连通 图表示，图中有 n 个节点，从 1 到 n 编号（包含 1 和 n）。图中的边用一个二维整数数组 edges 表示，其中每个 edges[i] = [ui, vi] 表示一条节点 ui 和节点 vi 之间的双向连通边。每组节点对由 最多一条 边连通，顶点不存在连接到自身的边。穿过任意一条边的时间是 time 分钟。

每个节点都有一个交通信号灯，每 change 分钟改变一次，从绿色变成红色，再由红色变成绿色，循环往复。所有信号灯都 同时 改变。你可以在 任何时候 进入某个节点，但是 只能 在节点 信号灯是绿色时 才能离开。如果信号灯是  绿色 ，你 不能 在节点等待，必须离开。

第二小的值 是 严格大于 最小值的所有值中最小的值。

例如，[2, 3, 4] 中第二小的值是 3 ，而 [2, 2, 4] 中第二小的值是 4 。
给你 n、edges、time 和 change ，返回从节点 1 到节点 n 需要的 第二短时间 。

注意：

你可以 任意次 穿过任意顶点，包括 1 和 n 。
你可以假设在 启程时 ，所有信号灯刚刚变成 绿色 。


示例 1：

        

输入：n = 5, edges = [[1,2],[1,3],[1,4],[3,4],[4,5]], time = 3, change = 5
输出：13
解释：
上面的左图展现了给出的城市交通图。
右图中的蓝色路径是最短时间路径。
花费的时间是：
- 从节点 1 开始，总花费时间=0
- 1 -> 4：3 分钟，总花费时间=3
- 4 -> 5：3 分钟，总花费时间=6
因此需要的最小时间是 6 分钟。

右图中的红色路径是第二短时间路径。
- 从节点 1 开始，总花费时间=0
- 1 -> 3：3 分钟，总花费时间=3
- 3 -> 4：3 分钟，总花费时间=6
- 在节点 4 等待 4 分钟，总花费时间=10
- 4 -> 5：3 分钟，总花费时间=13
因此第二短时间是 13 分钟。
示例 2：



输入：n = 2, edges = [[1,2]], time = 3, change = 2
输出：11
解释：
最短时间路径是 1 -> 2 ，总花费时间 = 3 分钟
最短时间路径是 1 -> 2 -> 1 -> 2 ，总花费时间 = 11 分钟


提示：

2 <= n <= 104
n - 1 <= edges.length <= min(2 * 104, n * (n - 1) / 2)
edges[i].length == 2
1 <= ui, vi <= n
ui != vi
不含重复边
每个节点都可以从其他节点直接或者间接到达
1 <= time, change <= 103
 */
