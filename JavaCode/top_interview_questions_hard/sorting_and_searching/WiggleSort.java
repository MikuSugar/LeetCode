package JavaCode.top_interview_questions_hard.sorting_and_searching;


public class WiggleSort {

    public void wiggleSort(int[] nums) {
       int[] temp=nums.clone();
        int cnt=(nums.length-1)/2;
        for(int i=0;i<nums.length;i+=2)
        {
            nums[i]=temp[cnt--];
        }
        cnt=nums.length-1;
        for (int i=1;i<nums.length;i+=2)
        {
            nums[i]=temp[cnt--];
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/59/sorting-and-searching/151/
 *  摆动排序 II
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 示例 1:
 *
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 *
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 *
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 */
