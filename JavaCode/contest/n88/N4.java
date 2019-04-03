package JavaCode.contest.n88;

import java.util.*;

public class N4 {

    public static void main(String[] args) {
       System.out.println(new N4().rectangleArea(new int[][]{{0,0,2,2},{1,1,3,3}}));
    }


    static int M=(int)Math.pow(10,9)+7;

    public int rectangleArea(int[][] rectangles) {
        List<Node> list=new ArrayList<>();
        for (int[] r:rectangles)
        {
            Point p=new Point(r[1],r[3]);
            list.add(new Node(p,r[0],false));
            list.add(new Node(p,r[2],true));
        }
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.index-o2.index;
            }
        });

        List<Point> list1=new ArrayList<>();

        double res=0;
        int pre_index=0;
        for (Node node:list)
        {
            if(node.index!=pre_index)
            {
                res=(res+help(list1,node.index-pre_index))%M;
                pre_index=node.index;
            }

            if(node.isend)list1.remove(node.point);
            else list1.add(node.point);
        }
        return (int)res;
    }

    private double help(List<Point> list,int cnt) {

        list.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return (int) (o1.y1-o2.y1);
            }
        });
        double sum=0;
        double y1=0;
        double y2=0;
        for (Point p:list)
        {
            if(p.y1>y2)
            {
                sum=(sum+y2-y1)%M;
                y1=p.y1;
                y2=p.y2;
            }
            else
            {
                y2=Math.max(y2,p.y2);
            }
        }
        sum=(sum+y2-y1)%M;
        sum=(int) ((double)sum*cnt%M);
        return sum;
    }

    class Point
    {
        double y1;
        double y2;
        public Point(int y1,int y2)
        {
            this.y1=y1;
            this.y2=y2;
        }
    }

    class Node
    {
        Point point;
        boolean isend;
        int index;
        public Node(Point point, int index,boolean isend) {
            this.point = point;
            this.index = index;
            this.isend=isend;
        }
    }
}
/**
 * https://leetcode-cn.com/problems/rectangle-area-ii/
 * 我们给出了一个（轴对齐的）矩形列表 rectangles 。 对于 rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是矩形 i 左下角的坐标，（x2，y2）是该矩形右上角的坐标。
 *
 * 找出平面中所有矩形叠加覆盖后的总面积。 由于答案可能太大，请返回它对 10 ^ 9 + 7 取模的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[0,0,2,2],[1,0,2,3],[1,0,3,1]]
 * 输出：6
 * 解释：如图所示。
 * 示例 2：
 *
 * 输入：[[0,0,1000000000,1000000000]]
 * 输出：49
 * 解释：答案是 10^18 对 (10^9 + 7) 取模的结果， 即 (10^9)^2 → (-7)^2 = 49 。
 * 提示：
 *
 * 1 <= rectangles.length <= 200
 * rectanges[i].length = 4
 * 0 <= rectangles[i][j] <= 10^9
 * 矩形叠加覆盖后的总面积不会超越 2^63 - 1 ，这意味着可以用一个 64 位有符号整数来保存面积结果。
 */
