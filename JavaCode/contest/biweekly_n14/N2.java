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
           int flag=help(i,toBeRemoved);
           if(flag==-1)continue;
           switch (flag)
           {
               case 0:
                   res.add(getList(i[0],i[1]));
                   break;
               case 1:
                   res.add(getList(i[0],toBeRemoved[0]));
                   break;
               case 2:
                   res.add(getList(toBeRemoved[1],i[1]));
                   break;
               case 3:
                   res.add(getList(i[0],toBeRemoved[0]));
                   res.add(getList(toBeRemoved[1],i[1]));
                   break;
           }
        }
        return res;
    }

    private List<Integer> getList(int a,int b)
    {
        return new ArrayList<Integer>(2){{add(a);add(b);}};
    }

    private int  help(int[] a, int[] b) {
        if(a[0]>=b[0]&&a[1]<=b[1])return -1;
        if(a[1]<=b[0]||a[0]>=b[1]) return 0;
        else if(a[0]<b[0]&&a[1]<=b[1]) return 1;
        else if(a[0]>=b[0]) return 2;
        return 3;
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
