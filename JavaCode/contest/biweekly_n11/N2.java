package JavaCode.contest.biweekly_n11;

import java.util.*;

/**
 * author:fangjie
 * time:2019/10/19
 */
public class N2 {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> res=new ArrayList<>(2);
        Comparator<int[]> mycm=(o1, o2)->{
            if (o1[0]==o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        };
        TreeSet<int[]> set=new TreeSet<>(mycm);
        for (int[] s:slots1)set.add(s);
        Arrays.sort(slots2,mycm);

        for (int[] s:slots2)
        {
            if(s[1]-s[0]<duration)continue;
            System.out.println(Arrays.toString(s));
            Set<int[]> sets=set.subSet(new int[]{0,s[0]+duration},true,new int[]{s[1]-duration,Integer.MAX_VALUE},true);
            for (int[] r:sets)
            {
                if(r[0]<=s[0]&&r[1]>=s[0]+duration)
                {
                    res.add(s[0]);
                    res.add(s[0]+duration);
                    return res;
                }
                else if(r[1]>s[0]&&r[1]-r[0]>=duration&&r[0]+duration<=s[1])
                {
                    res.add(r[0]);
                    res.add(r[0]+duration);
                    return res;
                }
            }
        }
        return res;

    }
}
/**
 *给你两位客户的可用时间间隔 slots1 和 slots2，以及会议的预计持续时间 duration，请你帮他们安排合适的会议时间。
 *
 * 「会议时间」是指用户都能够参加且持续时间满足预计时间 duration 的 最早的时间间隔 。
 *
 * 如果没有满足要求的会面时间，就返回一个 空数组 。
 *
 * 「时间间隔」的格式是 [start, end]，由两个元素 start 和 end 组成，表示从 start 开始，到 end 结束。
 *
 * 题目保证同一个人的可用时间间隔不会出现交叠的情况，也就是说，对于同一个人的两个时间间隔 [start1, end1] 和 [start2, end2]，要么 start1 > end2，要么 start2 > end1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * 输出：[60,68]
 * 示例 2：
 *
 * 输入：slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
 * 输出：[]
 *
 *
 * 提示：
 *
 * 1 <= slots1.length, slots2.length <= 10^4
 * slots1[i].length, slots2[i].length == 2
 * slots1[i][0] < slots1[i][1]
 * slots2[i][0] < slots2[i][1]
 * 0 <= slots1[i][j], slots2[i][j] <= 10^9
 * 1 <= duration <= 10^6
 */
