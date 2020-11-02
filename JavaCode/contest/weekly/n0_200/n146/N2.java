package JavaCode.contest.weekly.n0_200.n146;

import java.util.*;

public class N2 {
    public static void main(String[] args) {
        System.out.println(new N2().shortestAlternatingPaths(3,new int[][]{{0,1},{1,2}},new int[][]{}));
    }
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] res=new int[n];
        Arrays.fill(res,-1);
        Map<Integer, List<Integer>> mapr=new HashMap<>();
        Map<Integer,List<Integer>> mapb=new HashMap<>();
        for (int[] r:red_edges)
        {
            if(!mapr.containsKey(r[0]))
            {
                mapr.put(r[0],new ArrayList<>());
            }
            mapr.get(r[0]).add(r[1]);
        }
        for (int[] b:blue_edges)
        {
            if(!mapb.containsKey(b[0]))
            {
                mapb.put(b[0],new ArrayList<>());
            }
            mapb.get(b[0]).add(b[1]);
        }
        Queue<int[]> queue=new LinkedList<>();
        //0r 1b
        queue.add(new int[]{0,0});
        queue.add(new int[]{0,1});
        int level=0;
        boolean[][] book=new boolean[n][2];
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i=0;i<size;i++)
            {
                int[] poll = queue.poll();
                if(res[poll[0]]==-1)res[poll[0]]=level;
                if(poll[1]==0)
                {
                    book[poll[0]][0]=true;
                }
                else
                {
                    book[poll[0]][1]=true;
                }
                if(poll[1]==0)
                {
                    for (int next:mapb.getOrDefault(poll[0],new ArrayList<>()))
                    {
                        if(book[next][1])continue;
                        queue.add(new int[]{next,1});
                    }
                }
                else
                {
                    for (int next:mapr.getOrDefault(poll[0],new ArrayList<>()))
                    {
                        if(book[next][0])continue;
                        queue.add(new int[]{next,0});
                    }
                }
            }
            level++;
        }
        return res;
    }
}
/**
 *在一个有向图中，节点分别标记为 0, 1, ..., n-1。这个图中的每条边不是红色就是蓝色，且存在自环或平行边。
 *
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
 *
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的最短路径的长度，且路径上红色边和蓝色边交替出现。如果不存在这样的路径，那么 answer[x] = -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 * 示例 2：
 *
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * 输出：[0,1,-1]
 * 示例 3：
 *
 * 输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * 输出：[0,-1,-1]
 * 示例 4：
 *
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * 输出：[0,1,2]
 * 示例 5：
 *
 * 输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * 输出：[0,1,1]
 *
 *
 * 提示：
 *
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 */
