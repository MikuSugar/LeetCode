package JavaCode.contest.weekly.n201_300.n201;

import utils.Parse;

import java.util.*;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/8/9 10:29 上午
 */
public class N3 {
    public static void main(String[] args) {
        System.out.println(new N3().maxNonOverlapping(Parse.parseToIntArray("[-1,3,5,1,4,2,-9]"),6));
    }
    public int maxNonOverlapping(int[] nums, int target) {
        int res=0,sum=0;
        int last=-2;
        Map<Integer, Queue<Integer>> map=new HashMap<>();
        map.put(0,new ArrayDeque<>());
        map.get(0).offer(-1);
        for (int i=0;i<nums.length;i++)
        {
            sum+=nums[i];

            if(map.containsKey(sum-target))
            {
                Queue<Integer> queue=map.get(sum-target);
                while (!queue.isEmpty())
                {
                    int cur=queue.poll();
                    if(cur>=last)
                    {
                        res++;
                        last=i;
                        break;
                    }
                }
            }
            map.putIfAbsent(sum,new ArrayDeque<>());
            map.get(sum).offer(i);
        }
        return res;
    }
}
/*
给你一个数组 nums 和一个整数 target 。

请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。



示例 1：

输入：nums = [1,1,1,1,1], target = 2
输出：2
解释：总共有 2 个不重叠子数组（加粗数字表示） [1,1,1,1,1] ，它们的和为目标值 2 。
示例 2：

输入：nums = [-1,3,5,1,4,2,-9], target = 6
输出：2
解释：总共有 3 个子数组和为 6 。
([5,1], [4,2], [3,5,1,4,2,-9]) 但只有前 2 个是不重叠的。
示例 3：

输入：nums = [-2,6,6,3,5,4,1,2,8], target = 10
输出：3
示例 4：

输入：nums = [0,0,0], target = 0
输出：3


提示：

1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
0 <= target <= 10^6
 */
