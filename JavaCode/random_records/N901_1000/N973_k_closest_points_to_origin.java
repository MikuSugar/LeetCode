package JavaCode.random_records.N901_1000;


import java.util.Comparator;
import java.util.PriorityQueue;

public class N973_k_closest_points_to_origin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair> queue =new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.v-o1.v;
            }
        });
        for (int[] p:points)
        {
            queue.add(new Pair(p,getSqrt(p)));
        }
        int[][] res=new int[K][2];
        for (int i=0;i<K;i++)
        {
            res[i]=queue.poll().p;
        }
        return res;
    }

    private class Pair
    {
        int[] p;
        int v;
        public Pair(int[] p, int v) {
            this.p = p;
            this.v = v;
        }
    }
    private Integer getSqrt(int[] p) {
        return p[0]*p[0]+p[1]*p[1];
    }
}
/**
 *  我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
