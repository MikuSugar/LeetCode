package JavaCode.contest.biweekly_n14;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2019/11/30
 */
public class N2 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res=new ArrayList<>();
        for (int[] i:intervals)
        {
            List<Integer> list=help(i,toBeRemoved);
            if(list!=null)
            {
                if(list.size()==2)res.add(list);
                else if(list.size()==4)
                {
                    List<Integer> list1=new ArrayList<>(2);
                    List<Integer> list2=new ArrayList<>(2);
                    list1.add(list.get(0));
                    list1.add(list.get(1));
                    list2.add(list.get(2));
                    list2.add(list.get(3));
                    res.add(list1);
                    res.add(list2);
                }
            }
        }
        return res;
    }

    private List<Integer> help(int[] a, int[] b) {
        if(a[0]>=b[0]&&a[1]<=b[1])return null;
        List<Integer> res=new ArrayList<>(2);
        if(a[1]<=b[0]||a[0]>=b[1])
        {
            res.add(a[0]);
            res.add(a[1]);

        }
        else if(a[0]<b[0]&&a[1]<=b[1])
        {
            res.add(a[0]);
            res.add(b[0]);

        }
        else if(a[1]>b[1]&&a[0]>=b[0])
        {
            res.add(b[1]);
            res.add(a[1]);
        }
        else {
            res.add(a[0]);
            res.add(b[0]);
            res.add(b[1]);
            res.add(a[1]);
        }
        return res;
    }
}
/*
给你一个 有序的 不相交区间列表 intervals 和一个要删除的区间 toBeRemoved， intervals 中的每一个区间 intervals[i] = [a, b] 都表示满足 a <= x < b 的所有实数  x 的集合。

我们将 intervals 中任意区间与 toBeRemoved 有交集的部分都删除。

返回删除所有交集区间后， intervals 剩余部分的 有序 列表。



示例 1：

输入：intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
输出：[[0,1],[6,7]]
示例 2：

输入：intervals = [[0,5]], toBeRemoved = [2,3]
输出：[[0,2],[3,5]]


提示：

1 <= intervals.length <= 10^4
-10^9 <= intervals[i][0] < intervals[i][1] <= 10^9
 */
