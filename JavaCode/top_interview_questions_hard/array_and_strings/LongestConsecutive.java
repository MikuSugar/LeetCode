package JavaCode.top_interview_questions_hard.array_and_strings;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set =new HashSet<>();
        for(int i:nums)
        {
            set.add(i);
        }

        int max=0;
        for(int i:nums)
        {

            if(set.contains(i))
            {
                int count=0;
                count++;
                set.remove(i);
                int left=i-1;
                while (set.contains(left))
                {
                    count++;
                    set.remove(left--);
                }
                int right=i+1;
                while (set.contains(right))
                {
                    count++;
                    set.remove(right++);
                }
                max=Math.max(max,count);
            }
        }
        return max;
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/129/
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
