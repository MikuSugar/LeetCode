package JavaCode.top_interview_questions_medium.sorting_and_searching;

import java.util.*;

public class Merge {
    /**
     * Definition for an interval.
     */

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            if(intervals.size()<=1) return intervals;

            //以start升序排列
            Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.start-o2.start;
                }
            });

            List<Interval> result=new ArrayList<>();//结果集
            Interval p=null;//结果集的最后一个指针
            for(Interval interval:intervals)
            {
                //区间不重复，添加到结果集末尾，更新指针
                if(p==null||p.end<interval.start)
                {
                    result.add(interval);
                    p=interval;
                }
                //区间重复，区间合并，更新指针指向的end
                else if(p.end<interval.end)
                {
                    p.end=interval.end;
                }
            }
            return result;
        }
    }
}
/**
 *https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/101/
 给出一个区间的集合，请合并所有重叠的区间。

 示例 1:

 输入: [[1,3],[2,6],[8,10],[15,18]]
 输出: [[1,6],[8,10],[15,18]]
 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2:

 输入: [[1,4],[4,5]]
 输出: [[1,5]]
 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
