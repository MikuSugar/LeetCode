package JavaCode.random_records.N1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2019/10/30
 */
public class N57_insert_interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>(intervals.length);
        int idx=0;
        while (idx<intervals.length)
        {
            int[] cur=intervals[idx];
            int flag=check(cur,newInterval);
            if(flag==0)res.add(cur);
            else if(flag==1)
            {
                res.add(newInterval.clone());
                res.add(cur);
                newInterval[0]=-1;
            }
            else if(flag==-1)
            {
                break;
            }
            else if(flag==2)
            {
                newInterval=merge(cur,newInterval);
            }
            idx++;
        }
        while (idx<intervals.length)
        {
            res.add(intervals[idx++]);
        }
        if(newInterval[0]!=-1)res.add(newInterval);
        int[][] ans=new int[res.size()][2];
        res.toArray(ans);
        return ans;
    }

    private int[] merge(int[] cur, int[] newInterval) {
        int[] res=new int[2];
        res[0]=Math.min(cur[0],newInterval[0]);
        res[1]=Math.max(cur[1],newInterval[1]);
        return res;
    }

    private int  check(int[] cur, int[] newInterval) {
        if(newInterval[0]==-1)return -1;
        if(cur[1]<newInterval[0])return 0;
        if(cur[0]>newInterval[1])return 1;
        return 2;
    }
}
/*
给出一个无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例 1:

输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
输出: [[1,5],[6,9]]
示例 2:

输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出: [[1,2],[3,10],[12,16]]
解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/insert-interval
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
