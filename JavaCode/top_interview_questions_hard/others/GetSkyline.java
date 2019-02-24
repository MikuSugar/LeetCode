package JavaCode.top_interview_questions_hard.others;

import java.util.*;

public class GetSkyline {
    public List<int[]> getSkyline(int[][] buildings) {

        List<int[]> result=new ArrayList<>();

        //存储左顶点和右顶点 左为负数，右为正数
        List<int[]> help=new ArrayList<>();
        for (int[] a:buildings)
        {
            help.add(new int[]{a[0],-a[2]});
            help.add(new int[]{a[1],a[2]});
        }

        //根据横坐标排序
        help.sort(new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if(o1[0]!=o2[0])
                {
                    return o1[0]-o2[0];
                }
                else
                {
                    return o1[1]-o2[1];
                }
            }
        });

        //构建堆，以地平线的高度来排列。
        Queue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2-o1;
            }
        });

        queue.add(0);//地平线入队
        int prev=0;//记录上次的高度
        for (int[] a:help)
        {
            //左顶点入队
            if(a[1]<0)
            {
                queue.add(-a[1]);
            }
            else
            {
                queue.remove(a[1]);
            }

            int cur=queue.peek();
            if(prev!=cur)
            {
                result.add(new int[]{a[0],cur});
                prev=cur;
            }

        }
        return result;

    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/63/others/168/
 *  天际线问题
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由这些建筑物形成的天际线（图B）。
 *
 * Buildings  Skyline Contour
 * 每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的完美矩形。
 *
 * 例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。
 *
 * 输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。关键点是水平线段的左端点。请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 *
 * 例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。
 *
 * 说明:
 *
 * 任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。
 * 输入列表已经按升序排列在左边的 x 位置 Li 。
 * 输出列表必须按 x 位排序。
 * 输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [
 */
