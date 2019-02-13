package JavaCode.top_interview_questions_hard.array_and_strings;

import java.util.*;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) return new int[]{};
        List<Integer> list=new ArrayList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<k;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],1);
            }
            else
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        list.add(map.lastKey());
        for(int i=k;i<nums.length;i++)
        {
            int temp=map.get(nums[i-k]);
            if(temp==1)
            {
                map.remove(nums[i-k]);
            }
            else
            {
                map.put(nums[i-k],temp-1);
            }
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],1);
            }
            else
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
            list.add(map.lastKey());
        }

        int[] result=new int[list.size()];
        for (int i=0;i<list.size();i++)
        {
            result[i]=list.get(i);
        }
        return result;
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/132/
 * Sliding Window Maximum
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 注意：
 *
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 */
