package JavaCode.top_interview_questions_easy.design;

import java.util.Random;

public class ShuffleAnArray
{
    class Solution {

        private int[] nums;
        private Random random;
        public Solution(int[] nums) {
            this.nums=nums;
            random=new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] shuffle=new int[nums.length];
            System.arraycopy(nums,0,shuffle,0,nums.length);

            for(int i=0;i<nums.length;i++)
            {
                int r=i+random.nextInt(nums.length-i);
                int temp=shuffle[i];
                shuffle[i]=shuffle[r];
                shuffle[r]=temp;
            }
            return shuffle;
        }


/**
 * Your n2342 object will be instantiated and called as such:
 * n2342 obj = new n2342(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/24/design/58/
 * 打乱一个没有重复元素的数组。
 * 示例:
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * n2342 solution = new n2342(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
