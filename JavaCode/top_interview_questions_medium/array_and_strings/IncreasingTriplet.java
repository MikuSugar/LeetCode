package JavaCode.top_interview_questions_medium.array_and_strings;

public class IncreasingTriplet
{
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int x,y,z;

            if(nums.length<3)
            {
                return false;
            }
            x=nums[0];
            y=Integer.MAX_VALUE;

            for(int i=1;i<nums.length;i++)
            {
                z=nums[i];
                if(z>x&&z>y)
                {
                    return true;
                }
                else if(z<x)
                {
                    x=z;
                }
                else if(z>x&&z<y)
                {
                    y=z;
                }
            }
            return false;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/80/
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * 数学表达式如下:
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
