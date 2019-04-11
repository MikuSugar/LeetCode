package JavaCode.random_records.N501_600;

public class N540_single_element_in_a_sorted_array {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1)return nums[0];
        for (int i=1;i<nums.length;i+=2)
        {
            if(nums[i]!=nums[i-1])
            {
                return nums[i-1];
            }
        }
        return -1;
    }
}
/**
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 */
