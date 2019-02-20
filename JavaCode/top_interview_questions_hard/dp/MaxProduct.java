package JavaCode.top_interview_questions_hard.dp;

public class MaxProduct {

    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        int[] dp=new int[nums.length];

        int t_max=nums[0];
        int t_min=nums[0];
        int ans=t_max;
        for (int i=1;i<nums.length;i++)
        {
            int pre_t_max=t_max;
            t_max=Math.max(nums[i],Math.max(t_max*nums[i],t_min*nums[i]));
            t_min=Math.min(nums[i],Math.min(pre_t_max*nums[i],t_min*nums[i]));
            ans=Math.max(ans,t_max);
        }
        return ans;
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/60/dynamic-programming/154/
 * 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
