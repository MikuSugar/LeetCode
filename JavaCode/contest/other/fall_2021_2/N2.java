package JavaCode.contest.other.fall_2021_2;

import java.util.*;

/**
 * @author mikusugar
 */
public class N2 {
    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        List<int[]> res = new ArrayList<>();

        int n = terrain.length;
        int m = obstacle[0].length;

        Set<Integer>[][] books = new Set[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                books[i][j] = new HashSet<>();
            }
        }


        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{position[0], position[1], 1});
        books[position[0]][position[1]].add(1);

        while (!queue.isEmpty()) {
            final int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            int s = cur[2];

            for (int[] next : NEXTS) {
                int ii = i + next[0];
                int jj = j + next[1];
                if (ii < 0 || jj < 0 || ii >= n || jj >= m) continue;
                int ns = s + terrain[i][j] - terrain[ii][jj] - obstacle[ii][jj];
                if (ns <= 0) continue;
                if (books[ii][jj].contains(ns)) continue;
                books[ii][jj].add(ns);
                if (ns == 1) res.add(new int[]{ii, jj});
                queue.add(new int[]{ii, jj, ns});
            }
        }

        res.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return Integer.compare(o1[1],o2[1]);
                }
                return Integer.compare(o1[0],o2[0]);
            }
        });

        int[][] ans = new int[res.size()][];
        for (int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }

        return ans;

    }

    private final static int[][] NEXTS = {{0,-1},{-1,0},{0,1},{1,0}};
}
/*
「力扣挑战赛」中 N*M 大小的自行车炫技赛场的场地由一片连绵起伏的上下坡组成，场地的高度值记录于二维数组 terrain 中，场地的减速值记录于二维数组 obstacle 中。

若选手骑着自行车从高度为 h1 且减速值为 o1 的位置到高度为 h2 且减速值为 o2 的相邻位置，速度变化值为 h1-h2-o2（负值减速，正值增速）。
选手初始位于坐标 position 处且初始速度为 1，请问选手可以刚好到其他哪些位置时速度依旧为 1。请以二维数组形式返回这些位置。若有多个位置则按行坐标升序排列，若有多个位置行坐标相同则按列坐标升序排列。

注意： 骑行过程中速度不能为零或负值

示例 1：

输入：position = [0,0], terrain = [[0,0],[0,0]], obstacle = [[0,0],[0,0]]

输出：[[0,1],[1,0],[1,1]]

解释：
由于当前场地属于平地，根据上面的规则，选手从[0,0]的位置出发都能刚好在其他处的位置速度为 1。

示例 2：

输入：position = [1,1], terrain = [[5,0],[0,6]], obstacle = [[0,6],[7,0]]

输出：[[0,1]]

解释：
选手从 [1,1] 处的位置出发，到 [0,1] 处的位置时恰好速度为 1。

提示：

n == terrain.length == obstacle.length
m == terrain[i].length == obstacle[i].length
1 <= n <= 100
1 <= m <= 100
0 <= terrain[i][j], obstacle[i][j] <= 100
position.length == 2
0 <= position[0] < n
0 <= position[1] < m
 */
