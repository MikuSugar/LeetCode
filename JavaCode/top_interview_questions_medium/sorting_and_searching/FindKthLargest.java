package JavaCode.top_interview_questions_medium.sorting_and_searching;

public class FindKthLargest {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return fun0(nums,k);
        }

        //选择排序
        int fun0(int[] nums,int k)
        {
            for(int i=0;i<k;i++)
            {
                for(int j=i+1;j<nums.length;j++) {
                    if (nums[i] < nums[j]) {
                        swap(nums,i,j);
                    }
                }
            }
            return nums[k-1];
        }

        //冒泡排序
        int fun1(int[] nums,int k)
        {
            for(int i=nums.length-1;i>=nums.length-k;i--)
            {
                for(int j=0;j<i;j++)
                {
                    if(nums[j]>nums[j+1])
                    {
                        swap(nums,j,j+1);
                    }
                }
            }
            return nums[nums.length-k];
        }

        //

        /**
         * 交换数组中的两个元素
         * @param nums
         * @param i
         * @param j
         */
        void swap(int[] nums,int i,int j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/98/
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */

