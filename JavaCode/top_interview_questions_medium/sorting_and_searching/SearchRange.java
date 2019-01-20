package JavaCode.top_interview_questions_medium.sorting_and_searching;

import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {
        int[] t={5,7,7,8,10};
        System.out.println(Arrays.toString(new SearchRange().new Solution().searchRange(t,6)));
    }
    class Solution {

        public int[] searchRange(int[] nums, int target) {

            if(nums.length==1&&nums[0]==target) return new int[]{0,0};
            int[] ans={-1,-1};
            int left=0;
            int right=nums.length-1;
            int mid=nums.length/2;
            while (left<=right)
            {
                if(nums[mid]==target||nums[left]==target||nums[right]==target)
                {
                    if(nums[mid]==target) {
                        left = mid;
                        right = mid;
                    }
                    else if(nums[left]==target)
                    {
                        right=left;
                    }
                    else {
                        left=right;
                    }
                    while (left>=1)
                    {
                        if(nums[left-1]==target)
                        {
                            left--;
                        }
                        else
                        {
                            break;
                        }
                    }
                    while (right<nums.length-1)
                    {
                        if(nums[right+1]==target)
                        {
                            right++;
                        }
                        else
                        {
                            break;
                        }
                    }
                    ans[0]=left;
                    ans[1]=right;

                    break;
                }
                else if(nums[mid]>target)
                {
                    right=mid-1;
                    mid=(right+left)/2;
                }
                else if(nums[mid]<target)
                {
                    left=mid+1;
                    mid=(right+left)/2;

                }

            }

            return ans;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/100/
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
