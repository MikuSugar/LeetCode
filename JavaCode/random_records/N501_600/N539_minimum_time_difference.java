package JavaCode.random_records.N501_600;

import java.util.Arrays;
import java.util.List;

public class N539_minimum_time_difference {
    public int findMinDifference(List<String> timePoints) {
        int[] times=new int[timePoints.size()];
        int idx=0;
        for (String s:timePoints)
        {
            times[idx++]=getMinute(s);
        }
        Arrays.sort(times);
        int res=times[0]+24*60-times[times.length-1];
        for (int i=1;i<times.length;i++)
        {
            res=Math.min(times[i]-times[i-1],res);
        }
        return res;
    }

    private int getMinute(String s) {
        String[] strs=s.split(":");
        return Integer.parseInt(strs[0])*60+Integer.parseInt(strs[1]);
    }
}
/**
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
 *
 *
 * 示例 1：
 *
 * 输入: ["23:59","00:00"]
 * 输出: 1
 *
 * 备注:
 *
 * 列表中时间数在 2~20000 之间。
 * 每个时间取值在 00:00~23:59 之间。
 */
