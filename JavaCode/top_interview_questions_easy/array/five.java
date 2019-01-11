package JavaCode.top_interview_questions_easy.array;

public class five {

    public static void main(String[] args) {
        System.out.println(2^2);
    }

    class Solution {
        public int singleNumber(int[] nums) {
            /**
             * x,y;
             * 有 x^x=0;
             * y^0=y;
             */
            int ans=nums[0];
            for(int i=1;i<nums.length;i++)
            {
                ans^=nums[i];
            }
            return ans;
        }
    }
}
/**
 *
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
