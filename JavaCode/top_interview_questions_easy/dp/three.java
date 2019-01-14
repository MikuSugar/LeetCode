package JavaCode.top_interview_questions_easy.dp;

public class three
{
    class Solution {

        public int maxSubArray(int[] nums) {

            //dp[i]表示以第i个为结尾的最大和
            int[] dp=new int[nums.length];
            for(int i=0;i<nums.length;i++)
            {
                dp[i]=Integer.MIN_VALUE;
            }
            dp[0]=nums[0];
            int max=dp[0];
            for(int i=1;i<nums.length;i++)
            {
                dp[i]=Math.max(dp[i-1]+nums[i],dp[i]);
                max=Math.max(dp[i],max);
            }
            return max;

        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/56/
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
