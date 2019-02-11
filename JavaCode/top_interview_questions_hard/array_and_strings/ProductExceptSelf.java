package JavaCode.top_interview_questions_hard.array_and_strings;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] output=new int[nums.length];
        output[nums.length-1]=nums[nums.length-1];

        //后缀🐔
        for(int i=nums.length-2;i>=0;i--)
        {
            output[i]=output[i+1]*nums[i];
        }

        //前缀🐔
        for(int i=1;i<nums.length;i++)
        {
            nums[i]=nums[i]*nums[i-1];
        }

        output[0]=output[1];

        for(int i=1;i<nums.length-1;i++)
        {
            output[i]=nums[i-1]*output[i+1];
        }
        output[nums.length-1]=nums[nums.length-2];
        return output;
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/123/
 * Product of Array Except Self
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
