package JavaCode.contest.n168;

import java.util.*;

/**
 * author:fangjie
 * time:2019/12/22
 */
public class N2 {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0)return false;
        Map<Integer,Integer> map=new HashMap<>(nums.length/2+5);
        for (int i:nums)map.put(i,map.getOrDefault(i,0)+1);
        List<int[]> list=new ArrayList<>(map.size());
        for (Map.Entry<Integer,Integer> e:map.entrySet())
        {
            list.add(new int[]{e.getKey(),e.getValue()});
        }
        list.sort(Comparator.comparingInt(o->o[0]));
        int start=0;
        while (start<list.size())
        {
            int cnt=list.get(start)[1];
            list.get(start)[1]-=cnt;
            for (int i=start+1;i<start+k;i++)
            {
                if(i>=list.size())return false;
                int[] cur=list.get(i);
                if(cur[0]!=list.get(i-1)[0]+1||cur[1]<cnt)return false;
                cur[1]-=cnt;
            }
            int next=0;
            for (int i=start+1;i<start+k;i++)
            {
                if(list.get(i)[1]>0)
                {
                    next=i;
                    break;
                }
            }
            if(next==0)start=start+k;
            else start=next;
        }
        return true;
    }
}
/*
给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
如果可以，请返回 True；否则，返回 False。



示例 1：

输入：nums = [1,2,3,3,4,4,5,6], k = 4
输出：true
解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
示例 2：

输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
输出：true
解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
示例 3：

输入：nums = [3,3,2,2,1,1], k = 3
输出：true
示例 4：

输入：nums = [1,2,3,4], k = 3
输出：false
解释：数组不能分成几个大小为 3 的子数组。


提示：

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= nums.length
 */
