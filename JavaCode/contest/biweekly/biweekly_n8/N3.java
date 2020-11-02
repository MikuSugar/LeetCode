package JavaCode.contest.biweekly.biweekly_n8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N3 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> c1=new ArrayList<>((int)1e4);
        List<Integer> c2=new ArrayList<>((int)1e4);
        List<Integer> c3=new ArrayList<>((int)1e4);
        for (int i=0;i<colors.length;i++)
        {
            if(colors[i]==1)c1.add(i);
            else if(colors[i]==2)c2.add(i);
            else c3.add(i);
        }
        List<Integer>res=new ArrayList<>(queries.length);
        for (int[] q:queries)
        {
            if(q[1]==1) res.add(slove(c1,q[0]));
            else if(q[1]==2) res.add(slove(c2,q[0]));
            else res.add(slove(c3,q[0]));
        }
        return res;
    }

    private int slove(List<Integer> list, int tar) {
        if(list.isEmpty())return -1;
        int idx=Collections.binarySearch(list, tar);
        if(idx<0)
        {
            idx=-1-idx;
            if(idx==list.size())return tar-list.get(list.size()-1);
            if(idx==0)return list.get(idx)-tar;
            return Math.min(list.get(idx)-tar,tar-list.get(idx-1));
        }
        return 0;
    }
}
/**
 *给你一个数组 colors，里面有  1、2、 3 三种颜色。
 *
 * 我们需要在 colors 上进行一些查询操作 queries，其中每个待查项都由两个整数 i 和 c 组成。
 *
 * 现在请你帮忙设计一个算法，查找从索引 i 到具有目标颜色 c 的元素之间的最短距离。
 *
 * 如果不存在解决方案，请返回 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
 * 输出：[3,0,3]
 * 解释：
 * 距离索引 1 最近的颜色 3 位于索引 4（距离为 3）。
 * 距离索引 2 最近的颜色 2 就是它自己（距离为 0）。
 * 距离索引 6 最近的颜色 1 位于索引 3（距离为 3）。
 * 示例 2：
 *
 * 输入：colors = [1,2], queries = [[0,3]]
 * 输出：[-1]
 * 解释：colors 中没有颜色 3。
 *
 *
 * 提示：
 *
 * 1 <= colors.length <= 5*10^4
 * 1 <= colors[i] <= 3
 * 1 <= queries.length <= 5*10^4
 * queries[i].length == 2
 * 0 <= queries[i][0] < colors.length
 * 1 <= queries[i][1] <= 3
 */
