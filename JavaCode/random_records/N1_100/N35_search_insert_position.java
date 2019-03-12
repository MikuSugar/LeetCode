package JavaCode.random_records.N1_100;

public class N35_search_insert_position
{
    public int searchInsert(int[] nums, int target) {
        //极端情况
        if (nums.length==0||nums[0]>=target)return 0;
        if(nums[nums.length-1]<target) return nums.length;

        //二分
        int left=0;
        int right=nums.length-1;
        while (left<=right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)return mid;
            else if(nums[mid]>target)
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return nums[left]>target?left:left+1;
    }
}
/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
