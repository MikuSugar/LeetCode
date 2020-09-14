package JavaCode.contest.n206;

import utils.Parse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/9/13 10:14 上午
 */
public class N3 {
    public static void main(String[] args) {
        System.out.println(new N3().minCostConnectPoints(Parse.parseToIntTwoArray("[[-1000000,-1000000],[1000000,1000000]]")));
    }

    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges=new ArrayList<>();
        for (int i=0; i<points.length; i++) {
            int[] p1=points[i];
            for (int j=i+1; j<points.length; j++) {
                int[] p2=points[j];
                edges.add(new int[]{i, j, getDis(p1, p2)});
            }
        }

        edges.sort(Comparator.comparingInt(o->o[2]));
        int[] fa=new int[points.length];
        for (int i=0; i<fa.length; i++) fa[i]=i;

        int res=0;
        for (int[] edge : edges) {
            int m=find(edge[0], fa);
            int n=find(edge[1], fa);
            if (m!=n) {
                fa[n]=fa[m];
                res+=edge[2];
            }
        }
        return res;
    }

    private int find(int x, int[] fa) {
        if (x==fa[x]) return x;
        return fa[x]=find(fa[x], fa);
    }

    private int getDis(int[] p1, int[] p2) {
        return Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
    }

}
/*
你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。

连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。

请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。



示例 1：



输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
输出：20
解释：

我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
注意到任意两个点之间只有唯一一条路径互相到达。
示例 2：

输入：points = [[3,12],[-2,5],[-4,1]]
输出：18
示例 3：

输入：points = [[0,0],[1,1],[1,0],[-1,1]]
输出：4
示例 4：

输入：points = [[-1000000,-1000000],[1000000,1000000]]
输出：4000000
示例 5：

输入：points = [[0,0]]
输出：0


提示：

1 <= points.length <= 1000
-106 <= xi, yi <= 106
所有点 (xi, yi) 两两不同。

 */
