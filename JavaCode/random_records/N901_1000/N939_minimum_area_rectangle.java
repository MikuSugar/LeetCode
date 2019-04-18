package JavaCode.random_records.N901_1000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class N939_minimum_area_rectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for (int[] p:points)
        {
            if(!map.containsKey(p[0]))map.put(p[0],new HashSet<>());
            map.get(p[0]).add(p[1]);
        }
        int res=Integer.MAX_VALUE;
        for (int[] p1:points)
        {
            for (int[] p2:points)
            {
                if(p1[0]==p2[0]||p1[1]==p2[1])continue;
                if(map.get(p1[0]).contains(p2[1])&&map.get(p2[0]).contains(p1[1]))
                {
                    res=Math.min(res,Math.abs(p1[0]-p2[0])*Math.abs(p1[1]-p2[1]));
                }
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
/**
 * https://leetcode-cn.com/problems/minimum-area-rectangle/
 * 给定在 xy 平面上的一组点，确定由这些点组成的矩形的最小面积，其中矩形的边平行于 x 轴和 y 轴。
 *
 * 如果没有任何矩形，就返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[1,1],[1,3],[3,1],[3,3],[2,2]]
 * 输出：4
 * 示例 2：
 *
 * 输入：[[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= points.length <= 500
 * 0 <= points[i][0] <= 40000
 * 0 <= points[i][1] <= 40000
 * 所有的点都是不同的。
 */
