package JavaCode.random_records.N401_500;

import java.util.Arrays;

public class N462_minimum_moves_to_equal_array_elements_ii {
    public int minMoves2(int[] nums) {
        int res=0;
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        while (left<right)
        {
            res+=nums[right--]-nums[left++];
        }
        return res;
    }
}
/**
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
 *
 * 例如:
 *
 * 输入:
 * [1,2,3]
 *
 * 输出:
 * 2
 *
 * 说明：
 * 只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
 *
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
