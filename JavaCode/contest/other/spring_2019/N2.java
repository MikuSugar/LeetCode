package JavaCode.contest.other.spring_2019;

import java.util.*;

public class N2 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        TreeMap<Integer, List<int[]>> map=new TreeMap<>();
        for (int i=0;i<workers.length;i++)
        {
            for (int j=0;j<bikes.length;j++)
            {
                int m=getManhattan(workers[i],bikes[j]);
                if(!map.containsKey(m))
                {
                    map.put(m,new ArrayList<>());
                }
                map.get(m).add(new int[]{i,j});
            }
        }
        int[] res=new int[workers.length];
        Arrays.fill(res,-1);
        boolean[] use=new boolean[bikes.length];
        int cnt=0;
        for (Map.Entry<Integer,List<int[]>> e:map.entrySet())
        {
            e.getValue().sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                  return o1[0]-o2[0];
                }
            });
            for (int[] r:e.getValue())
            {
                if(res[r[0]]==-1&&!use[r[1]])
                {
                    res[r[0]]=r[1];
                    use[r[1]]=true;
                    cnt++;
                    if(cnt==workers.length)
                    {
                        return res;
                    }
                }
            }
        }
        return res;
    }

    private int getManhattan(int[] a,int b[])
    {
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
}
/**
 * 2. 校园自行车分配  显示英文描述
 * 用户通过次数 0
 * 用户尝试次数 1
 * 通过次数 0
 * 提交次数 1
 * 题目难度 Medium
 * 在由 2D 网格表示的校园里有 n 位工人（worker）和 m 辆自行车（bike），n <= m。所有工人和自行车的位置都用网格上的 2D 坐标表示。
 *
 * 我们需要为每位工人分配一辆自行车。在所有可用的自行车和工人中，我们选取彼此之间曼哈顿距离最短的工人自行车对  (worker, bike) ，并将其中的自行车分配給工人。如果有多个 (worker, bike) 对之间的曼哈顿距离相同，那么我们选择工人索引最小的那对。类似地，如果有多种不同的分配方法，则选择自行车索引最小的一对。不断重复这一过程，直到所有工人都分配到自行车为止。
 *
 * 给定两点 p1 和 p2 之间的曼哈顿距离为 Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|。
 *
 * 返回长度为 n 的向量 ans，其中 a[i] 是第 i 位工人分配到的自行车的索引（从 0 开始）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * 输出：[1,0]
 * 解释：
 * 工人 1 分配到自行车 0，因为他们最接近且不存在冲突，工人 0 分配到自行车 1 。所以输出是 [1,0]。
 * 示例 2：
 *
 *
 *
 * 输入：workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * 输出：[0,2,1]
 * 解释：
 * 工人 0 首先分配到自行车 0 。工人 1 和工人 2 与自行车 2 距离相同，因此工人 1 分配到自行车 2，工人 2 将分配到自行车 1 。因此输出为 [0,2,1]。
 *
 *
 * 提示：
 *
 * 0 <= workers[i][j], bikes[i][j] < 1000
 * 所有工人和自行车的位置都不相同。
 * 1 <= workers.length <= bikes.length <= 1000
 */
